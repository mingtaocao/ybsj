package net.luculent.automatioin.laks.services.userlogin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 09:56 2018/10/19
 * @Modified By:
 */
@Mapper
public interface UserLoginDao {

    /**
     * 用户登录
     *
     * @param condition
     * @return
     */
    List<Map<String, Object>> login(Map<String, Object> condition);

    /**
     * 根据用户username查询用户信息
     *
     * @param username
     * @return
     */
    Map<String, Object> queryUserByLgName(String username);
}

