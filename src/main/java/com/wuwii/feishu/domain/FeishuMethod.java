package com.wuwii.feishu.domain;


import com.wuwii.feishu.api.Constants;
import com.wuwii.feishu.utils.PlaceholderUtils;
import lombok.RequiredArgsConstructor;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:09
 */
@RequiredArgsConstructor(staticName = "of")
public class FeishuMethod {

    private final HttpMethod method;

    private final String path;

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getUrl() {
        return Constants.FEISHU_OPEN_DOMAIN + path;
    }

    public String getUrl(String... params) {
        return Constants.FEISHU_OPEN_DOMAIN + PlaceholderUtils.replace(path, params);
    }

    public enum HttpMethod {
        GET,POST,PUT,DELETE
        ;

        HttpMethod() {
        }
    }
}
