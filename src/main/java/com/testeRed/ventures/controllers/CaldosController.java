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
import java.util.ArrayList;


@RestController
public class CaldosController {

    @Autowired
    CaldosRepository caldosRepository;

//    @PostMapping("/caldos")
//    public ResponseEntity<CaldosModel> savaCaldo(@RequestBody @Valid CaldosRecordDto caldosRecordDto) {
//        var caldosModel = new CaldosModel(UUID);
//        BeanUtils.copyProperties(caldosRecordDto, caldosModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(caldosRepository.save(caldosModel));
//    }

//  Passando dados de caldos por meio de lista e model, sem utilização de banco de dados
    @GetMapping("/broths")
    public ResponseEntity<List<CaldosModel>> getAllCaldos(){
        List<CaldosModel> caldos = new ArrayList<>();
       
        caldos.add(new CaldosModel(UUID.fromString("f128cbd8-d2f5-40d1-9e71-4da31ede020f"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Miso","Simple like the seawater, nothing more", 25.90));
        caldos.add(new CaldosModel(UUID.fromString("69e7c4f7-74d9-442e-bc3a-25f6b2c7a9c8"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Tonkotsu","Simple like the seawater, nothing more", 32));
        caldos.add(new CaldosModel(UUID.fromString("a3d3e60f-5f14-4773-9f85-ace5c5a29b9e"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Kare","Simple like the seawater, nothing more", 34.49));
        caldos.add(new CaldosModel(UUID.fromString("d9b38c6f-5a2d-4fa8-b89c-1e1bafe1e4a7"), "https://tech.redventures.com.br/icons/salt/inactive.svg","https://tech.redventures.com.br/icons/salt/active.svg","Tantanmen","Simple like the seawater, nothing more", 10.30));
        return ResponseEntity.status(HttpStatus.OK).body(caldos);
    }


//    Passando valores com banco de dados
//    Metodo desativado pois não conseguir alocar o mesmo para testes online, mas mostro via call no servidor local
//    @GetMapping("/broths")
//    public ResponseEntity<List<CaldosModel>> getAllCaldos(){
//        return ResponseEntity.status(HttpStatus.OK).body(caldosRepository.findAll());
//    }

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
