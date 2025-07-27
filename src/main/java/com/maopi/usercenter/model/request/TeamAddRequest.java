package com.maopi.usercenter.model.request;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/24 18:55 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

@Data
public class TeamAddRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户id（队长id）
     */
    private Long userId;

    /**
     * 0 - 公开, 1 - 私有, 2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;

}