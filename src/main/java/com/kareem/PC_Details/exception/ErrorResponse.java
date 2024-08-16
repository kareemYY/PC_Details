package com.kareem.PC_Details.exception;


import lombok.Data;

@Data
public class ErrorResponse {

    private Long timeStamp;

    private String message;

    private int status;

}
