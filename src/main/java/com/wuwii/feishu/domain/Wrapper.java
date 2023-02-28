package com.wuwii.feishu.domain;

import lombok.Data;

/**
 * @author kai.zhang
 * @date 2023/2/24 18:24
 */
@Data
public class Wrapper<T> {

    /**
     * code 为0 代表请求成功
     */
    private int code = 0;

    private T data;

    /**
     * 返回信息，success /  ok
     */
    private String msg;

    private Integer expire;

    private String tenant_access_token;

}
