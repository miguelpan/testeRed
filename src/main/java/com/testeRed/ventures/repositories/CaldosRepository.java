package com.testeRed.ventures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testeRed.ventures.models.CaldosModel;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CaldosRepository extends JpaRepository <CaldosModel, UUID> {


}
