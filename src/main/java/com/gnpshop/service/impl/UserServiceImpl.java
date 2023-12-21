package com.gnpshop.service.impl;

import com.gnpshop.entities.UserAccount;
import com.gnpshop.repository.UserAccountRepository;
import com.gnpshop.service.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public UserAccount registerUser(UserAccount userAccount) {

//        //VALIDATION
//        //TODO add more validation
//        if (StringUtils.isBlank(userAccount.getUseraccountlogin()) || StringUtils.isBlank(userAccount.getUseraccountpassword())) {
//            throw new RuntimeException("Username and password are required");
//        }


//        // Check if the username is already taken
        if (userRepository.existsUserAccountLogin(userAccount.getUseraccountlogin())) {
            throw new RuntimeException("Username is already taken");
        }
        return userRepository.save(userAccount);
    }
}
