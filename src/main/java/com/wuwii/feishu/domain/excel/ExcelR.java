package com.wuwii.feishu.domain.excel;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/24 18:26
 */
@Data
public class ExcelR implements Serializable {

    @Serial
    private static final long serialVersionUID = -961891132531934068L;

    private ExcelSpreadsheetR spreadsheet;
}
