/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Andres Soto
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }

    /**
     * Test of save method, of class UserService.
     */
    @Mock
    private UserRepository userRepository;
    
    @Test
    public void testSave() {
        System.out.println("save");
        
        User sended = new User(null, "Soto","123","Andres Soto", "a.soto@utp.edu.co");
        User resulted = new User(1L, "Soto","123","Andres Soto", "a.soto@utp.edu.co");
        when(userRepository.save(sended)).thenReturn(resulted);
        
        UserDto user = new UserDto(1L, "Soto","123","Andres Soto", "a.soto@utp.edu.co");
        UserService instance = new UserService(userRepository, new ModelMapper());
        UserDto expResult = new UserDto(1L, "Soto","123","Andres Soto", "a.soto@utp.edu.co");
        
        UserDto result = instance.save(user);
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());

    }
    
}
