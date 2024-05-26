package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @fileName PdfConversionDTO.java
 * @author miao
 * @createAt 2024-02-23 13:53
 * @updateBy miao
 * @remark 无
 * @version 1.50.0
 */

@ApiModel(description = "参数DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdfConversionDTO implements Serializable {
    /**
     * 打印模板
     */
    private String grfDataStr;
    /**
     * 数据json
     */
    private String dataJson;
    /**
     * 打印类型
     */
    private String typeText;
    /**
     * 打印配置//可选
     */
    private String printSet;
    /**
     * 数据字段类型说明//可选
     */
    private String dataColumnType;
    /**
     * 系统参数，医院名称等信息//新版打印需传此参数，此参数在打印平台获取模板接口中获取
     */
    private String sysInfo;
    /**
     * 报表名称
     */
    private String reportName;
    /**
     * 1代表新版打印，0或者空都代表瑞浪打印
     */
    private String designerType;
}