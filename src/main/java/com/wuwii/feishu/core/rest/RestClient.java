package com.wuwii.feishu.core.rest;

import okhttp3.*;

import java.io.IOException;

/**
 * @author kai.zhang
 * @date 2023/2/14 10:41
 */
public class RestClient {
    private final OkHttpClient okHttpClient;

    public RestClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public String get(String url, Headers headers)  {
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.78"
                )
                .get()
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("get resources fail." + url);
            }
            ResponseBody body = response.body();
            return body == null ? "" : body.string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String post(String url, String jsonRequestBody, Headers headers)  {
        RequestBody requestBody = RequestBody.create(jsonRequestBody, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.78"
                )
                .addHeader("content-type", "application/json")
                .post(requestBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("get resources fail." + url);
            }
            ResponseBody body = response.body();
            return body == null ? "" : body.string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
