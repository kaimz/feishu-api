package com.wuwii.feishu.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kai.zhang
 * @date 2023/2/24 19:13
 */
@Data
@ConfigurationProperties(prefix = "wuwii.feishu")
public class FeishuProperties {

    private String appId;

    private String appSecret;

}
