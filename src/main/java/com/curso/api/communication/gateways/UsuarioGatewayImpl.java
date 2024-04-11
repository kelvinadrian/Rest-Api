package com.curso.api.communication.gateways;

import com.curso.api.adapters.interfaces.datasources.UsuarioRepository;
import com.curso.api.adapters.interfaces.gateway.UsuarioGateway;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioGatewayImpl implements UsuarioGateway {

    final UsuarioRepository usuarioRepository;

    public UsuarioGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
