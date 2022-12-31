package com.niit.C13_s4_pc1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Customer already Exists")
public class CustomerAlreadyExistException extends Exception{
}
