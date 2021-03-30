/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Andres Soto
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidUserException extends RuntimeException {
    
    public InvalidUserException(String message) {
        super(message);
    }
    
}
