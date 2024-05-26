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
@ApiModel(value = "文件信息实体类")
@Data
public class FileMsgDTO {

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    @NotNull(message = "业务id为空")
    private String businessId;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    @NotNull(message = "文件路径为空")
    private String filePath;

    /**
     * 文件分类id
     */
    @ApiModelProperty(value = "文件分类编号")
    @NotNull(message = "文件分类编号为空")
    private Long classNum;

    /**
     * 文件排序序号
     */
    @ApiModelProperty(value = "文件排序序号")
    @NotNull(message = "文件排序序号为空")
    private Integer orderNo;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    @NotNull(message = "文件名称为空")
    private String fileName;

    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;
}
