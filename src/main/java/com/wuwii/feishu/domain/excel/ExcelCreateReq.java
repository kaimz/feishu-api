package com.wuwii.feishu.domain.excel;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kai.zhang
 * @date 2023/2/24 18:19
 */
@Data
public class ExcelCreateReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -8001713272522797106L;
    private String title;

    private String folder_token;

}
