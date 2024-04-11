package com.medico.api.adapters.interfaces.datasources;

import com.medico.api.core.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
