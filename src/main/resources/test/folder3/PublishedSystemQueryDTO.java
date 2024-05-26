package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.msun.core.commons.api.BaseDTO;
import com.msun.core.commons.context.LoginUserInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 授权查询参数
 * @fileName: PublishedSystemQueryDTO
 * @author: wanghui
 * @createAt: 2023/12/22 10:58:33
 * @updateBy:
 * @copyright: 众阳健康
 */

@ApiModel(description = "参数DTO")
@Data
public class PublishedSystemQueryDTO implements Serializable {

    /**
     * 系统编码
     */
    private String publishedSystemCode;

    /**
     * 医院id
     */
    private Long hospitalId;

    /**
     * 机构id
     */
    private Long orgId;

    public void init(LoginUserInfo loginUserInfo){
        if (loginUserInfo != null) {
            this.setOrgId(loginUserInfo.getOrgId());
            this.setHospitalId(loginUserInfo.getHospitalId());
        }
    }
}