package com.wuwii.feishu.core.feishu;

import com.wuwii.feishu.core.feishu.auth.FeishuAuthHelper;
import com.wuwii.feishu.core.rest.RestClient;
import com.wuwii.feishu.domain.Authorization;
import okhttp3.Headers;

/**
 * @author kai.zhang
 * @date 2023/2/27 15:00
 */
public class FeishuClient {
    private final RestClient restClient;

    private final FeishuAuthHelper feishuAuthHelper;

    public FeishuClient(RestClient restClient, FeishuAuthHelper feishuAuthHelper) {
        this.restClient = restClient;
        this.feishuAuthHelper = feishuAuthHelper;
    }

    public String get(String url, boolean auth) {
        if (!auth) {
            return restClient.get(url, Headers.of());
        }
        return restClient.get(url, getAuthHeader());
    }

    public String post(String url, String jsonRequestBody, boolean auth) {
        if (!auth) {
            return restClient.post(url, jsonRequestBody, Headers.of());
        }
        Headers authorizationHeader = getAuthHeader();
        return restClient.post(url, jsonRequestBody, authorizationHeader);
    }

    private Headers getAuthHeader() {
        Authorization authorization = feishuAuthHelper.getAuth();
        String appAccessToken = authorization.getApp_access_token();
        return Headers.of("Authorization", "Bearer " + appAccessToken);
    }


}
