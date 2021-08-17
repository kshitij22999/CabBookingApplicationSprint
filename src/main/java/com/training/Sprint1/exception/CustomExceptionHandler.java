package com.training.Sprint1.exception;

import java.util.ArrayList;
import java.util.List;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler 

{
	@ExceptionHandler(AdminNotFoundException.class)
    public final ResponseEntity<Object> handleAdminNotFoundException(AdminNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("AdminNotFoundException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CabNotFoundException.class)
    public final ResponseEntity<Object> handleCabNotFoundException(CabNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("CabNotFoundException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
 
    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("CustomerNotFoundException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DriverDoesNotExistException.class)
    public final ResponseEntity<Object> handleDriverDoesNotExistException(DriverDoesNotExistException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
 
        ErrorResponse error = new ErrorResponse("DriverDoesNotExistException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidUserOrPasswordException.class)
    public final ResponseEntity<Object> handleInvalidUserOrPasswordException(InvalidUserOrPasswordException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("InvalidUserOrPasswordException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TripBookingNotFoundException.class)
    public final ResponseEntity<Object> handleTripBookingNotFoundException(TripBookingNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("TripBookingNotFoundException", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
   
}