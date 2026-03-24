package org.example.chapter_20.gamecrud;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {

    @PostMapping("/api/insert-data")
    public void insertData(@RequestBody GameDto gameDto) {
        System.out.println("insertData" + gameDto.toString());
    }

}
