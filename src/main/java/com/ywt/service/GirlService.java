package com.ywt.service;

import com.ywt.GirlApplication;
import com.ywt.dao.GirlRepository;
import com.ywt.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> getByAge(String id){
        return girlRepository.findByAge(id);
    }
}
