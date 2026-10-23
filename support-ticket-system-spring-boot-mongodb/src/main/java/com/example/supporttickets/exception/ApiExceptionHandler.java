package com.example.supporttickets.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(TicketNotFoundException.class) public ResponseEntity<Map<String,Object>> notFound(TicketNotFoundException ex){return build(HttpStatus.NOT_FOUND,ex.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){String msg=ex.getBindingResult().getFieldErrors().stream().map(e->e.getField()+": "+e.getDefaultMessage()).collect(Collectors.joining("; "));return build(HttpStatus.BAD_REQUEST,msg);}
 @ExceptionHandler(HttpMessageNotReadableException.class) public ResponseEntity<Map<String,Object>> unreadable(HttpMessageNotReadableException ex){return build(HttpStatus.BAD_REQUEST,"Invalid request body or enum value.");}
 private ResponseEntity<Map<String,Object>> build(HttpStatus status,String message){Map<String,Object> body=new LinkedHashMap<>();body.put("timestamp",Instant.now());body.put("status",status.value());body.put("error",status.getReasonPhrase());body.put("message",message);return ResponseEntity.status(status).body(body);}
}
