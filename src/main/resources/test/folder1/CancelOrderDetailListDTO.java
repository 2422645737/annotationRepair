package com.msun.his.app.mzemr.server.manage.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassName : CancelOrderDetailListDTO
 * @Author :  guangzhou
 * @Date : 2023/6/25 12:46
 * @Description :
 * @Remark : 众阳健康
 */
@Data
public class CancelOrderDetailListDTO {


    @ApiModelProperty(value = "要取消签名的医疗医嘱详细ID", required = true)
    @NotEmpty(message = "要取消签名的医疗医嘱详细ID不允许为空")
    private List<Long> outExeOrderIdList;
    @ApiModelProperty(value = "就诊记录ID")
    private Long outVisitRecordId;
    @ApiModelProperty(value = "患者ID")
    private Long patientId;

    @ApiModelProperty(value = "执行状态 0 未执行，1已执行")
    private Integer status;



}