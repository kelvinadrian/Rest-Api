package com.curso.api.adapters.dto.request;

import com.curso.api.adapters.dto.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
