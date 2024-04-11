package com.medico.api.adapters.dto.response;

import com.medico.api.adapters.enums.EspecialidadeEnum;
import com.medico.api.core.entity.Endereco;
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
