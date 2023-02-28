package com.wuwii.feishu.api.auth;

import com.wuwii.feishu.domain.FeishuMethod;

import static com.wuwii.feishu.domain.FeishuMethod.HttpMethod.POST;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:09
 */
interface AuthService {
    FeishuMethod app_auth_v3 = FeishuMethod.of(POST, "/open-apis/auth/v3/app_access_token/internal");



}
