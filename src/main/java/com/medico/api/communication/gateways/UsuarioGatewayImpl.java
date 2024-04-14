package com.medico.api.communication.gateways;

import com.medico.api.adapters.interfaces.datasources.UsuarioRepository;
import com.medico.api.adapters.interfaces.gateway.UsuarioGateway;
import com.medico.api.core.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioGatewayImpl implements UsuarioGateway {

    final UsuarioRepository usuarioRepository;

    public UsuarioGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void save(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }
}
