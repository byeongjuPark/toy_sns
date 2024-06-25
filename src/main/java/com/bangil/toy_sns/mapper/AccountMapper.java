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

    @Insert("INSERT INTO accounts values(tmp_seq.NEXTVAL, #{id}, #{pw}, #{sex})")
    void insertAccount(Account user);

    @Select("SELECT * FROM accounts")
    List<Account> findAll();

    @Select("SELECT * FROM accounts")
    ArrayList<HashMap<String, Object>> findAllByMap();

   
}

