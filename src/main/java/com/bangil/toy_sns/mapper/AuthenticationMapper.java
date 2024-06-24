package com.bangil.toy_sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bangil.toy_sns.domain.Account;

@Mapper
public interface AuthenticationMapper {

    @Select("SELECT * FROM accounts where id = '${id}'")
    List<Account> findById(String id);
    
}
