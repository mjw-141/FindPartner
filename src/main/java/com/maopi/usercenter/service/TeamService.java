package com.maopi.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maopi.usercenter.model.domain.Team;
import com.maopi.usercenter.model.domain.User;


/**
* @author Lenovo
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2025-07-21 21:10:35
*/
public interface TeamService extends IService<Team> {
    long addTeam(Team team, User loginUser);

}
