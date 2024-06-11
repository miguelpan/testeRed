package com.testeRed.ventures.controllers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.testeRed.ventures.dtos.ProteinasRecordDto;
import com.testeRed.ventures.models.CaldosModel;
import com.testeRed.ventures.models.ProteinasModel;
import com.testeRed.ventures.repositories.ProteinasRepository;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProteinasController {
    @Autowired
    ProteinasRepository proteinasRepository;

//  EndPoint com metodo de busca de todos as Proteinas por meio de lista e model
//  Sem utilização de banco de dados
    @GetMapping("/proteins")
    public ResponseEntity<List<ProteinasModel>> getAllProteinas(){
        List<ProteinasModel> proteinas = new ArrayList<>();
        proteinas.add(new ProteinasModel(UUID.fromString("dce98167-bcf8-460d-ad5c-0e1ec9c3fb0b"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Carne bovina","Simple like the seawater, nothing more", 32.90));
        proteinas.add(new ProteinasModel(UUID.fromString("566f75f2-0db4-4703-b522-a5a02d4690e6"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Frango","Simple like the seawater, nothing more", 35));
        proteinas.add(new ProteinasModel(UUID.fromString("57ece417-1b17-4226-94bc-8e4d93369769"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Carne de porco","Simple like the seawater, nothing more", 35.56));
        proteinas.add(new ProteinasModel(UUID.fromString("bce4dd0a-cb71-4f66-9dc1-a0ec4ae41533"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Peixe","Simple like the seawater, nothing more", 42.30));
        return ResponseEntity.status(HttpStatus.OK).body(proteinas);
    }

//  EndPoint com metodo de busca de Proteinas por meio de id
//  Sem utilização de banco de dados
    @GetMapping("/proteins/{id}")
    public ResponseEntity<Object> getOneProteinas(@PathVariable(value = "id")UUID id){
        Optional<ProteinasModel> proteina0 = proteinasRepository.findById(id);
        if (proteina0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma Proteina encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(proteina0.get());
    }

//  EndPoint com metodo de atualização de Proteinas por meio de id (Banco de dados)
    @PutMapping("/proteins/{id}")
    public ResponseEntity<Object> updateProteinas(@PathVariable(value = "id")UUID id, @RequestBody @Valid ProteinasRecordDto proteinasRecordDto) {
        Optional<ProteinasModel> proteina0 = proteinasRepository.findById(id);
        if (proteina0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma Proteina encontrada");
        }
        var proteinaModel = proteina0.get();
        BeanUtils.copyProperties(proteinasRecordDto, proteinaModel);

        return ResponseEntity.status(HttpStatus.OK).body(proteinasRepository.save(proteinaModel));
    }
//  EndPoint com metodo de Delete de Proteinas por meio de id (Banco de dados)
    @DeleteMapping("/proteins/{id}")
    public ResponseEntity<Object> deleteProteinas(@PathVariable(value = "id")UUID id, @RequestBody @Valid ProteinasRecordDto proteinasRecordDto) {
        Optional<ProteinasModel> proteina0 = proteinasRepository.findById(id);
        if (proteina0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma Proteina encontrada");
        }
        proteinasRepository.delete(proteina0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Proteina apgada com sucesso!");
    }


//    EndPoint com metodo para salvar novos itens no banco de dados
//    @PostMapping("/proteina")
//    public ResponseEntity<ProteinasModel> savaCaldo(@RequestBody @Valid ProteinasRecordDto proteinasRecordDto) {
//        var proteinaModel = new ProteinasModel(UUID);
//        BeanUtils.copyProperties(proteinasRecordDto, proteinaModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(proteinasRepository.save(proteinaModel));
//    }


//    EndPoint com metodo de busca de todos as proteins com banco de dados
//    @GetMapping("/proteins")
//    public ResponseEntity<List<ProteinasModel>> getAllProteinas(){
//        return ResponseEntity.status(HttpStatus.OK).body(proteinasRepository.findAll());
//    }


}
