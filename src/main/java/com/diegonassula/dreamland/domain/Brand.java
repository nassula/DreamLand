package com.diegonassula.dreamland.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Setter
    @Getter
    @NotBlank(message = "O Nome da marca não pode estar vazio")
    @Size(min = 1, max = 255, message = "O Nome da marca deve ter entre 1 e 255 caracteres")
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand brand)) return false;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
