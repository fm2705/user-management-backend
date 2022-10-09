package com.usermanagement.system.service;

import com.usermanagement.system.entity.UserEntity;
import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        //gives the entire list of the entities that are saved i the database
        List<UserEntity> userEntities
                = userRepository.findAll();
        //convert that list of entities to a list of users to send back to the controller
        //and that will send back as a response to the client
        List<User> users = userEntities
                //stream through the list of entities
                .stream()
                //and convert that to a list of user objects
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirstName(),
                        userEntity.getLastName(),
                        userEntity.getEmailId()
                ))
                //collect all user entities and convert it to the list of users
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity
                = userRepository.findById(id).get();
        User user = new User();
        //convert userEntity to a new user
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }


}



