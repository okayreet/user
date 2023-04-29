package com.catalogue.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogue.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
