package br.com.buw.financialguide.security.services.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.buw.financialguide.security.entities.User;
import br.com.buw.financialguide.security.services.UserService;

@Service
public class UserDetailsServiceProvider implements UserDetailsService {
	
	private static org.springframework.security.core.userdetails.User userDetails;
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = 
				userService.findByLogin(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado."));

		return  userDetails.withUsername(user.getLogin())
						  .password(user.getPassword())
						  .authorities(new ArrayList<>())
						  .build();
	}

}
