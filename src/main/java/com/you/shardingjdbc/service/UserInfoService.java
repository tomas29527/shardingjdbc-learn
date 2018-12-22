package com.you.shardingjdbc.service;

import com.you.shardingjdbc.entity.dao.UserInfo;

import java.util.List;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/21 15:54
 * @since <版本号>
 */
public interface UserInfoService {
    public void insert(UserInfo userInfo);

    public List<UserInfo> seachPage(int startNo);
}
