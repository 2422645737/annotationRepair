package com.msun.middle.aggregate.clinic.server.outorder.entity.dto;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.msun.core.commons.api.BaseDTO;
import com.msun.core.commons.api.ResponseResult;
import com.msun.middle.base.trade.api.outpatient.outtradeorder.entity.vo.OutTradeOrderVO;
import com.msun.middle.business.outorder.api.outdocorder.dto.PatientDTO;
import com.msun.middle.business.outorder.api.outdocorder.dto.outapplication.OutApplicationFormDTO;
import com.msun.middle.business.outorder.api.outdocorder.dto.outpres.OutPresDetailsDTO;
import com.msun.middle.business.outorder.api.outdocorder.dto.outpres.OutPresInfoDTO;
import com.msun.middle.business.outorder.api.outdocorder.dto.outtreate.OutTreateInfoDTO;
import com.msun.middle.business.outorder.api.outdocorder.enums.YesOrNoEnum;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.zookeeper.Op;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:签名后返回的医嘱
 * @fileName: OutSignOrderDataDTO
 * @author: TongBo
 * @createAt: 2021/3/29 17:58
 * @updateBy: TongBo
 * @remark: 众阳健康
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "签名后返回的医嘱DTO")
public class OutSignOrderFormDataDTO extends BaseDTO {
	/**
	 * 订单信息
	 */
	@ApiModelProperty(value = " 订单信息")
	private List<OutTradeOrderVO> outTradeOrderVOS;


	@NotEmpty
	@ApiModelProperty(value = "outDeriveErrorMessage")
	private String outDeriveErrorMessage;


	@ApiModelProperty(value = "stockOccupyFailDetails")
	private List<OutPresDetailsDTO> stockOccupyFailDetails;

	/**
	 * 是否自动执行
	 */
	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "autoExecute")
	private Boolean autoExecute;

	/**
	 * 判断是否需要皮试派生
	 */
	public boolean judgeSkinTestDerive() {
		if (!CollectionUtils.isEmpty(outWestPresInfoList)) {
			for (OutPresInfoDTO outPresInfoDTO : outWestPresInfoList) {
				boolean result = outPresInfoDTO.getOutPresDetailsList().stream().anyMatch(p -> YesOrNoEnum.YES.getCode().equals(p.getSkinTestDerive()));
				if (result) {
					return true;
				}
			}
		}
		return false;
	}



}