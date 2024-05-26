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
@ApiModel(value = "清除检验检查消息",description="清除检验检查消息")
@Data
public class CleanReadMessageParamDTO {
    @ApiModelProperty(value = "检验检查单主键ID")
    private String inspectionChecklistId;
}
