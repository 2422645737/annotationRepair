package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 无纸化上传请求实例
 * @fileName: FileUploadInfo.java
 * @author: ws
 * @createAt: 2023/3/2 11:27
 * @updateBy: ws
 * @remark: 众阳健康
 */
@Data
public class FileUploadInfo implements Serializable {

    /**
     * 医院id
     */
    private Long hospitalId;

    /**
     * 机构id
     */
    private Long orgId;

    /**
     * 患者id
     */
    private Long patId;
    /**
     * 患者类型（1.住院；2.门诊；3.体检）
     */
    private Integer patType;
    /**
     * 系统id
     */
    private Integer systemId;
    /**
     * 患者就诊id(门诊患者上传门诊id、住院患者上传住院id、体检患者上传体检id)
     */
    private Long outsiderId;
    /**
     * 文件信息实体类
     */
    private List<FileMsg> fileMsgDTOS;



}