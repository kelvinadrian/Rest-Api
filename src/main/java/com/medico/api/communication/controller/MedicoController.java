package com.medico.api.communication.controller;

import com.medico.api.adapters.builders.MedicoBuilder;
import com.medico.api.adapters.dto.request.DadosAtualizarMedico;
import com.medico.api.adapters.dto.request.DadosCadastroMedico;
import com.medico.api.adapters.dto.response.DadosResponseMedico;
import com.medico.api.adapters.interfaces.gateway.MedicoGateway;
import com.medico.api.adapters.interfaces.usecases.MedicoUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    final MedicoGateway medicoGateway;
    final MedicoUseCase medicoUseCase;

    public MedicoController(MedicoGateway medicoGateway, MedicoUseCase medicoUseCase) {
        this.medicoGateway = medicoGateway;
        this.medicoUseCase = medicoUseCase;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico, UriComponentsBuilder uriComponentsBuilder){
        var medico = MedicoBuilder.fromRequestToDomain(dadosCadastroMedico);
        medicoUseCase.create(medico, medicoGateway);

        var uri = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(MedicoBuilder.fromDomainToDetail(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosResponseMedico>> findAll(@PageableDefault(sort = {"nome"}) Pageable page){
        var medico = medicoUseCase.findAll(medicoGateway, page);

        var retorno = medico.map(MedicoBuilder::fromDomainToResponse);

        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = medicoUseCase.getReferenceById(dados.id(), medicoGateway);

        medicoUseCase.atualizar(medico, dados);

        return ResponseEntity.ok(MedicoBuilder.fromDomainToDetail(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        medicoUseCase.delete(id, medicoGateway);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var medico = medicoUseCase.getReferenceById(id, medicoGateway);

        return ResponseEntity.ok(MedicoBuilder.fromDomainToDetail(medico));
    }
}
