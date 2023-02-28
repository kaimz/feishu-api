package com.wuwii.feishu.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author kai.zhang
 * @date 2023/2/24 18:37
 */
@Data
public class Authorization {

    private String app_id;

    private String app_secret;
    private String tenant_access_token;

    private String app_access_token;

    /**
     * 过期时间，单位：秒
     */
    private LocalDateTime expire_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return Objects.equals(app_id, that.app_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app_id);
    }
}
