package com.example.sistemaPulseira.infra;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class RestErrorMessage {
 private HttpStatus status;
 private String message;


}
