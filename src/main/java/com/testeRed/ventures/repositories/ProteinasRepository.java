package com.testeRed.ventures.repositories;

import com.testeRed.ventures.models.ProteinasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProteinasRepository extends JpaRepository<ProteinasModel , UUID> {
}
