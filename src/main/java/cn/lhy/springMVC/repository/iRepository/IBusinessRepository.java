package cn.lhy.springMVC.repository.iRepository;


import cn.lhy.springMVC.entity.Business;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public interface IBusinessRepository extends IBaseRepository<Business> {
    List<Business> getAll();
}
