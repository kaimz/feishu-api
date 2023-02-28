package com.wuwii.feishu.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kai.zhang
 * @date 2023/2/28 19:26
 */
class PlaceholderUtilsTest {

    @Test
    void replace() {
        String url = "/open-apis/sheets/v2/spreadsheets/:spreadsheetToken/values_append/:xxxx/:aaaa";
        String replace = PlaceholderUtils.replace(url, "hahah", "hahah2", "hahah3");
        System.out.println(replace);
    }
}