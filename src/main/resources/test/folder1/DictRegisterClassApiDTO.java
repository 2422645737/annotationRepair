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
@EqualsAndHashCode(callSuper = true)
public class DictRegisterClassApiDTO extends BaseDTO {
    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id", required = true)
    @NotNull(message = "患者id不能为空")
    private Long patId;

    /**
     * 用户身份id
     */
    @ApiModelProperty(value = "用户身份id")
    private Long userSysId;

    /**
     * 科室ID
     */
    @ApiModelProperty(value = "科室ID")
    private Long deptId;
}
