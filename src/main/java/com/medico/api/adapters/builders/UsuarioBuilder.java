package com.medico.api.adapters.builders;

import com.medico.api.adapters.dto.request.UsuarioCadastroRequest;
import com.medico.api.core.entity.Usuario;

public class UsuarioBuilder {

    public static Usuario fromRequestToDomain(UsuarioCadastroRequest usuario){
        return Usuario.builder()
                .nome(usuario.nome())
                .username(usuario.username())
                .password(usuario.password())
                .build();
    }
}
