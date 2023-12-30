package com.gnpshop.repository;

import com.gnpshop.entities.Author;
import com.gnpshop.entities.Order;
import com.gnpshop.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserAccountRepository /*extends JpaRepository<UserAccount, Integer>*/ {
    Iterable<UserAccountRepository> findUserAccountById(Integer id);

    boolean existsUserAccountLogin(String useraccountlogin);
}
