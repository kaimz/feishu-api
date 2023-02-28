package com.wuwii.feishu.core.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kai.zhang
 * @date 2023/2/6 17:06
 */
@ConfigurationProperties(prefix = "wuwii.okhttp")
@Data
public class OkHttpProperties {

    private Integer connectTimeout = 1;

    private Integer readTimeout = 3;

    /**
     *
     */
    private Integer writeTimeout = 3;

    /**
     * 连接池中整体的空闲连接的最大数量
     * 默认200
     */
    private Integer maxIdleConnections = 200;

    /**
     * 最大连接空闲时间，单位秒，默认300
     */
    private Long keepAliveDuration = 300L;

}
