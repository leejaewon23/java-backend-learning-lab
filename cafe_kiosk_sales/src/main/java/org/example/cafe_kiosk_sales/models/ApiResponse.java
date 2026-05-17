package org.example.cafe_kiosk_sales.models;

import org.example.cafe_kiosk_sales.ResponseCode;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApiResponse<T> {
	private ResponseCode code;
	private String message;
	private T responseData;
}
