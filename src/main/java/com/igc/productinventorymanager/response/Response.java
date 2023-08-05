package com.igc.productinventorymanager.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {

    private String statusMessage;
    private HttpStatus httpStatus;
    private Object object;

    public Response(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Response(String statusMessage, HttpStatus httpStatus) {
        //this.statusMessage = statusMessage;  2)
        this(statusMessage);  //1)
        this.httpStatus = httpStatus;
    }

    public Response(String statusMessage, HttpStatus httpStatus, Object object) {
        this(statusMessage, httpStatus);
        this.object = object;

    }

}
