package com.wuwii.feishu.domain.auth;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:16
 */
@Data
public class AuthR implements Serializable {


    @Serial
    private static final long serialVersionUID = 5285467973367526457L;
    /**
     * code 为0 代表请求成功
     */
    private int code = 0;

    /**
     * 返回信息， ok or error msg
     */
    private String msg;

    /**
     * token 过期时间，单位：秒
     */
    private Integer expire;

    private String tenant_access_token;

    private String app_access_token;
}
