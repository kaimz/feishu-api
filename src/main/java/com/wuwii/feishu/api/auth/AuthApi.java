package com.wuwii.feishu.api.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuwii.feishu.core.rest.RestClient;
import com.wuwii.feishu.domain.auth.AppIdReq;
import com.wuwii.feishu.domain.auth.AuthR;
import lombok.SneakyThrows;
import okhttp3.Headers;
import org.springframework.stereotype.Service;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:16
 */
@Service
public class AuthApi {
    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public AuthApi(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows(JsonProcessingException.class)
    public AuthR getAppAccessToken(AppIdReq appIdReq) {
        String json = restClient.post(AuthService.app_auth_v3.getUrl(), objectMapper.writeValueAsString(appIdReq), Headers.of());
        return objectMapper.readValue(json, AuthR.class);
    }

}
