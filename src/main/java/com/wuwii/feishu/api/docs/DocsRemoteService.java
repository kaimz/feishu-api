package com.wuwii.feishu.api.docs;


import com.wuwii.feishu.domain.FeishuMethod;

import static com.wuwii.feishu.domain.FeishuMethod.HttpMethod.*;


/**
 * @author kai.zhang
 * @date 2023/2/24 18:34
 */
interface DocsRemoteService {

    /**
     * 指定目录下创建表格，可以获取 spreadsheetToken
     * https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet/create
     *
     */
    FeishuMethod create_excel_v3 = FeishuMethod.of(POST, "/open-apis/sheets/v3/spreadsheets");

    /**
     * 操作工作表
     * https://open.feishu.cn/document/ukTMukTMukTM/uYTMzUjL2EzM14iNxMTN
     */
    @Deprecated
    FeishuMethod batch_update_sheet_v2 = FeishuMethod.of(POST, "/open-apis/sheets/v2/spreadsheets/:spreadsheetToken/sheets_batch_update");

    /**
     * 获取工作表，主要是获取 sheetId
     * https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/sheets-v3/spreadsheet-sheet/query
     */
    FeishuMethod query_sheets_v3 = FeishuMethod.of(GET, "/open-apis/sheets/v3/spreadsheets/:spreadsheet_token/sheets/query");

    /**
     * 表格里插入数据
     *
     * https://open.feishu.cn/document/ukTMukTMukTM/uIjMzUjLyIzM14iMyMTN
     * 该接口用于根据 spreadsheetToken 和 range 向范围之前增加相应数据的行和相应的数据，相当于数组的插入操作；单次写入不超过5000行，100列，每个格子不超过5万字符。
     */
    FeishuMethod values_prepend_v2 = FeishuMethod.of(POST, "/open-apis/sheets/v2/spreadsheets/:spreadsheetToken/values_prepend");

    /**
     * 表格里添加数据
     *
     * https://open.feishu.cn/document/ukTMukTMukTM/uMjMzUjLzIzM14yMyMTN
     * 该接口用于在已有数据的末尾追加写入给定的数据。该接口会从给定的range中的起始行列开始向下寻找（如range为"sheet1!A1:B2",将会依次寻找A1、A2、A3...）
     * ，找到第一个空白位置后将数据写入到该区域。单次写入不得超过5000行，100列，每个格子不得超过5万字符。
     */
    FeishuMethod values_append_v2 = FeishuMethod.of(POST, "/open-apis/sheets/v2/spreadsheets/:spreadsheetToken/values_append");



}
