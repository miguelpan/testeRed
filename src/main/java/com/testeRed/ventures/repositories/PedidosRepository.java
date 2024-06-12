package com.testeRed.ventures.repositories;

import com.testeRed.ventures.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidosRepository extends JpaRepository<PedidoModel, UUID> {
}

