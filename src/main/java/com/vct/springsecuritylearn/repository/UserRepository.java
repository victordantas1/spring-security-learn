package com.vct.springsecuritylearn.repository;

import com.vct.springsecuritylearn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public UserDetails findByUsername(String username);

}
