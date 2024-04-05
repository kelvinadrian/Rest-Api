package com.curso.api.adapters.interfaces.usecases;

import com.curso.api.adapters.interfaces.gateway.MedicoGateway;
import com.curso.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MedicoUseCase {

    void create(Medico medico, MedicoGateway medicoGateway);
    Page<Medico> findAll(MedicoGateway medicoGateway, Pageable page);
}
