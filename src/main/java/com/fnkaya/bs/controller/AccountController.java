package com.fnkaya.bs.controller;

import com.fnkaya.bs.dto.LoginRequest;
import com.fnkaya.bs.dto.RegistrationRequest;
import com.fnkaya.bs.dto.TokenResponse;
import com.fnkaya.bs.model.User;
import com.fnkaya.bs.repository.UserRepository;
import com.fnkaya.bs.security.JwtTokenUtil;
import com.fnkaya.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final User user = userRepository.findByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUsername(), token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        return ResponseEntity.ok(userService.register(registrationRequest));
    }
}
