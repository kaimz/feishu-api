package com.wuwii.feishu.domain.excel;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/28 18:00
 */
@Data
public class ExcelSpreadsheetR implements Serializable {

    @Serial
    private static final long serialVersionUID = -9140173501619625935L;
    private String folder_token;

    private String spreadsheet_token;

    private String title;

    private String url;
}
