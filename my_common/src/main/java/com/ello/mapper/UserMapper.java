package com.ello.mapper;

import com.ello.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    User getById(Long id);

    @Select("select * from user where id=#{id}")
    User getById2(Long id);

    @Insert("insert into user(name,age) values(#{name},#{age}) ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertUser(User user);
}
