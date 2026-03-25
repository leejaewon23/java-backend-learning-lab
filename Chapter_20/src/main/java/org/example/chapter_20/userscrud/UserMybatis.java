package org.example.chapter_20.userscrud;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMybatis {
    int insertData(UserDto userDto);
}
