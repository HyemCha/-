package springmvc.reqandres.exhandler.advice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springmvc.reqandres.data.ApiResponse;
import springmvc.reqandres.data.MemberDto;
import springmvc.reqandres.data.ResponseStatus;
import springmvc.reqandres.exception.CustomException;

@Slf4j
@RestControllerAdvice
public class CustomControllerAdvice {

    public static final String ERROR_EXCEPTION = "javax.servlet.error.exception";
    public static final String ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type";
    public static final String ERROR_MESSAGE = "javax.servlet.error.message";
    public static final String ERROR_REQUEST_URI = "javax.servlet.error.request_uri";
    public static final String ERROR_SERVLET_NAME = "javax.servlet.error.servlet_name";
    public static final String ERROR_STATUS_CODE = "javax.servlet.error.status_code";

    @ExceptionHandler
    public ApiResponse<MemberDto> gradeOutOfBoundsExHandler(CustomException e) {
        log.error("[grade exceptionHandler] ex", e);
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(2000);
        responseStatus.setMessage(e.getMessage());
//        return new ResponseEntity<>(responseStatus, HttpStatus.OK);
        return new ApiResponse<>(2000, e.getMessage(), e.getGrade());
    }
}
