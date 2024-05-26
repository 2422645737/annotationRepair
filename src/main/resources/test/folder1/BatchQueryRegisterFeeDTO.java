package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.msun.core.commons.api.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
* @description:
* @fileName: DictRegisterClassApiDTO.java
* @author: songyunhao
* @createAt: 2023-11-08 16:17
* @updateBy: songyunhao
* @remark: Copyright
*/
@Data
@ApiModel(description = "参数DTO")
public class BatchQueryRegisterFeeDTO extends BaseDTO {
    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id", required = true)
    @NotNull(message = "患者id不能为空")
    private Long patId;

    /**
     * 挂号类别ID
     */
    @ApiModelProperty(value = "挂号类别ID")
    private Long registerClassId;

    /**
     * 科室ID
     */
    @ApiModelProperty(value = "科室ID")
    private Long deptId;
}
