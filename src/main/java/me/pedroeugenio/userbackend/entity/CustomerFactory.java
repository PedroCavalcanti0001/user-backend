package me.pedroeugenio.userbackend.entity;

interface CustomerFactory {
    Customer create(Long id, String name, int age, String cep, String street, String district, String city, int number);
}
