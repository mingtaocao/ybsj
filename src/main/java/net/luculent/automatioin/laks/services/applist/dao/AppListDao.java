package net.luculent.automatioin.laks.services.applist.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 09:58 2018/10/19
 * @Modified By:
 */
@Mapper
public interface AppListDao {

    List<Map<String, Object>> queryAppList(Map<String, Object> condition);
}

