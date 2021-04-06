package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.exception.BadRequestException;
import co.edu.utp.isc.gia.restuser.exception.InvalidUserException;
import co.edu.utp.isc.gia.restuser.exception.UserNotFoundException;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
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
 
    
    public UserDto save(UserDto user) {
        if (user == null) {
            throw new BadRequestException("Parametros no valido");
        } else if (user.getUsername() == null || user.getUsername().isEmpty()){
            throw new InvalidUserException("El username no puede ir nulo");
        }else if (user.getEmail() == null || user.getEmail().isEmpty()){
            throw new InvalidUserException("El email no puede ir nulo");
        }else {
            User myUser = modelMapper.map(user, User.class);
            myUser = userRepository.save(myUser);
            UserDto resp = modelMapper.map(myUser, UserDto.class);
            return resp;
        }
    }
    
    public List<UserDto> listAll() {
        List<UserDto> userDto = null;
        List<User> users = (List<User>) userRepository.findAll();
        if (users != null && !users.isEmpty() ) {
            userDto = new ArrayList<>();
            for (User user : users) {
                userDto.add(modelMapper.map(user, UserDto.class));
            }
        }else{
            throw new UserNotFoundException("Users not Found" );
        }
        return userDto;
    }
    
    public UserDto findOne(Long id) {
        if(userRepository.existsById(id)) {
            return modelMapper.map(userRepository.findById(id).get(), UserDto.class);
        }else{
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }
    }
    
    public UserDto delete(long id) {
        if(userRepository.existsById(id)) {
            UserDto userDelete = findOne(id);
            userRepository.deleteById(id);
            return userDelete;
        }else{
            throw new UserNotFoundException("User id : "+id+ " not Found" );
        }
    }
    
    
    public UserDto update(long id, UserDto user) {
        if (user == null) {
            throw new BadRequestException("Parametros no valido");
        } else if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new InvalidUserException("El username no puede ir nulo");
        } else if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidUserException("El email no puede ir nulo");
        } else {
            if (userRepository.existsById(id)) {
                user.setId(id);
                userRepository.save(modelMapper.map(user, User.class));
                return findOne(id);
            } else {
                throw new UserNotFoundException("User Not Found");
            }
        }
    }
    
}