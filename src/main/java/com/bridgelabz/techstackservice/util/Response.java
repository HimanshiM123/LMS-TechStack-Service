package com.bridgelabz.techstackservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Response {
    private String message;
    private int errorCode;
    private Object token;

    public Response() {

    }
}
