package com.usermanagement.system.service;

import com.usermanagement.system.entity.UserEntity;
import com.usermanagement.system.model.User;
import com.usermanagement.system.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


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


}



