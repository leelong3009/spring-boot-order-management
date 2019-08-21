package com.lemisa.repository;

import java.util.Optional;

import com.lemisa.domain.User;

public interface UserDao extends Dao<User> {

	Optional<User> findByUsername(String userName);

}
