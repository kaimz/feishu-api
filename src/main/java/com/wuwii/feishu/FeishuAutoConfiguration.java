package com.wuwii.feishu;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuwii.feishu.api.auth.AuthApi;
import com.wuwii.feishu.core.feishu.FeishuClient;
import com.wuwii.feishu.core.feishu.auth.FeishuAuthHelper;
import com.wuwii.feishu.core.rest.OkHttpConfig;
import com.wuwii.feishu.core.rest.RestClient;
import com.wuwii.feishu.domain.FeishuProperties;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author kai.zhang
 * @date 2023/2/23 18:41
 */
@Configuration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@ImportAutoConfiguration({OkHttpConfig.class})
@EnableConfigurationProperties(FeishuProperties.class)
@ComponentScan("com.wuwii.feishu.api")
public class FeishuAutoConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    public FeishuAuthHelper feishuAuthHelper(AuthApi authApi, FeishuProperties feishuProperties) {
        return new FeishuAuthHelper(authApi, feishuProperties);
    }

    @Bean
    public FeishuClient feishuClient(RestClient restClient, FeishuAuthHelper feishuAuthHelper) {
        return new FeishuClient(restClient, feishuAuthHelper);
    }


}
