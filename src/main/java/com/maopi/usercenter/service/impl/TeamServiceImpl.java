package com.maopi.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maopi.usercenter.mapper.TeamMapper;
import com.maopi.usercenter.model.domain.Team;
import com.maopi.usercenter.model.domain.User;
import com.maopi.usercenter.service.TeamService;
import org.springframework.stereotype.Service;

/**
* @author Lenovo
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2025-07-21 21:31:46
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

    @Override
    public long addTeam(Team team, User loginUser) {
        //1. 请求参数是否为空?
        //2. 是否登录，未登录不允许创建
        //3. 校验信息
        // 1. 队伍人数 > 1 且 <= 20
        // 2. 队伍标题 <= 20
        // 3. 描述 <= 512
        // 4. status 是否公开（int）不传默认为 0（公开）
        // 5. 如果 status 是加密状态，一定要有密码，且密码 <= 32
        // 6. 超时时间 > 当前时间
        // 7. 校验用户最多创建 5 个队伍
        //4. 插入队伍信息到队伍表
        //5. 插入用户 => 队伍关系到关系表
        return 0;
    }
}




