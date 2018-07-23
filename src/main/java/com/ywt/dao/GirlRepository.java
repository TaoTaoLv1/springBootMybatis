package com.ywt.dao;

import com.ywt.entity.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GirlRepository {

    @Select("SELECT * FROM girl WHERE age = #{id}")
    List<Girl> findByAge(String id);
}
