package com.wuwii.feishu.api.docs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuwii.feishu.core.feishu.FeishuClient;
import com.wuwii.feishu.domain.Wrapper;
import com.wuwii.feishu.domain.excel.ExcelCreateReq;
import com.wuwii.feishu.domain.excel.ExcelSheetListR;
import com.wuwii.feishu.domain.excel.ExcelSpreadsheetR;
import com.wuwii.feishu.domain.excel.QuerySheetReq;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @author kai.zhang
 * @date 2023/2/24 18:17
 */
@Service
public class ExcelApi {

    private final FeishuClient feishuClient;
    private final ObjectMapper objectMapper;

    public ExcelApi(FeishuClient feishuClient, ObjectMapper objectMapper) {
        this.feishuClient = feishuClient;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows(JsonProcessingException.class)
    public Wrapper<ExcelSpreadsheetR> createExcel(ExcelCreateReq req) {
        String response = feishuClient.post(DocsRemoteService.create_excel_v3.getUrl(), objectMapper.writeValueAsString(req), true);
        return objectMapper.readValue(response, new TypeReference<>() {});

    }

    @SneakyThrows(JsonProcessingException.class)
    public Wrapper<ExcelSheetListR> querySheets(QuerySheetReq req) {
        String spreadsheetToken = req.getSpreadsheet_token();
        String response = feishuClient.get(DocsRemoteService.query_sheets_v3.getUrl(spreadsheetToken), true);
        return objectMapper.readValue(response, new TypeReference<>() {});
    }

}
