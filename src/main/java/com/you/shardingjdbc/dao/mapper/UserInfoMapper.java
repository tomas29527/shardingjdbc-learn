package com.you.shardingjdbc.dao.mapper;

import com.you.shardingjdbc.entity.dao.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/21 15:30
 * @since <版本号>
 */
@Repository
public interface UserInfoMapper {
    public void insert(UserInfo userInfoserInfo);

    public List<UserInfo> seachPage(int startNo);
}
