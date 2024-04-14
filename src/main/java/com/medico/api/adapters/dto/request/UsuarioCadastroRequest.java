package com.medico.api.adapters.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastroRequest(

    @NotBlank
    String nome,

    @NotBlank
    String username,

    @NotBlank
    String password){

}
