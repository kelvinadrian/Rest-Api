package com.medico.api.communication.controller;

import com.medico.api.adapters.builders.UsuarioBuilder;
import com.medico.api.adapters.dto.request.UsuarioCadastroRequest;
import com.medico.api.adapters.interfaces.gateway.UsuarioGateway;
import com.medico.api.adapters.interfaces.usecases.UsuarioUseCase;
import com.medico.api.core.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioGateway usuarioGateway;
    UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioGateway usuarioGateway, UsuarioUseCase usuarioUseCase) {
        this.usuarioGateway = usuarioGateway;
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid UsuarioCadastroRequest usuarioCadastroRequest){
        try {
            Usuario usuario = UsuarioBuilder.fromRequestToDomain(usuarioCadastroRequest);

            usuarioUseCase.create(usuario, usuarioGateway);
        }catch (IllegalStateException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }
}
