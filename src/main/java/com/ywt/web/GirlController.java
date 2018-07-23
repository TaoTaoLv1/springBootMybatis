package com.ywt.web;

import com.ywt.base.ResponseMessage;
import com.ywt.dao.GirlRepository;
import com.ywt.entity.Girl;
import com.ywt.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "girls")
    public ResponseMessage girlList(){
        return ResponseMessage.returnOk(girlService.getByAge("23"),"12321");
    }
}