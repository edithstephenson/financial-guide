package br.com.buw.financialguide.security.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.buw.financialguide.security.controllers.dto.LoginRequest;
import br.com.buw.financialguide.security.controllers.dto.LoginResponse;
import br.com.buw.financialguide.security.utils.JwtTokenUtil;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	
	@PostMapping
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
			throws AuthenticationException {
		LoginResponse response = new LoginResponse();

		
		UsernamePasswordAuthenticationToken userToAuthenticate =
				new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(userToAuthenticate);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userFromDatabase = userDetailsService.loadUserByUsername(loginRequest.getLogin());
		
		String token = jwtTokenUtil.obterToken(userFromDatabase);
		response.setToken(token);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/refresh")
	public ResponseEntity<LoginResponse> refreshToken(HttpServletRequest request) {
		
		LoginResponse response = new LoginResponse();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));

		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}

		if (!token.isPresent()) {
			throw new RuntimeException("Token não informado.");
		} else if (!jwtTokenUtil.tokenValido(token.get())) {
			throw new RuntimeException("Token inválido ou expirado.");
		}

		String refreshedToken = jwtTokenUtil.refreshToken(token.get());
		response.setToken(refreshedToken);

		return ResponseEntity.ok(response);
	}
}
