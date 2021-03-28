/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.exception.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Andres Soto
 */

@Service
public class UserService {
        
    private List<UserDto> users = new ArrayList<>();
    
    public UserDto save(UserDto user) {
        if(users.size() == 0) {
            user.setId(1L);
            user.setUsername(user.getUsername().toLowerCase());
        }else {
            UserDto userInfo = new UserDto();
            userInfo = users.get(users.size() - 1);
            user.setUsername(user.getUsername().toLowerCase());
            
            user.setId(userInfo.getId() + 1);
        }
        users.add(user);
        
        return user;
    }
    
    public List<UserDto> listAll() {
        return users;
    }
    
    public UserDto findOne(Long id) {
        int i = searchById(id, users);
        if (i == -1) {
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }else{
            return users.get(i);
        }
    }
    
    public UserDto update(@PathVariable ("id") long id, @RequestBody UserDto user) {
        int i = searchById(id, users);
        if (i == -1) {
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }else{
            user.setId(id);
            users.set(i, user);        
            return users.get(i);
        }
    }
    

    public UserDto delete(@PathVariable ("id") long id) {
        return users.remove(Math.toIntExact(id - 1));
    }
    
    private int searchById (Long id, List<UserDto> users) {
       for (int i=0; i<users.size(); i++) {
            if (id.equals(users.get(i).getId())) return i;               
        }
        return -1;
    }
    
}
