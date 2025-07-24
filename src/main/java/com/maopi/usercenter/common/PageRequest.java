package com.maopi.usercenter.common;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/22 21:26 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -4289035124547693545L;

    /**
     * 页面大小
     */
    protected int pageSize=10;

    /**
     * 当前是第几页
     */
    protected int pageNum=1;
}