/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;



/**
 *
 * @author Andres Soto
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }
    
    private UserRepository userRepository;  //Objeto imitador, objeto dummie
    private ModelMapper modelMapper;
    
    @BeforeEach
    public void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = new ModelMapper();
    }

    @Test
    public void testSave() {
        
         System.out.println("Save");
        
        User resulted = new User(1L, "andresoto", "123", "Andres", "a.soto@utp.edu.co");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        UserDto user = new UserDto(1L, "andresoto", "123", "Andres", "a.soto@utp.edu.co");
        UserService instance = new UserService(userRepository, modelMapper);
        UserDto result = instance.save(user);        
        
        UserDto expResult = new UserDto(1L, "andresoto", "123", "Andres", "a.soto@utp.edu.co");      
        
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getId(), result.getId());
        
    }
    /*
    @Test
    public void testListAll() {
        System.out.println("listAll");
        UserService instance = null;
        List<UserDto> expResult = null;
        List<UserDto> result = instance.listAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindOne() {
        System.out.println("findOne");
        Long id = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.findOne(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.delete(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        long id = 0L;
        UserDto user = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.update(id, user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
}
