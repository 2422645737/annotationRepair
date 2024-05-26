package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @description: DeleteFileDTO
* @fileName: DeleteFileDTO.java
* @author: ws
* @createAt: 2023/3/2 13:50
* @updateBy: ws
* @remark: 众阳健康
*/

@ApiModel(description = "参数DTO")
@Data
public class DeleteFileDTO implements Serializable {

    /**
     * 业务id(各业务场景自己的id，如会诊）
     */
    private String businessId;

    /**
     * 文件分类编码
     */
    private Long classNum;

    /**
     * 医院ID
     */
    private Long hospitalId;

    /**
     * 机构ID
     */
    private Long orgId;

    /**
     * 患者就诊id(门诊患者上传门诊id、住院患者上传住院id、体检患者上传体检id)
     */
    private Long outsiderId;

    /**
     * 患者Id
     */
    private Long patId;

    /**
     * 患者类型（1.住院；2.门诊；3.体检）
     */
    private Integer patType;

}