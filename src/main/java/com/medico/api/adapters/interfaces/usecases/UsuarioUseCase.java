package com.medico.api.adapters.interfaces.usecases;

import com.medico.api.adapters.interfaces.gateway.UsuarioGateway;
import com.medico.api.core.entity.Usuario;

public interface UsuarioUseCase {

    void create(Usuario usuario, UsuarioGateway usuarioGateway);
}
