package com.gnpshop.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                (ApplicationUser) User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .build(),
                (ApplicationUser) User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .roles("ADMIN")
                        .build());
//                new ApplicationUser(
//                        "annasmith",
//                        passwordEncoder.encode("password"),
//                        .getGrantedAuthorities(),
//                        true,
//                        true,
//                        true, true),
//                new ApplicationUser("linda",
//                        passwordEncoder.encode("password"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true),
//                new ApplicationUser("tom",
//                        passwordEncoder.encode("password"),
//                        ADMINTRAINEE.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true));

        return applicationUsers;
    }

}
