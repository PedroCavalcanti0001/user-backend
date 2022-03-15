package me.pedroeugenio.userbackend.controller;


import me.pedroeugenio.userbackend.entity.CommonCustomer;
import me.pedroeugenio.userbackend.entity.Customer;
import me.pedroeugenio.userbackend.exceptions.ErrorMessage;
import me.pedroeugenio.userbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/buscarclientes")
    public ResponseEntity<List<CommonCustomer>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/salvarcliente")
    public ResponseEntity<Object> saveClient(@RequestBody CommonCustomer customer) {
        if (customer.isOk()) {
            if (!service.existsById(customer.getId())) {
                return ResponseEntity.ok(service.save(customer));
            } else {
                ErrorMessage em = new ErrorMessage(1, "Esse cliente já existe em nossa base de dados!");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(em);
            }
        } else {
            ErrorMessage em = new ErrorMessage(2, "O Nome do cliente não pode estar em branco!");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(em);
        }
    }

    @DeleteMapping("/deletarcliente/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok().build();
        } else {
            ErrorMessage em = new ErrorMessage(3, "Nenhum cliente foi encontrado para esse ID!");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(em);
        }
    }

    @GetMapping("/buscacliente/{id}")
    public ResponseEntity<Object> getClient(@PathVariable Long id) {
        Optional<CommonCustomer> customer = service.get(id);
        if (customer.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(customer.get());
        } else {
            ErrorMessage em = new ErrorMessage(3, "Nenhum cliente foi encontrado para esse ID!");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(em);
        }
    }

}
