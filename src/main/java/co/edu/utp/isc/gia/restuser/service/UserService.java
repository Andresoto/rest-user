package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.exception.InvalidUserException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Soto
 */

@Service
public class UserService {
        
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper =  modelMapper;
    }

    UserService(UserRepository userRepository) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public UserDto save(UserDto user) {
        if (user.getEmail() == null || user.getName() == null || user.getPassword() == null || user.getUsername() == null) {
            throw new BadRequestException("Parametro no valido");
        } else {
            User myUser = modelMapper.map(user, User.class);
            myUser = userRepository.save(myUser);
            UserDto resp = modelMapper.map(myUser, UserDto.class);
            return resp;
        }
    }
    /*
    public List<UserDto> listAll() {
        return null;
    }
    
    public UserDto findOne(Long id) {
        //int i = searchById(id, users);
        //if (i == -1) {
        //    throw new UserNotFoundException("User id : "+id+ " not Found" );
        //}else{
        //    return users.get(i);
        //}
        return null;
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
    */
}
