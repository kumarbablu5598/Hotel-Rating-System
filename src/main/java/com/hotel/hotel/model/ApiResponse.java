package com.hotel.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String massage;
    private boolean success;
    private HttpStatus status;
}
