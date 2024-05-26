package com.msun.his.app.mzemr.server.manage.entity.dto;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @classDesc: 功能描述:药房换班查询DTO类
 * @author: lwx
 * @date: 2023/5/25 22:50
 * @copyright 众阳健康
 */
@Data
public class PharmacySchedulingQueryDTO {

    @ApiModelProperty(value = "类型:门诊(mzemr)住院(zyemr)急诊(jzemr)")
    private String schedulingType;

    @ApiModelProperty(value = "医院id")
    private Long hospitalId;

    @ApiModelProperty(value = "查询此时间下可用科室，不传默认当前时间")
    private Date queryTime;

    @ApiModelProperty(value = "科室id")
    private Long deptId;

    @ApiModelProperty(value = "科室类别 1: 门诊科室 2: 收款处 3: 病房 4: 药房 5: 药库 6: 医技科室 7: 手术室 8: 行政科室 9:护理单元 10:静配中心 11:乡医工作站:12:材料库")
    private String categoryId;

    @ApiModelProperty(value = "科室id")
    private List<Long> deptIds;

    @ApiModelProperty(value = "是否查询没有排班的科室，默认不查询，传true进行查询")
    private Boolean queryNoSchedulingDept = Boolean.FALSE;

}