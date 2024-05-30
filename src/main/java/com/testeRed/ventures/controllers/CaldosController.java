package com.testeRed.ventures.controllers;

import com.testeRed.ventures.dtos.CaldosRecordDto;
import com.testeRed.ventures.models.CaldosModel;
import com.testeRed.ventures.repositories.CaldosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CaldosController {

    @Autowired
    CaldosRepository caldosRepository;

    @PostMapping("/caldos")
    public ResponseEntity<CaldosModel> savaCaldo(@RequestBody @Valid CaldosRecordDto caldosRecordDto) {
        var caldosModel = new CaldosModel();
        BeanUtils.copyProperties(caldosRecordDto, caldosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(caldosRepository.save(caldosModel));
    }

    @GetMapping("/broths")
    public ResponseEntity<List<CaldosModel>> getAllCaldos(){
        return ResponseEntity.status(HttpStatus.OK).body(caldosRepository.findAll());
    }

    @GetMapping("/broths/{id}")
    public ResponseEntity<Object> getOneCaldos(@PathVariable(value = "id")UUID id){
        Optional<CaldosModel> caldo0 = caldosRepository.findById(id);
        if (caldo0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nada encontrado");
        }
//        System.out.println("abre "+caldo0.get());
        return ResponseEntity.status(HttpStatus.OK).body(caldo0.get());
    }


}
