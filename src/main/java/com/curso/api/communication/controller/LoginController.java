package com.curso.api.communication.controller;

import com.curso.api.adapters.dto.TokenJWT;
import com.curso.api.adapters.dto.request.LoginRequest;
import com.curso.api.adapters.security.TokenService;
import com.curso.api.core.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest){
        var AuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        var authentication = manager.authenticate(AuthenticationToken);

        var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(token));

    }
}
