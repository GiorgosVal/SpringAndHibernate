package org.example.springrestdemo.mvc.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BadRequestApiResponse extends ApiResponse {

    private Object suggestion;
}
