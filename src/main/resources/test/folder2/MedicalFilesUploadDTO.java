package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
/**
 * @classDesc: 功能描述:
 * @author: zcz
 * @date: 2022/6/5 15:50
 * @copyright 众阳健康
 */
@ApiModel(value = "文件上传实体类")
@Data
public class MedicalFilesUploadDTO {

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
     * 系统id
     */
    @ApiModelProperty(value = "系统id")
    @NotNull(message = "系统id为空")
    private Integer systemId;

    /**
     * 患者就诊id
     */
    @ApiModelProperty(value = "患者就诊id")
    @NotNull(message = "患者就诊id为空")
    private Long outsiderId;

    /**
     * 文件列表
     */
    @ApiModelProperty(value = "文件列表")
    @NotEmpty(message = "文件列表为空")
    private List<FileMsgDTO> fileMsgDTOS;
    /**
     * 医院id
     */
    @ApiModelProperty(value = "医院id")
    private Long hospitalId;

    /**
     * 是否作废
     */
    @ApiModelProperty(value = "是否作废")
    private Integer flagInvalid;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private Long orgId;
}
