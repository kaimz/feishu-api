package com.wuwii.feishu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kai.zhang
 * @date 2023/2/28 19:04
 */
public class PlaceholderUtils {
    private PlaceholderUtils () {}

    private static final Pattern pattern = Pattern.compile(":(?<param>.+?/|.+)");

    public static String replace(String string, String... params) {
        if (params == null || params.length == 0) {
            return string;
        }
        Matcher matcher = pattern.matcher(string);
        int paramIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String group = matcher.group("param");
            String param = params[paramIndex];
            if (group.contains("/")) {
                param += "/";
            }
            matcher.appendReplacement(sb, param);
            paramIndex++;
        }
        // 最后一次匹配的内容加到sb中,因为不加这个方法，后面没有匹配的内容的将没有加上
        matcher.appendTail(sb);
        return sb.toString();
    }
}
