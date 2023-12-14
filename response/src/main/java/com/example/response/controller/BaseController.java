package com.example.response.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.response.ApiResponse;
import com.example.response.exception.CustomExceptionV1;
import com.example.response.exception.CustomExceptionV2;
import com.example.response.exception.ExceptionContext;
import jakarta.servlet.http.HttpServletResponse;

abstract public class BaseController {

  public <T> ApiResponse<T> makeResponse(T result) {
    return makeResponse(Collections.singletonList(result));
  }
  public <T> ApiResponse<T> makeResponse(List<T> results) {
    return new ApiResponse<T>(results);
  }

  /**
   * v1
   * @param response
   * @param customExceptionV1
   * @return
   * @param <T>
   */
  @ExceptionHandler(CustomExceptionV1.class)
  public <T> ApiResponse<T> customExceptionHandlerV1(HttpServletResponse response, CustomExceptionV1 customExceptionV1){
    response.setStatus(customExceptionV1.getErrorCode().getHttpStatus().value());
    return new ApiResponse<T>(
      customExceptionV1.getErrorCode().getCode(),
      customExceptionV1.getErrorCode().getMessage(),
      customExceptionV1.getData()
      );
  }


  /**
   * v1
   * @param response
   * @param customExceptionV2
   * @return
   * @param <T>
   */
  @ExceptionHandler(CustomExceptionV2.class)
  public <T> ApiResponse<T> customExceptionHandlerV2(HttpServletResponse response, CustomExceptionV2 customExceptionV2){
    response.setStatus(customExceptionV2.getErrorCode().getHttpStatus().value());
    return new ApiResponse<T>(
      customExceptionV2.getErrorCode().getCode(),
      customExceptionV2.getErrorCode().getMessage(),
      ExceptionContext.threadLocal.get()
    );
  }
}
