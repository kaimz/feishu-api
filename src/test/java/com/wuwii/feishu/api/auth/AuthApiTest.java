package com.wuwii.feishu.api.auth;

import com.wuwii.feishu.BaseTest;
import com.wuwii.feishu.domain.FeishuProperties;
import com.wuwii.feishu.domain.auth.AppIdReq;
import com.wuwii.feishu.domain.auth.AuthR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kai.zhang
 * @date 2023/2/27 13:59
 */
class AuthApiTest extends BaseTest {

    @Autowired
    private FeishuProperties feishuProperties;
    @Autowired
    private AuthApi authApi;


    @Test
    void getAppAccessToken() {
        AppIdReq appIdReq = new AppIdReq();
        appIdReq.setApp_id(feishuProperties.getAppId());
        appIdReq.setApp_secret(feishuProperties.getAppSecret());
        AuthR appAccessToken = authApi.getAppAccessToken(appIdReq);
        Assertions.assertNotNull(appAccessToken);
        Assertions.assertEquals(appAccessToken.getCode(), 0);
    }
}