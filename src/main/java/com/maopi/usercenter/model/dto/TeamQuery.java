package com.maopi.usercenter.model.dto;


import com.maopi.usercenter.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/22 12:01 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
@Data
@EqualsAndHashCode(callSuper = true)
//@EqualsAndHashCode(callSuper = true) 是一种方便的方式来确保子类的 equals() 和 hashCode() 方法能够正确地处理继承关系，避免遗漏父类的字段
//继承自定义分页组件
public class TeamQuery extends PageRequest {
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 搜索关键词（同时对队伍名称和描述搜索）
     */
    private String searchText;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;


    /**
     * 用户id（队长id）
     */
    private Long userId;

    /**
     * 0 - 公开, 1 - 私有, 2 - 加密
     */
    private Integer status;

}