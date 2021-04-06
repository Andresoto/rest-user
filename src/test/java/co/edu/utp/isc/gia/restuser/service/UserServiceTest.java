/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Andres Soto
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }

    @Test
    public void testSave() {
        System.out.println("save");
        UserDto user = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.save(user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

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
    
}
