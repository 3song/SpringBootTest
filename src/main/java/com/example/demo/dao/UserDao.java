package com.example.demo.dao;
import java.util.List;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {
    //查询列表，演示使用传统的mapper映射文件
    List<User> getUserList();
    //插入，演示使用注解编写sql，省略xml配置
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "AUTOID")
    @SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select sys_guid() from dual")
    @Insert("insert into Users(AutoId,USERNAME) values(#{id},#{username})")
    int addUser(User user);
}