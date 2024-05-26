package com.msun.his.app.mzemr.server.manage.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description:
 * @fileName: EmisTimeLineDTO
 * @author: wanghui
 * @createAt: 2024/03/15 11:24:58
 * @updateBy:
 * @copyright: 众阳健康
 */

@ApiModel(description = "参数DTO")
@Data
public class EmisTimeLineDTO {
    /**
     * 急诊分诊id
     */
    private Long serialId;

    /**
     * 时间节点
     */
    private String timelineDataSource;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date nodeTime;

}