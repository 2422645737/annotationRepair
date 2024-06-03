package com.msun.his.app.mzemr.server.comm.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.msun.core.commons.api.BaseVO;
import com.msun.his.app.mzemr.server.comm.entity.dto.NetworkItemMedinsurInfoDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @classDesc: 申请单项目查询VO
 * @author: FangPeiTao
 * @date: 2022/8/10
 * @copyright 众阳健康
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "参数DTO")
public class ApplyProjectSearchVO extends BaseVO {
    /**
     * 部位id
     */
	@ApiModelProperty(value = " 部位id")
	private Long bodypartId;
    /**
     * 部位名称
     */
	@ApiModelProperty(value = " 部位名称")
	private String bodypartName;
    /**
     * 收集logo?
     */
	@ApiModelProperty(value = " 收集logo?")
	private String collectionLogo;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = 参数)
	private Date hisCreateTime;
    /**
     * 医院id
     */
	@ApiModelProperty(value = " 医院id")
	private Long hospitalId;
    /**
     * 指示?
     */
	@ApiModelProperty(value = " 指示?")
	private String indication;
    /**
     * 输入查询码
     */
	@ApiModelProperty(value = " 输入查询码")
	private String inputCode;
    /**
     * 实验室项目id?
     */
	@ApiModelProperty(value = " 实验室项目id?")
	private Long labItemId;
    /**
     * 项目金额
     */
	@ApiModelProperty(value = " 项目金额")
	private BigDecimal orderAmount;
    /**
     * 项目类别
     */
	@ApiModelProperty(value = " 项目类别")
	private Integer orderCategoryId;
    /**
     * 项目id
     */
	@ApiModelProperty(value = " 项目id")
	private Long orderId;
    /**
     * 项目名称
     */
	@ApiModelProperty(value = " 项目名称")
	private String orderName;
    /**
     * 机构id
     */
	@ApiModelProperty(value = " 机构id")
	private Long orgId;
    /**
     * 部位级别
     */
	@ApiModelProperty(value = " 部位级别")
	private Integer partLevel;
    /**
     * 推荐项目
     */
	@ApiModelProperty(value = " 推荐项目")
	private String recommend;
    /**
     * 推荐id
     */
	@ApiModelProperty(value = " 推荐id")
	private Long recommendId;
    /**
     * 报告id
     */
	@ApiModelProperty(value = " 报告id")
	private Long reportItemId;
    /**
     * 样本id
     */
	@ApiModelProperty(value = " 样本id")
	private Long sampleClassId;
    /**
     * 样本名称
     */
	@ApiModelProperty(value = " 样本名称")
	private String sampleClassName;
    /**
     * 模态
     */
	@ApiModelProperty(value = " 模态")
	private String modality;
    /**
     * 模态名称
     */
	@ApiModelProperty(value = " 模态名称")
	private String modalityName;
    /**
     * 影响?
     */
	@ApiModelProperty(value = " 影响?")
	private String effect;
    /**
     * 指示EPS?
     */
	@ApiModelProperty(value = " 指示EPS?")
	private String indicationEPS;
    /**
     * 注意事项
     */
	@ApiModelProperty(value = " 注意事项")
	private String mattersNeedingAttention;
    /**
     * 国家医保编码
     */
	@ApiModelProperty(value = " 国家医保编码")
	private String nationalMedicalInsuranceCode;
    /**
     * 省级医保编码
     */
	@ApiModelProperty(value = " 省级医保编码")
	private String provincialInsuranceCode;

    /**
     * 执行医院id
     */
	@ApiModelProperty(value = " 执行医院id")
	private Long exeHospitalId;

    /**
     * 麻醉标识
     */
	@ApiModelProperty(value = " 麻醉标识")
	private String supportAnes;

    /**
     * 互认平台标准编码
     */
	@ApiModelProperty(value = " 互认平台标准编码")
	private String sharingCenterCode;

    /**
     *
     */
	@ApiModelProperty(value = "")
	@Notnull
	private String knowledgeBase;

    /**
     * 远程医嘱套餐id
     */
	@Json()
	@ApiModelProperty(value = "远程医嘱套餐id")
	private Long remoteOrderId;


	@ApiModelProperty(value = "gptFlag")
	private Integer gptFlag;

    @ApiModelProperty(value = "dictOrderVsNetworkList")
	private List<NetworkItemMedinsurInfoDTO> dictOrderVsNetworkList;

}