package org.example.cookies.biz.file;

import org.example.cookies.models.attach.AttachDto;
import org.example.cookies.models.common.ApiResponse;
import org.example.cookies.models.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.example.cookies.models.cookie.CookieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/file")
public class FileRestController {
	@Autowired
	private CookieFileService cookieFileService;

	@PostMapping("/upload")
	public ResponseEntity<ApiResponse<String>> upload(@RequestPart CookieDto cookieDto
		, @RequestPart List<MultipartFile> files) {
		log.info("upload cookie dto {}", cookieDto);
		files.forEach(file-> {log.info("upload cookie files {}", file);});
		try {
			List<AttachDto> result = this.cookieFileService.insert(cookieDto, files);
		} catch (IOException e) {
			log.error(e.getMessage());
			return ResponseEntity.status(400).body(
					ApiResponse.make(ResponseCode.insert_failed, "error", "error of file")
			);
		}
		return ResponseEntity.status(201).body(
				ApiResponse.make(ResponseCode.insert_ok, "ok", "success")
		);
	}
}
