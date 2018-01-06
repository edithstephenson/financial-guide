package br.com.buw.financialguide.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.buw.financialguide.security.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByLogin(String login);
}
