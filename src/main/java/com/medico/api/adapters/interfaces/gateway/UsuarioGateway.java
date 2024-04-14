package com.medico.api.adapters.interfaces.gateway;

import com.medico.api.core.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioGateway {

    UserDetails findByUsername(String username);
    void save(Usuario usuario);
}
