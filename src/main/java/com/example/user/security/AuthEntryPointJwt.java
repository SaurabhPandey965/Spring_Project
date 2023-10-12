package com.example.user.security;

import java.io.IOException;

import javax.servlet.ServletException;
//Handle Authentication Exception

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
//
public class AuthEntryPointJwt extends AuthenticationEntryPointFailureHandler{

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	public AuthEntryPointJwt(AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationEntryPoint);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	    logger.error("Unauthorized error: {}", exception.getMessage());
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "error: unauthorized");
		super.onAuthenticationFailure(request, response, exception);
	}


	
	}

