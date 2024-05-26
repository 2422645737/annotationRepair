package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @fileName: LisLabItemQueryDTO
 * @author: llx
 * @createAt: 2023/7/11 20:32
 * @updateBy: llx
 * @remark: 众阳健康
 */
@Data
@ApiModel(value = "组合项目编码",description="组合项目编码")
public class LisLabItemQueryDTO {

    @ApiModelProperty(value = "实验项目IDList")
    private List<Long> labItemIdList;
    @ApiModelProperty(value = "医院ID")
    private Long hospitalId;
}
