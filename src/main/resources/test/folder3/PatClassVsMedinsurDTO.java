package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.msun.core.commons.api.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName : PatClassVsMedinsurDTO
 * @Author :  guangzhou
 * @Date : 2023/7/12 16:08
 * @Description :
 * @Remark : 众阳健康
 */
@Data
public class PatClassVsMedinsurDTO extends BaseDTO {

    /**
     * 医保险种编码
     */
    @ApiModelProperty(value = "医保险种编码")
    private List<String> medInsurCode;


    /**
     * 医保人员类别编码
     */
    @ApiModelProperty(value = "医保人员类别编码")
    private List<String> medPatTypeCode;
}