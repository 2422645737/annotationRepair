package com.msun.his.app.mzemr.server.manage.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @description: FileMsg
* @fileName: FileMsg.java
* @author: ws
* @createAt: 2023/3/2 11:37
* @updateBy: ws
* @remark: 众阳健康
*/
@Data
public class FileMsg implements Serializable {

    /**
     * 业务id(各业务场景自己的id，如会诊）必填
     */
    private String businessId;

    /**
     * 文件分类编码 必填
     */
    private Long classNum;

    /**
     * 文件名称，不包含扩展名 必填
     */
    private String fileName;

    /**
     * 文件路径，无需填写，队列控制器上传文件上传服务后会自动填充
     */
    private String filePath;

    /**
     * 文件类型，无需填写，取上层typeText参数自动填充
     */
    private String fileType;

    /**
     * 文件排序序号（用于同种类型下多次记录时，标识文件的一个顺序）。必填，没有传0
     */
    private Integer orderNo;

}
