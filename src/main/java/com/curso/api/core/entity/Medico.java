package com.curso.api.core.entity;

import com.curso.api.adapters.enums.EspecialidadeEnum;
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
}
