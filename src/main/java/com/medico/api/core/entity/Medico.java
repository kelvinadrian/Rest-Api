package com.medico.api.core.entity;

import com.medico.api.adapters.dto.request.DadosAtualizarMedico;
import com.medico.api.adapters.enums.EspecialidadeEnum;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medico")
@Entity(name= "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String telefone;
    String crm;
    @Enumerated(EnumType.STRING)
    EspecialidadeEnum especialidade;

    @Embedded
    Endereco endereco;

    public void atualizarInformacoes(DadosAtualizarMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
}
