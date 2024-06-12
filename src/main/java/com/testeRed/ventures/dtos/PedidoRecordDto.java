package com.testeRed.ventures.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRecordDto(@NotBlank int brothId, @NotNull int proteinId) {
}
