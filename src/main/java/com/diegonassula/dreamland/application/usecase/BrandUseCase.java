package com.diegonassula.dreamland.application.usecase;

import com.diegonassula.dreamland.domain.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BrandUseCase {

    Set<Brand> listOfBrands = new HashSet<>();

    public ResponseEntity<?> post(Brand brand) {
        if (listOfBrands.contains(brand)){
            return new ResponseEntity<>("Marca já registrada no Sistema", HttpStatus.PRECONDITION_FAILED);
        }
        listOfBrands.add(brand);
        return new ResponseEntity<>(brand, HttpStatus.CREATED);
    }

    public ResponseEntity<?> delete(Brand brand) {
        if (!listOfBrands.contains(brand)){
            return new ResponseEntity<>("Marca não encontrada no Sistema", HttpStatus.PRECONDITION_FAILED);
        }
        listOfBrands.remove(brand);
        return new ResponseEntity<>("Marca removida com sucesso", HttpStatus.OK);
    }

    public ResponseEntity<?> getAll() {
        if (listOfBrands.size() < 1){
            return new ResponseEntity<>("Não existem Marcas a serem exibidas", HttpStatus.OK);
        }
        return new ResponseEntity<>(listOfBrands, HttpStatus.OK);
    }
}
