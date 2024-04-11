package com.medico.api.adapters.interfaces.gateway;

import com.medico.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoGateway {

    void save(Medico medico);
    Page<Medico> findAll(Pageable page);

    Medico getReferenceById(Long id);

    void delete(Long id);
}
