package cn.lhy.springMVC.service.iService;


import cn.lhy.springMVC.entity.Business;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public interface IBusinessService extends IBaseService<Business> {
    List<Business> getAll();
}
