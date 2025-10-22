package com.novahabitat.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {
    private Integer idMaterial;

    @NotNull
    @Size(min=3, max = 70)
    private String name;

    @NotNull
    @Size(max = 20, message = "La unidad de medida no puede exceder 20 caracteres")
    private String measurementUnit; // unidad de medida


    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser >= 0")
    @Digits(integer = 10, fraction = 2, message = "Precio con máximo 2 decimales")
    private Double unitPrice;


    @NotNull
    @PositiveOrZero(message = "El stock no puede ser negativo")
    private Integer actualStock;


    @NotNull
    @Valid // valida los campos dentro de SupplierDTO
    private SupplierDTO supplier;
}

