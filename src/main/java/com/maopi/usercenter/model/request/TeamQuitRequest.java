package com.maopi.usercenter.model.request;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/24 18:55 （可以根据需要修改）
 * 用户退出队伍请求体
 * @Version 1.0 （版本号）
 */

@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * id
     */
    private Long teamId;


}