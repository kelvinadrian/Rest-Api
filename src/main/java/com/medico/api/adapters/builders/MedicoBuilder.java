package com.medico.api.adapters.builders;

import com.medico.api.adapters.dto.request.DadosCadastroMedico;
import com.medico.api.adapters.dto.response.DadosDetalheMedico;
import com.medico.api.adapters.dto.response.DadosResponseMedico;
import com.medico.api.core.entity.Endereco;
import com.medico.api.core.entity.Medico;

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

    public static DadosDetalheMedico fromDomainToDetail(Medico medico){
        return DadosDetalheMedico.builder()
                .nome(medico.getNome())
                .email(medico.getEmail())
                .telefone(medico.getTelefone())
                .crm(medico.getCrm())
                .especialidade(medico.getEspecialidade())
                .endereco(medico.getEndereco())
                .build();
    }
}
