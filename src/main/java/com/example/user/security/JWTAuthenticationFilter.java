/*
 * package com.example.user.security;
 * 
 * import java.io.IOException; import java.util.ArrayList;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.example.user.entity.UserEntity; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * public class JWTAuthenticationFilter extends
 * UsernamePasswordAuthenticationFilter {
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private JwtUtills jwtUtills;
 * 
 * 
 * public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
 * this.authenticationManager = authenticationManager;
 * 
 * setFilterProcessesUrl("/v1/auth/login"); }
 * 
 * @Override public Authentication attemptAuthentication(HttpServletRequest
 * request, HttpServletResponse response) throws AuthenticationException {
 * 
 * try { UserEntity userCreds = new
 * ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
 * 
 * return authenticationManager.authenticate(new
 * UsernamePasswordAuthenticationToken(userCreds.getUserName(),
 * userCreds.getPassword(), new ArrayList<>()));
 * 
 * 
 * } catch (IOException e) { // TODO Auto-generated catch block throw new
 * RuntimeException(e); } // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override protected void successfulAuthentication(HttpServletRequest request,
 * HttpServletResponse response, FilterChain chain, Authentication authResult)
 * throws IOException, ServletException { String token =
 * jwtUtills.generateToken(((User) authResult.getPrincipal())); String body =
 * ((User) authResult.getPrincipal()).getUsername() + " " + token;
 * 
 * response.getWriter().write(body); response.getWriter().flush();
 * 
 * }
 * 
 * 
 * }
 */