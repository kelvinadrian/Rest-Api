package com.medico.api.adapters.dto.response;

import com.medico.api.adapters.enums.EspecialidadeEnum;
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
