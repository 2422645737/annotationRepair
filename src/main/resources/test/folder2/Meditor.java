package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 病历编辑器实例
 * @fileName: Meditor.java
 * @author: ws
 * @createAt: 2023/3/2 11:25
 * @updateBy: ws
 * @remark: 众阳健康
 */
@Data
public class Meditor implements Serializable {

    /**
     * 编辑器设置的左边距、右边距等影响排版的配置（可不传，默认使用编辑器原始数据中保存的配置）
     */
    @ApiModelProperty(value = "编辑器设置的左边距、右边距等影响排版的配置（可不传，默认使用编辑器原始数据中保存的配置）")
    private String config;
    /**
     * 编辑器原始数据
     */
    @ApiModelProperty(value = "编辑器原始数据")
    private String rawData;

}