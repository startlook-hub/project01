package ru.mtuci.project01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Device extends AbstractBaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String department;
    @NotNull
    private String brand;
    @NotNull
    private String address;

}