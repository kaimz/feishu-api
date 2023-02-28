package com.wuwii.feishu.core.feishu.auth;

import java.lang.annotation.*;

/**
 * @author kai.zhang
 * @date 2023/2/27 17:22
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {

}
