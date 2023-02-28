/**
 * @author kai.zhang
 * @date 2023/2/16 10:38
 */
module wuwii.feishu {
    exports com.wuwii.feishu;
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