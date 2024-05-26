package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* @description: 电子病历评级最新查询配置
* @fileName:  EmrRateConfigNewQueryDto
* @author: zhy
* @createAt: 2023/8/15 16:27
* @updateBy: zhy
* @remark: 众阳健康
*/

@ApiModel(description = "参数DTO")
@Data
public class EmrRateConfigNewQueryDto {

    /**
     * 产品编码合集
     */
    private List<String> prodCodes;

    /**
     * 条款级别
     */
    private Integer rateLevel;

    /**
     * 默认构造函数
     */
    public EmrRateConfigNewQueryDto() {
        this.prodCodes = Collections.singletonList("emr");
        this.rateLevel = null;
    }
}