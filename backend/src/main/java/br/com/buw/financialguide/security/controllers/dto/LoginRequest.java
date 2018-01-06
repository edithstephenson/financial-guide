package br.com.buw.financialguide.security.controllers.dto;

import lombok.Data;

@Data
public class LoginRequest {
	private String login;
	private String password;
}