package com.medico.api.adapters.dto.request;

import com.medico.api.adapters.dto.DadosEndereco;
import com.medico.api.adapters.enums.EspecialidadeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @Pattern(regexp = "\\d{4,6}")
        @NotBlank
        String crm,
        @NotNull
        EspecialidadeEnum especialidade,
        @Valid
        @NotNull
        DadosEndereco endereco) {

}
