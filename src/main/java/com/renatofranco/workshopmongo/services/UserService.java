package com.renatofranco.workshopmongo.services;

import com.renatofranco.workshopmongo.domain.User;
import com.renatofranco.workshopmongo.dto.UserDTO;
import com.renatofranco.workshopmongo.repository.UserRepository;
import com.renatofranco.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    public User insert(User obj){
        Assert.notNull(obj.getEmail(), "email should not be null");
        Assert.notNull(obj.getName(), "name should not be null");
        return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj){
        Assert.notNull(obj, "you have to submit at least one attribute to be updated");
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

}
