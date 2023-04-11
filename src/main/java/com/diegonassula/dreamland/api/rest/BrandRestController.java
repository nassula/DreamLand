package com.diegonassula.dreamland.api.rest;

import com.diegonassula.dreamland.application.usecase.BrandUseCase;
import com.diegonassula.dreamland.domain.Brand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brand")
@CrossOrigin
public class BrandRestController {

    @Autowired
    BrandUseCase brandUseCase;

    @PostMapping()
    public ResponseEntity<?> post(@Valid @RequestBody Brand brand, Errors errors ) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return brandUseCase.post(brand);
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@Valid @RequestBody Brand brand, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }
        return brandUseCase.delete(brand);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return brandUseCase.getAll();
    }
}
