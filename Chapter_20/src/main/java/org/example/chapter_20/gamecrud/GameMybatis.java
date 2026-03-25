package org.example.chapter_20.gamecrud;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameMybatis {
    void insertData(GameDto gameDto);
}
