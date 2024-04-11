package com.curso.api.adapters.interfaces.gateway;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioGateway {

    UserDetails findByUsername(String username);
}
