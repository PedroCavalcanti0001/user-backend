package me.pedroeugenio.userbackend.entity;

public class CommonCustomerFactory implements CustomerFactory {
    @Override
    public Customer create(Long id, String name, int age, String cep, String street, String district, String city, int number) {
        return new CommonCustomer(id, name, age, cep, street, district, city, number);
    }
}
