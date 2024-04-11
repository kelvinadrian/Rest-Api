package com.medico.api.adapters.interfaces.usecases;

import com.medico.api.adapters.dto.request.DadosAtualizarMedico;
import com.medico.api.adapters.interfaces.gateway.MedicoGateway;
import com.medico.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoUseCase {

    void create(Medico medico, MedicoGateway medicoGateway);
    Page<Medico> findAll(MedicoGateway medicoGateway, Pageable page);

    Medico getReferenceById(Long id, MedicoGateway medicoGateway);

    void atualizar(Medico medico, DadosAtualizarMedico dados);

    void delete(Long id, MedicoGateway medicoGateway);
}
