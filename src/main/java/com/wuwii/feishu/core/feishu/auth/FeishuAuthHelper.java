package com.wuwii.feishu.core.feishu.auth;

import com.wuwii.feishu.api.auth.AuthApi;
import com.wuwii.feishu.domain.Authorization;
import com.wuwii.feishu.domain.FeishuProperties;
import com.wuwii.feishu.domain.auth.AppIdReq;
import com.wuwii.feishu.domain.auth.AuthR;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 处理飞书认证的事情
 * 1. 认证
 * 2. 刷新token
 * @author kai.zhang
 * @date 2023/2/24 19:21
 */
@Data
@RequiredArgsConstructor
public class FeishuAuthHelper {

    @Nullable
    private static volatile Authorization defaultAuth;

    private static final Lock LOCK = new ReentrantLock();

    private static final Lock DELAY_LOCK = new ReentrantLock();


    private static final long REFRESH_EXPIRE_SECONDS = 30;

    private final AuthApi authApi;

    private final FeishuProperties feishuProperties;



    public Authorization getAuth() {
        AppIdReq req = new AppIdReq();
        req.setApp_id(feishuProperties.getAppId());
        req.setApp_secret(feishuProperties.getAppSecret());
        return getAuth(req);
    }

    public Authorization getAuth(AppIdReq req) {
        Authorization authorization = defaultAuth;
        if (authorization == null) {
            return refreshAuth(req);
        }
        int readyRefresh = isReadyRefresh(authorization);
        if (readyRefresh == 0) {
            return authorization;
        }
        if (readyRefresh == 1) {
            delayRefresh(req);
            return authorization;
        }
        if (readyRefresh == 2) {
            return refreshAuth(req);
        }
        return authorization;
    }

    private void delayRefresh(AppIdReq req) {
        if (DELAY_LOCK.tryLock()) {
            try {
                new Thread(() -> getAuthorization(req));
            } finally {
                DELAY_LOCK.unlock();
            }
        }
    }

    /**
     * 是否需要去刷新token
     * @param authorization
     * @return 0 有效期内，1 有效期内，但是30分钟后失效，2已过期
     */
    private int isReadyRefresh(Authorization authorization) {
        LocalDateTime expireTime = authorization.getExpire_time();
        LocalDateTime now = LocalDateTime.now();
        if (expireTime.isAfter(now)) {
            return 2;
        }
        LocalDateTime refreshTime = now.plus(-REFRESH_EXPIRE_SECONDS, ChronoUnit.MINUTES);
        if (expireTime.isAfter(refreshTime)) {
            return 1;
        }
        return 0;
    }

    /**
     * 刷新token
     * @param appIdReq
     * @return
     */
    private Authorization refreshAuth(AppIdReq appIdReq) {
        String appId = appIdReq.getApp_id();
        if (LOCK.tryLock()) {
            try {
                // 刷新 token
                Authorization authorization = defaultAuth;
                if (authorization == null) {
                    // 获取token
                    return getAuthorization(appIdReq);
                }
                if (authorization.getExpire_time().isAfter(LocalDateTime.now())) {
                    return getAuthorization(appIdReq);
                }
                return authorization;
            } finally {
                LOCK.unlock();
            }
        }
        throw new RuntimeException("刷新token失败，appId=" + appId);
    }

    private Authorization getAuthorization(AppIdReq appIdReq) {
        Authorization authorization;
        AuthR appAccessToken = authApi.getAppAccessToken(appIdReq);
        checkAuthR(appAccessToken);
        String appId = appIdReq.getApp_id();
        authorization = new Authorization();
        authorization.setApp_id(appId);
        authorization.setApp_secret(appIdReq.getApp_secret());
        authorization.setApp_access_token(appAccessToken.getApp_access_token());
        authorization.setTenant_access_token(appAccessToken.getTenant_access_token());
        authorization.setExpire_time(LocalDateTime.now().plus(appAccessToken.getExpire(), ChronoUnit.MINUTES));
        defaultAuth = authorization;
        return authorization;
    }

    private void checkAuthR(AuthR appAccessToken) {
        // todo: @zhangkai 2023/2/28 检查认证的返回值
        if (appAccessToken.getCode() != 0) {
            throw new RuntimeException("获取access_token失败，请填写正确的值，当前token=" + appAccessToken);
        }
    }


}
