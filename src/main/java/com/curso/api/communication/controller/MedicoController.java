package com.curso.api.communication.controller;

import com.curso.api.adapters.builders.MedicoBuilder;
import com.curso.api.adapters.dto.request.DadosCadastroMedico;
import com.curso.api.adapters.dto.response.DadosResponseMedico;
import com.curso.api.adapters.interfaces.gateway.MedicoGateway;
import com.curso.api.adapters.interfaces.usecases.MedicoUseCase;
import com.curso.api.core.entity.Medico;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medico")
public class MedicoController {

    final MedicoGateway medicoGateway;
    final MedicoUseCase medicoUseCase;

    public MedicoController(MedicoGateway medicoGateway, MedicoUseCase medicoUseCase) {
        this.medicoGateway = medicoGateway;
        this.medicoUseCase = medicoUseCase;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico){
        var medico = MedicoBuilder.fromRequestToDomain(dadosCadastroMedico);
        medicoUseCase.create(medico, medicoGateway);
    }

    @GetMapping
    public Page<DadosResponseMedico> findAll(@PageableDefault(sort = {"nome"}) Pageable page){
        var medico = medicoUseCase.findAll(medicoGateway, page);

        return medico.map(MedicoBuilder::fromDomainToResponse);
    }

    @PutMapping
    public void atualizar(){

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

    }
}
