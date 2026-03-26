package org.example.chapter_20.gamecrud;

import jakarta.annotation.PostConstruct;
import org.example.chapter_20.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameRestController {
    @Autowired
    private GameService gameService;

    @PostMapping("/api/insert-data")
    public ResponseEntity<CommonResponse> insertData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("insertData" + gameDto.toString());
            this.gameService.insertData(gameDto);
            return ResponseEntity.ok().body(new CommonResponse(0, "OK"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }

    @PatchMapping("/api/update-data")
    public ResponseEntity<CommonResponse> updateData(@RequestBody GameDto gameDto) {
        try {
            System.out.println("insertData" + gameDto.toString());
            this.gameService.updateData(gameDto);
            return ResponseEntity.ok().body(new CommonResponse(0, "OK"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }

    @ResponseBody
    @DeleteMapping("/api/delete-data")
    public ResponseEntity<CommonResponse> deleteData(@RequestBody GameDto deleteGame) {
        try {
            System.out.println("deleteData, id=" + deleteGame.getId());
            this.gameService.deleteData(deleteGame.getId());
            return ResponseEntity.ok().body(new CommonResponse(0, "OK"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(-999, "Server Error"));
        }
    }
}
