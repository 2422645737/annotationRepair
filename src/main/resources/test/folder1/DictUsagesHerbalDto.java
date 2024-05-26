package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.msun.core.commons.api.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
* @description: 中药小用法
* @fileName:  DictUsagesHerbalDto
* @author: zhy
* @createAt: 2023/11/15 18:04
* @updateBy: zhy
* @remark: 众阳健康
*/
@Data
@ApiModel(description = "参数DTO")
@EqualsAndHashCode(callSuper = true)
public class DictUsagesHerbalDto extends BaseDTO {
    /**
     * 草药小用法ID
     */
    @ApiModelProperty(value = "草药小用法ID")
    private Long dictUsagesHerbalId;

    /**
     * 草药小用法名称
     */
    @ApiModelProperty(value = "草药小用法名称")
    private String dictUsagesHerbalName;

}
