package net.luculent.automatioin.laks.services.applist.service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 09:58 2018/10/19
 * @Modified By:
 */
public interface AppListService {

    List<Map<String, Object>> queryAppList(Map<String, Object> condition);
}
