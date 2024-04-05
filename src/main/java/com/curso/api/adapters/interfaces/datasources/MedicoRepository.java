package com.curso.api.adapters.interfaces.datasources;

import com.curso.api.core.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
