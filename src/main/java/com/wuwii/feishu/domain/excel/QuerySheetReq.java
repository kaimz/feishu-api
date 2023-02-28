package com.wuwii.feishu.domain.excel;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/28 18:27
 */
@Data
public class QuerySheetReq implements Serializable {
    @Serial
    private static final long serialVersionUID = -8680278476750255694L;
    private String spreadsheet_token;

}
