
package co.edu.utp.isc.gia.restuser.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Andres Soto
 */
@RestControllerAdvice
public class CustumizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
            request.getDescription(false),HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidUserException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidException(InvalidUserException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
            request.getDescription(false),HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadReqException(BadRequestException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
            request.getDescription(false),HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
     
}
