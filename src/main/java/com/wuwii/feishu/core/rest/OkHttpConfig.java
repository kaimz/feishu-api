package com.wuwii.feishu.core.rest;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author kai.zhang
 * @date 2023/2/6 17:05
 */
@EnableConfigurationProperties({OkHttpProperties.class})
@Configuration
public class OkHttpConfig {

    @Bean
    public static OkHttpClient okHttpClient(OkHttpProperties okHttpProperties){
        return new OkHttpClient().newBuilder()
                .connectionPool(pool(okHttpProperties))
                .connectTimeout(okHttpProperties.getConnectTimeout(), TimeUnit.SECONDS)
                .readTimeout(okHttpProperties.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(okHttpProperties.getWriteTimeout(), TimeUnit.SECONDS)
                .hostnameVerifier((hostname, session) -> true)
                // 设置代理
//              .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888)))
                // 拦截器
//                .addInterceptor()
                .build();
    }

    @Bean
    public RestClient restClient(OkHttpClient okHttpClient) {
        return new RestClient(okHttpClient);
    }

    private static ConnectionPool pool(OkHttpProperties okHttpProperties) {
        return new ConnectionPool(okHttpProperties.getMaxIdleConnections(),
                okHttpProperties.getKeepAliveDuration(), TimeUnit.SECONDS);
    }
}
