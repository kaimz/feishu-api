package com.wuwii.feishu.domain.excel;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author kai.zhang
 * @date 2023/2/28 18:43
 */
@Data
public class ExcelSheetListR implements Serializable {

    @Serial
    private static final long serialVersionUID = 8376701841481151226L;
    private List<ExcelSheetR> sheets;

    private String resource_type;


    @Data
    public static class ExcelSheetR implements Serializable {

        @Serial
        private static final long serialVersionUID = 1119805342394654123L;

        private String sheet_id;

        private String title;

        private int index;
    }
}
