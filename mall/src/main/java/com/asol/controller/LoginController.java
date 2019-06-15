package com.asol.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asol.config.TokenProvider;
import com.asol.request.LoginReq;
import com.asol.security.AuthToken;
import com.asol.security.Constants;
import com.asol.security.entity.User;
import com.asol.security.services.UserServiceImpl;


//@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
//@CrossOrigin("http://localhost:4200")
@RestController
public class LoginController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenProvider jwtTokenUtil;

	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity register(@RequestBody LoginReq loginUser) throws AuthenticationException {

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getUsername(),
	                        loginUser.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        final String token = jwtTokenUtil.generateToken(authentication);
	        return ResponseEntity.ok(new AuthToken(Constants.TOKEN_PREFIX+token));
	    }
	    
	/*@Autowired
	UserService userService;
	
	@RequestMapping(value = "/first", method = RequestMethod.GET, headers = "Accept=application/json")
    public String firstMessage() {
        return
          "Welcoem to The World";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json", headers = "Accept=application/json")
    public User login(@RequestBody LoginReq login) {
		User user = userService.verifyUser(login.getUsername(), login.getPassword());
		
        if(null != user) {
        	//TODO: saveuser access here
        	
        }
        return user;
    }*/
     
    /*@RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return (Principal) (new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0]);
    }*/
}