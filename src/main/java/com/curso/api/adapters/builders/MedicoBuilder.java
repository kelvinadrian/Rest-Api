package com.curso.api.adapters.builders;

import com.curso.api.adapters.dto.request.DadosCadastroMedico;
import com.curso.api.adapters.dto.response.DadosResponseMedico;
import com.curso.api.core.entity.Endereco;
import com.curso.api.core.entity.Medico;

public class MedicoBuilder {

    public static Medico fromRequestToDomain(DadosCadastroMedico dados){
        return Medico.builder()
                .crm(dados.crm())
                .email(dados.email())
                .telefone(dados.telefone())
                .nome(dados.nome())
                .especialidade(dados.especialidade())
                .endereco(
                        Endereco.builder()
                                .cep(dados.endereco().cep())
                                .uf(dados.endereco().uf())
                                .bairro(dados.endereco().bairro())
                                .cidade(dados.endereco().cidade())
                                .complemento(dados.endereco().complemento())
                                .logradouro(dados.endereco().logradouro())
                                .build()
                )
                .build();
    }

    public static DadosResponseMedico fromDomainToResponse(Medico medico){
        return DadosResponseMedico.builder()
                .id(medico.getId())
                .crm(medico.getCrm())
                .email(medico.getEmail())
                .nome(medico.getNome())
                .especialidade(medico.getEspecialidade())
                .build();
    }
}
