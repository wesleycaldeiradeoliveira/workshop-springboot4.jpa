package com.wesleydev.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleydev.Web.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
