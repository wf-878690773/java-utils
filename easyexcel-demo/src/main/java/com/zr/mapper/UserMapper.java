package com.zr.mapper;

import com.zr.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.MySqlMapper;

import javax.persistence.Id;
import java.util.List;

@Mapper
public interface UserMapper {


    int batchInsert(List<User> userList);

    @Select("select * from user")
    List<User> selectAll();
}
