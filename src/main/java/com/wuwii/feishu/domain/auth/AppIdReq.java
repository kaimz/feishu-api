package com.wuwii.feishu.domain.auth;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:17
 */
@Data
public class AppIdReq implements Serializable {
    @Serial
    private static final long serialVersionUID = -2084356733117064766L;
    private String app_id;

    private String app_secret;

}
