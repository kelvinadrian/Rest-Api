package com.curso.api.adapters.dto.response;

import com.curso.api.adapters.enums.EspecialidadeEnum;
import lombok.Builder;

@Builder
public record DadosResponseMedico(

        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidade
) {
}
