package com.curso.api.adapters.interfaces.gateway;

import com.curso.api.core.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MedicoGateway {

    void save(Medico medico);
    Page<Medico> findAll(Pageable page);
}
