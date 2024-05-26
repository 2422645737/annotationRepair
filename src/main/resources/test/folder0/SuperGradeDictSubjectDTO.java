package com.msun.his.app.mzemr.server.subjectrecommend.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
import com.msun.core.commons.api.BaseDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @classDesc: 功能描述: 数据采集结果出参
 * @author: zhangchuandong
 * @date: 2021/4/6 10:05
 * @copyright 众阳健康
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "数据采集结果出参",description="数据采集结果出参")
@Data
public class SuperGradeDictSubjectDTO extends BaseDTO {
    /**
     * 学科表主键
     */
    private Long subjectId;

    /**
     * 学科编码
     */
    private String subjectCode;

    /**
     * 学科名称
     */
    private String subjectName;

    /**
     * 学科等级
     */
    private Integer subjectGrade;

    /**
     * 上级学科id
     */
    private Long superSubjectId;

    /**
     * 学科顺序
     */
    private Integer subjectSort;

    /**
     * 学科备注
     */
    private String memo;

    /**
     * 二级学科集合
     */
    private List<SecondGradeDictSubjectDTO> secondGradeDictSubjectDTOS;

}