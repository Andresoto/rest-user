/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Soto
 */
@RestController
@RequestMapping("user")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping() // POST http://localhost:8080/user
    public UserDto save(@RequestBody UserDto user) {
            // TODO  devolver codigo 204 bad request con mensaje "Datos de usiario invalido"
        return userService.save(user);  
    }
    /*
    @GetMapping()
    public List<UserDto> getAll() {
        //TODO devolver no content cuando la lista este vacia
        return userService.listAll(); //TODO devolver 200 OK
    }
    
    @GetMapping("/{id}") 
    public UserDto getOne (@PathVariable ("id") long id) {
        return userService.findOne(id);
    }
    
    @PutMapping("/{id}") 
    public UserDto updateOne (@PathVariable ("id") long id, @RequestBody UserDto user) {
        return userService.update(id, user);
    }
    
    @DeleteMapping("/{id}") 
    public UserDto removeOne (@PathVariable ("id") long id) {
        return userService.delete(id);
    }
*/
}
