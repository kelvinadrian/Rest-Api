package com.medico.api.core.usecases;

import com.medico.api.adapters.interfaces.gateway.UsuarioGateway;
import com.medico.api.adapters.interfaces.usecases.UsuarioUseCase;
import com.medico.api.core.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Override
    public void create(Usuario usuario, UsuarioGateway usuarioGateway) {
        Usuario existingUser = (Usuario) usuarioGateway.findByUsername(usuario.getUsername());

        // Se existingUser não for nulo, significa que já existe um usuário com o mesmo username
        if (existingUser != null) {
            throw new IllegalStateException("Já existe um usuário com o mesmo username.");
        }

        usuarioGateway.save(usuario);
    }
}
