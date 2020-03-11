package cn.lhy.springMVC.repository.repositoryImpl;


import cn.lhy.springMVC.entity.Business;
import cn.lhy.springMVC.repository.iRepository.IBusinessRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
@Repository
public class BusinessRepositoryImpl extends BaseRepositoryImpl<Business> implements IBusinessRepository {

    @Override
    public List<Business> getAll() {
        String hql = "from Business";
        return super.getList(hql);
    }
}
