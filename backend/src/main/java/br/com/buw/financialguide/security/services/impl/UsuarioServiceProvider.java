package br.com.buw.financialguide.security.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.buw.financialguide.security.entities.User;
import br.com.buw.financialguide.security.repositories.UserRepository;
import br.com.buw.financialguide.security.services.UserService;

@Service
public class UsuarioServiceProvider implements UserService {

	@Autowired
	private UserRepository usuarioRepository;

	public Optional<User> findByLogin(String login) {
		return Optional.ofNullable(this.usuarioRepository.findByLogin(login));
	}
}
