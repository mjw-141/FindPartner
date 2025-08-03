package com.maopi.usercenter.common;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/22 21:26 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求参数
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = -4289035124547693545L;

    private Long id;

}