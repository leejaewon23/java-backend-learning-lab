package org.example.chapter_20.userscrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMybatis userMybatis;

    public void insertData(UserDto newUser) {
        this.userMybatis.insertData(newUser);
    }
}
