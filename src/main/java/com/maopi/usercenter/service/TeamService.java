package com.maopi.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maopi.usercenter.model.domain.Team;
import com.maopi.usercenter.model.domain.User;
import com.maopi.usercenter.model.dto.TeamQuery;
import com.maopi.usercenter.model.request.TeamJoinRequest;
import com.maopi.usercenter.model.request.TeamQuitRequest;
import com.maopi.usercenter.model.request.TeamUpdateRequest;
import com.maopi.usercenter.model.vo.TeamUserVO;

import java.util.List;


/**
* @author Lenovo
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2025-07-21 21:10:35
*/
public interface TeamService extends IService<Team> {
    long addTeam(Team team, User loginUser);

    //搜索队伍

    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    //更新队伍
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest,User loginUser);

    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    //解散队伍
    boolean deleteTeam(long id, User loginUser);
}
