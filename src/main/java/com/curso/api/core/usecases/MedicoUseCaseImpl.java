package com.curso.api.core.usecases;

import com.curso.api.adapters.interfaces.gateway.MedicoGateway;
import com.curso.api.adapters.interfaces.usecases.MedicoUseCase;
import com.curso.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoUseCaseImpl implements MedicoUseCase {

    @Override
    public void create(Medico medico, MedicoGateway medicoGateway) {
        medicoGateway.save(medico);
    }

    @Override
    public Page<Medico> findAll(MedicoGateway medicoGateway, Pageable page) {
        return medicoGateway.findAll(page);
    }
}
