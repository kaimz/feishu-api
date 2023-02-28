package com.wuwii.feishu.api.docs;

import com.wuwii.feishu.BaseTest;
import com.wuwii.feishu.domain.Wrapper;
import com.wuwii.feishu.domain.excel.ExcelCreateReq;
import com.wuwii.feishu.domain.excel.ExcelSheetListR;
import com.wuwii.feishu.domain.excel.ExcelSpreadsheetR;
import com.wuwii.feishu.domain.excel.QuerySheetReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kai.zhang
 * @date 2023/2/28 17:38
 */
class ExcelApiTest extends BaseTest {
    @Autowired
    private ExcelApi excelApi;

    @Test
    void createExcelForSuccess() {
        ExcelCreateReq req = new ExcelCreateReq();
        req.setFolder_token("fldcnZlhidWytDGnCw9tSZ6P2rc");
        req.setTitle("title");
        Wrapper<ExcelSpreadsheetR> excel = excelApi.createExcel(req);
        Assertions.assertNotNull(excel);
        Assertions.assertEquals(excel.getCode(), 0);
    }

    @Test
    void querySheets() {
        QuerySheetReq req = new QuerySheetReq();
        req.setSpreadsheet_token("shtcnozK1xs0vt3OBi23ur32n0e");
        Wrapper<ExcelSheetListR> excel = excelApi.querySheets(req);
        Assertions.assertNotNull(excel);
        Assertions.assertEquals(excel.getCode(), 0);
    }
}