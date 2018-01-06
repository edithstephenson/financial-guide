package br.com.buw.financialguide.security.services;

import java.util.Optional;

import br.com.buw.financialguide.security.entities.User;

public interface UserService {
	Optional<User> findByLogin(String login);
}