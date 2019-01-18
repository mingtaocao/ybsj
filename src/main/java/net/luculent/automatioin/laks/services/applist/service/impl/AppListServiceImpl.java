package net.luculent.automatioin.laks.services.applist.service.impl;

import net.luculent.automatioin.laks.services.applist.dao.AppListDao;
import net.luculent.automatioin.laks.services.applist.service.AppListService;
import net.luculent.automatioin.laks.services.userlogin.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: caomingtao
 * @Date Create In 10:32 2018/10/19
 * @Modified By:
 */
@Service
public class AppListServiceImpl implements AppListService {



    @Resource
    private AppListDao appListDao;

    @Override
    public List<Map<String, Object>> queryAppList(Map<String, Object> condition) {

        List<Map<String, Object>> detail = appListDao.queryAppList(condition);

        return detail;
    }
}
