package org.example.springrestdemo.mvc.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private int status;
    private String message;
    private long timestamp;

}
