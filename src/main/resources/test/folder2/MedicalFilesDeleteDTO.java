package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
/**
 * @classDesc: 功能描述:
 * @author: zcz
 * @date: 2022/6/5 15:50
 * @copyright 众阳健康
 */

@ApiModel(value = "文件删除实体类")
@Data
public class MedicalFilesDeleteDTO {

    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id")
    @NotNull(message = "患者id为空")
    private Long patId;

    /**
     * 患者类型
     */
    @ApiModelProperty(value = "患者类型")
    @NotNull(message = "患者类型为空")
    private Integer patType;

    /**
     * 患者就诊id
     */
    @ApiModelProperty(value = "患者就诊id")
    @NotNull(message = "患者就诊id为空")
    private Long outsiderId;

    /**
     * 文件分类id
     */
    @ApiModelProperty(value = "文件分类id")
    @NotNull(message = "文件分类id为空")
    private Long classNum;

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    @NotNull(message = "业务id为空")
    private String businessId;

    /**
     * 医院id
     */
    @ApiModelProperty(value = "医院id")
    private Long hospitalId;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private Long orgId;
}
