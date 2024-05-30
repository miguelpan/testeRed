package com.testeRed.ventures.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CaldosRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
