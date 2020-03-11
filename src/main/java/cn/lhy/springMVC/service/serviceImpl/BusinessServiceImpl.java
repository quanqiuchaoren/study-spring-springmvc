package cn.lhy.springMVC.service.serviceImpl;

import cn.lhy.springMVC.entity.Business;
import cn.lhy.springMVC.repository.iRepository.IBusinessRepository;
import cn.lhy.springMVC.service.iService.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements IBusinessService {
    @Autowired
    IBusinessRepository businessRepository;
    @Override
    public List<Business> getAll() {
        return businessRepository.getAll();
    }
}
