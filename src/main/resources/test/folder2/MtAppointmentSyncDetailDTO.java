package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName : MtAppointmentSyncDetailDTO
 * @Author :  guangzhou
 * @Date : 2023/11/23 10:07
 * @Description :
 * @Remark : 众阳健康
 */
@ApiModel(value = "MtAppointmentSyncDetailDTO",description="MtAppointmentSyncDetailDTO")
@Data
public class MtAppointmentSyncDetailDTO {

    /**
     * 对接数据明细id，所有数据全局唯一，保证数据的唯一性
     */
    @NotNull
    @ApiModelProperty(value = "对接数据明细id，所有数据全局唯一，保证数据的唯一性",required = true)
    private String applyDetailId;

    /**
     * 对接数据分组id，一个applyId可能对应多个applyDetailId
     */
    @ApiModelProperty(value = "对接数据分组id，一个applyId可能对应多个applyDetailId(操作类型为申请时，必传)")
    private String applyId;
    /**
     * 类别编码
     */
    @ApiModelProperty(value = "类别编码，模态编码(操作类型为申请时，必传)")
    private String categoryCode;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称，模态名称(操作类型为申请时，必传)")
    private String categoryName;

    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id(操作类型为申请时，必传)")
    private Long projectId;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称(操作类型为申请时，必传)")
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
    @NotNull
    @ApiModelProperty(value = "患者id",required = true)
    private Long patId;

    /**
     * 患者名称
     */
    @ApiModelProperty(value = "患者名称(操作类型为申请时，必传)")
    private String patName;

    /**
     * 患者卡号
     */
    @ApiModelProperty(value = "患者卡号(操作类型为申请时，必传)")
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
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间(操作类型为申请时，必传)")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyTime;

    /**
     * 申请科室id
     */
    @ApiModelProperty(value = "申请科室id(操作类型为申请时，必传)")
    private Long applyDeptId;

    /**
     * 申请科室名称
     */
    @ApiModelProperty(value = "申请科室名称(操作类型为申请时，必传)")
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
    @ApiModelProperty(value = "执行科室id(操作类型为申请时，必传)")
    private Long executeDeptId;

    /**
     * 执行科室名称
     */
    @ApiModelProperty(value = "执行科室名称(操作类型为申请时，必传)")
    private String executeDeptName;
    /**
     * 渠道编码 mt_out_patient:门诊、mt_in_patient:住院
     */
    @NotNull
    @ApiModelProperty(value = "渠道编码 mt_out_patient:门诊、mt_in_patient:住院,mt_physical:体检",required = true)
    private String channelCode;

    /**
     * 操作类型 apply:申请,cancel：撤销
     */
    @NotNull
    @ApiModelProperty(value = "操作类型 apply:申请,cancel：撤销",required = true)
    private String operateType;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private Long hisOrgId;

    /**
     * 申请人id
     */
    @NotNull
    @ApiModelProperty(value = "申请人id",required = true)
    private Long hisCreaterId;

    /**
     * 申请人名称
     */
    @NotNull
    @ApiModelProperty(value = "申请人名称",required = true)
    private String hisCreaterName;

    /**
     * 医院id
     */
    @NotNull
    @ApiModelProperty(value = "医院id",required = true)
    private Long hospitalId;

    /**
     * 医院名称
     */
    @ApiModelProperty(value = "医院名称(操作类型为申请时，必传)")
    private String hospitalName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 项目是否可做 0：不可做，1：可做，体检来源使用
     */
    @ApiModelProperty(value = "项目是否可做 0：不可做，1：可做，体检来源使用")
    private String canDoFlag;
    /**
     * 是否为急诊{0:否, 1:是}
     */
    @ApiModelProperty(value = "是否为急诊{0:否, 1:是}")
    private String orderEmergency;

    /**
     * 申请单类型（1：检查，2：心电，3：检验）
     */
    @ApiModelProperty(value = "申请单类型（1：检查，2：心电，3：检验）")
    private String applyBillType;

    @ApiModelProperty(value = "费用")
    private BigDecimal price;
    /**
     * 注意事项
     */
    @ApiModelProperty(value = "注意事项")
    private String attention;
    /**
     * 部位是否存在 0：不存在，1：存在
     */
    @ApiModelProperty(value = "部位是否存在 0：不存在，1：存在")
    private String existPartFlag;
    /**
     * 执行医院ID，默认为申请单医院ID
     */
    @ApiModelProperty(value = "执行医院ID，默认为申请单医院ID")
    private Long exeHospitalId;
    /**
     * 性别id
     */
    private Integer sexId;

    /**
     * 上一次的申请单id
     */
    @ApiModelProperty(value = "上一次的申请单id")
    private String lastApplyId;
    /**
     * 上一次的申请单明细id
     */
    @ApiModelProperty(value = "上一次的申请单明细id")
    private String lastApplyDetailId;
    /**
     * 是否还有新申请单标识（0：否， 1：是）
     */
    @ApiModelProperty(value = "是否还有新申请单标识（0：否， 1：是）")
    private String existNewApplyFlag;
}