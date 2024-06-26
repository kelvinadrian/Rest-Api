package com.medico.api.core.usecases;

import com.medico.api.adapters.dto.request.DadosAtualizarMedico;
import com.medico.api.adapters.interfaces.gateway.MedicoGateway;
import com.medico.api.adapters.interfaces.usecases.MedicoUseCase;
import com.medico.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Medico getReferenceById(Long id, MedicoGateway medicoGateway) {
        return medicoGateway.getReferenceById(id);
    }

    @Override
    @Transactional
    public void atualizar(Medico medico, DadosAtualizarMedico dados) {
        medico.atualizarInformacoes(dados);
    }

    @Override
    public void delete(Long id, MedicoGateway medicoGateway) {
        medicoGateway.delete(id);
    }
}
