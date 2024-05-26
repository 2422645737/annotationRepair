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
@ApiModel(value = "文件异常实体类")
@Data
public class MedicalFilesAbnormalDTO {

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
    private Long systemId;

    /**
     * 患者就诊id
     */
    @ApiModelProperty(value = "患者就诊id")
    @NotNull(message = "患者就诊id为空")
    private Long outsiderId;

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    @NotNull(message = "业务id为空")
    private String businessId;

    /**
     * 文件分类id
     */
    @ApiModelProperty(value = "文件分类id")
    @NotNull(message = "文件分类id为空")
    private Long classNum;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    @NotNull(message = "文件名称为空")
    private String fileName;

    /**
     * 异常类型（1.生成PDF异常；2.调用文件服务上传文件失败；3.上传、更新文件时调用无纸化接口更新路径失败；4. 调用文件服务删除文件失败；5.删除文件时调用无纸化接口更新路径失败）
     */
    @ApiModelProperty(value = "异常类型（1.生成PDF异常；2.调用文件服务上传文件失败；3.上传、更新文件时调用无纸化接口更新路径失败；4. 调用文件服务删除文件失败；5.删除文件时调用无纸化接口更新路径失败）")
    @NotNull(message = "异常类型为空")
    private Integer operateType;

    /**
     * 其他信息
     */
    @ApiModelProperty(value = "其他信息")
    private String otherInfo;

    /**
     * 是否作废
     */
    @ApiModelProperty(value = "是否作废")
    private Integer flagInvalid;
}
