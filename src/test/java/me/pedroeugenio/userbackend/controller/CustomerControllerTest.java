package me.pedroeugenio.userbackend.controller;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import me.pedroeugenio.userbackend.entity.CommonCustomer;
import me.pedroeugenio.userbackend.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@SpringBootTest
public class CustomerControllerTest {


    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService service;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.customerController);
    }

    @Test
    public void deveRetornarSuccess_QuandoBuscarCliente() {
        CommonCustomer customer = new CommonCustomer(1L, "", 23, "56322740", "rua", "bairro", "petrolina", 25);
        Mockito.when(this.service.get(1L)).thenReturn(Optional.of(customer));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .get("/api/buscacliente/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarNotFound_QuandoBuscarCliente() {
        Mockito
                .when(this.service.get(1L))
                .thenReturn(Optional.empty());
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .get("/api/buscacliente/{id}", 100L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void deveRetornarBadRequest_QuandoSalvarCliente() {
        CommonCustomer customer = new CommonCustomer(100L, "", 23, "56322740", "rua", "bairro", "petrolina", 25);
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(customer))
                .post("/api/salvarcliente")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void deveRetornarSuccess_QuandoSalvarCliente() {
        CommonCustomer commonCustomer = new CommonCustomer(100L, "Pedro", 23, "56322740", "rua", "bairro", "petrolina", 25);
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(commonCustomer))
                .post("/api/salvarcliente")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

}
