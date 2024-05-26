package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 授权返回结果
 * @fileName: PublishedSystemReturnDTO
 * @author: wanghui
 * @createAt: 2023/12/22 11:00:14
 * @updateBy:
 * @copyright: 众阳健康
 */

@ApiModel(description = "参数DTO")
@Data
public class PublishedSystemReturnDTO implements Serializable {
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

    /**
     * 未授权原因
     */
    private String reason;

    /**
     * 是否授权
     */
    private Boolean isAuthorized;

    /**
     *	是否是父级模块
     */
    private Boolean parentFlag;
}