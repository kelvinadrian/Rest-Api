package com.medico.api.communication.gateways;

import com.medico.api.adapters.interfaces.datasources.MedicoRepository;
import com.medico.api.adapters.interfaces.gateway.MedicoGateway;
import com.medico.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MedicoGatewayImpl implements MedicoGateway {

    private final MedicoRepository medicoRepository;

    public MedicoGatewayImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    @Transactional
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public Page<Medico> findAll(Pageable page) {
        return medicoRepository.findAll(page);
    }

    @Override
    public Medico getReferenceById(Long id) {
        return medicoRepository.getReferenceById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }
}
