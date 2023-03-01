/**
 * @author kai.zhang
 * @date 2023/2/16 10:38
 */
module wuwii.feishu {
    opens com.wuwii.feishu.api.docs;
    opens com.wuwii.feishu.api.auth;
    exports com.wuwii.feishu.api.docs;
    exports com.wuwii.feishu.api.auth;
    exports com.wuwii.feishu.domain;
    exports com.wuwii.feishu.domain.auth;
    exports com.wuwii.feishu.domain.excel;
    opens com.wuwii.feishu.core.feishu;
    opens com.wuwii.feishu.core.feishu.auth;
    opens com.wuwii.feishu.core.rest;
    opens com.wuwii.feishu;

    requires static lombok;
    requires spring.boot;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.core;
    requires spring.context;

    requires okhttp3;
    requires org.slf4j;

    requires com.fasterxml.jackson.databind;

    requires kotlin.stdlib;
}