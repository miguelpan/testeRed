package com.testeRed.ventures.controllers;

import com.testeRed.ventures.dtos.PedidoRecordDto;
import com.testeRed.ventures.models.CaldosModel;
import com.testeRed.ventures.models.PedidoModel;
import com.testeRed.ventures.repositories.PedidosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PedidoController {
    @Autowired
    PedidosRepository pedidosRepository;


//    EndPoint com metodo para salvar novos pedidos no banco de dados
//    @PostMapping("/orders")
//    public ResponseEntity<PedidoModel> savaPedido(@RequestBody @Valid PedidoRecordDto pedidoRecordDto) {
//        var pedidoModel = new PedidoModel(UUID);
//        BeanUtils.copyProperties(pedidoRecordDto, pedidoModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosRepository.save(pedidoModel));
//    }
}
