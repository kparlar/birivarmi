package com.birivarmi.birivarmiapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.birivarmi.birivarmiapp.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
