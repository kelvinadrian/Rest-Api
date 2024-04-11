package com.curso.api.adapters.dto.response;

import com.curso.api.adapters.enums.EspecialidadeEnum;
import com.curso.api.core.entity.Endereco;
import lombok.Builder;

@Builder
public record DadosDetalheMedico(

        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        EspecialidadeEnum especialidade,
        Endereco endereco
) { }
