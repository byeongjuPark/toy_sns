package com.bangil.toy_sns.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bangil.toy_sns.domain.Account;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Mapper
public interface AccountMapper {

    @Insert("insert into account (id, pw, sex) values (#{id}, #{pw}, #{sex})")
    void insertAccount(Account user);

    @Select("SELECT * FROM account")
    List<Account> findAll();

    @Select("SELECT * FROM account")
    ArrayList<HashMap<String, Object>> findAllByMap();

    @Select("SELECT seq FROM account WHERE ID = #{id}")
    int findSeqById(String id);

}

