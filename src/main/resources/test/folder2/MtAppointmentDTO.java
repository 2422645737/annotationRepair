package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description: 医技预约表(MtAppointment)实体类
 * @author: guangzhou
 * @date: Created in 2021-07-14 10:02:25
 * @remark: Copyright By 众阳健康
 */
@ApiModel(value = "MtAppointmentDTO",description="MtAppointmentDTO")
@Data
public class MtAppointmentDTO {


    /**
     * 预约id
     */
    @ApiModelProperty(value = "预约id")
    private Long appointId;

    /**
     * 类别id
     */
    @ApiModelProperty(value = "类别id")
    private Long categoryId;

    /**
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码")
    private String categoryCode;
    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 部位id
     */
    @ApiModelProperty(value = "部位id")
    private Long partId;

    /**
     * 部位名称
     */
    @ApiModelProperty(value = "部位名称")
    private String partName;

    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id")
    private Long patId;

    /**
     * 患者名称
     */
    @ApiModelProperty(value = "患者名称")
    private String patName;

    /**
     * 患者卡号
     */
    @ApiModelProperty(value = "患者卡号")
    private String patCardNo;
    /**
     * 患者住院登记id或就诊记录id
     */
    @ApiModelProperty(value = "患者住院登记id或就诊记录id")
    private Long inOrOutPatId;
    /**
     * 患者住院号或者就诊号
     */
    @ApiModelProperty(value = "患者住院号或者就诊号")
    private String inOrOutPatCode;
    /**
     * 床位号
     */
    @ApiModelProperty(value = "床位号")
    private String bedNo;
    /**
     * 单据来源 mt_out_patient:门诊、mt_in_patient:住院、mt_green:绿色通道直接登记
     */
    @ApiModelProperty(value = "单据来源 mt_out_patient:门诊、mt_in_patient:住院、mt_green:绿色通道直接登记")
    private String dataFrom;
    /**
     * 预约状态 0：初始，1：待预约，2：已预约，3：已撤销，4：待确认，5：已登记，6：已出报告
     */
    @ApiModelProperty(value = "预约状态 0：初始，1：待预约，2：已预约，3：已撤销，4：待确认，5：已登记，6：已出报告")
    private Integer appointStatus;
    /**
     * 预约状态 0：初始，1：待预约，2：已预约，3：已撤销，4：待确认，5：已登记，6：已出报告
     */
    @ApiModelProperty(value = "预约状态 0：初始，1：待预约，2：已预约，3：已撤销，4：待确认，5：已登记，6：已出报告")
    private List<Integer> appointStatusList;
    /**
     * 缴费状态 1：未交费，2：已缴费，3：已退费
     */
    @ApiModelProperty(value = "缴费状态 1：未交费，2：已缴费，3：已退费")
    private Integer payStatus;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyTime;

    /**
     * 申请科室id
     */
    @ApiModelProperty(value = "申请科室id")
    private Long applyDeptId;

    /**
     * 申请科室名称
     */
    @ApiModelProperty(value = "申请科室名称")
    private String applyDeptName;
    /**
     * 病区id
     */
    @ApiModelProperty(value = "病区id")
    private Long wardId;

    /**
     * 病区名称
     */
    @ApiModelProperty(value = "病区名称")
    private String wardName;

    /**
     * 执行科室id
     */
    @ApiModelProperty(value = "执行科室id")
    private Long executeDeptId;

    /**
     * 执行科室名称
     */
    @ApiModelProperty(value = "执行科室名称")
    private String executeDeptName;
    /**
     * 渠道id
     */
    @ApiModelProperty(value = "渠道id")
    private Long channelId;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String channelName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String memo;
    /**
     * 是否为急诊{0:否, 1:是}
     */
    @ApiModelProperty(value = "是否为急诊{0:否, 1:是}")
    private String orderEmergency;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private Long hisOrgId;

    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Long hisCreaterId;

    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称")
    private String hisCreaterName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hisCreateTime;

    /**
     * 更新人id
     */
    @ApiModelProperty(value = "更新人id")
    private Long hisUpdaterId;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hisUpdateTime;
    /**
     * 对接外部数据id，分组
     */
    @ApiModelProperty(value = "申请单id")
    private String applyId;
    /**
     * 对接外部明细数据id，唯一
     */
    @ApiModelProperty(value = "申请单明细id")
    private String applyDetailId;
    /**
     * 单据类型 1：检查，2：心电，3：检验，4：治疗
     */
    @ApiModelProperty(value = "单据类型 1：检查，2：心电，3：检验，4：治疗")
    private String applyBillType;
    /**
     * 项目价格
     */
    @ApiModelProperty(value = "项目价格")
    private BigDecimal projectPrice;
    /**
     * 医技检查自动预约开单N分钟之后的号源，默认10分钟，配置错误默认10分钟
     */
    @ApiModelProperty(value = "医技检查自动预约开单N分钟之后的号源，默认10分钟，配置错误默认10分钟")
    private Integer appointInterval;
    /**
     * 执行医院ID，默认为申请单医院ID
     */
    @ApiModelProperty(value = "执行医院ID，默认为申请单医院ID")
    private Long exeHospitalId;
    /**
     * 申请单明细id列表
     */
    @ApiModelProperty(value = "申请单明细id列表")
    private List<String> applyDetailIdList;
    /**
     * 自动预约结果
     */
    @ApiModelProperty(value = "自动预约结果")
    private String autoAppointResult;

    /**
     * 申请开始时间
     */
    @ApiModelProperty(value = "申请开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startApplyTime;

    /**
     * 申请结束时间
     */
    @ApiModelProperty(value = "申请结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endApplyTime;

    /**
     * 排除申请单id列表
     */
    @ApiModelProperty(value = "排除申请单id列表")
    private List<String> unApplyIdList;

    /**
     * 是否还有新申请单标识（0：否， 1：是）
     */
    @ApiModelProperty(value = "是否还有新申请单标识（0：否， 1：是）")
    private String existNewApplyFlag;
}

