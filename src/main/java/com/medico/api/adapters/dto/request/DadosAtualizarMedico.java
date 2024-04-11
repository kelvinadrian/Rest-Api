package com.medico.api.adapters.dto.request;

import com.medico.api.adapters.dto.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
