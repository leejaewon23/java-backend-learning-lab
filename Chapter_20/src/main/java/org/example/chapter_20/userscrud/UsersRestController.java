package org.example.chapter_20.userscrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {

    @Autowired
    private UserMybatis userMybatis;   // ← Mapper 주입

    @PostMapping("/api/users/insert-data")
    public String insertData(@RequestBody UserDto userDto) {
        System.out.println("받은 데이터: " + userDto.toString());

        int result = userMybatis.insertData(userDto);  // ← DB 저장

        if (result > 0) {
            return "INSERT 성공!";
        } else {
            return "INSERT 실패!";
        }
    }
}

