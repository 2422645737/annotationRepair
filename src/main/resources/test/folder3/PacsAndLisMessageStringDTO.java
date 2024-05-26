package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @fileName: PacsAndLisMessageVO
 * @author: wanghui
 * @createAt: 2023/08/24 04:04:29
 * @updateBy:
 * @copyright: 众阳健康
 */
@ApiModel(value = "检验检查消息",description="检验检查消息")
@Data
public class PacsAndLisMessageStringDTO {
    @ApiModelProperty(value = "检验检查单主键ID")
    private String inspectionChecklistId;

    @ApiModelProperty(value = "1 检验  2检查")
    private Integer messageType;

    @ApiModelProperty(value = "患者id")
    private String patId;

    @ApiModelProperty(value = "机构id")
    private String orgId;

    @ApiModelProperty(value = "医院id")
    private String hospitalId;

    @ApiModelProperty(value = "就诊记录集合")
    private String outVisitRecordId;

}
