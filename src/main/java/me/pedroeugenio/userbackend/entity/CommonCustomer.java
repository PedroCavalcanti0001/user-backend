package me.pedroeugenio.userbackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "clientes")
public class CommonCustomer implements Customer {
    private @Id
    Long id;
    private String name;
    private int age;
    private String cep;
    private String street;
    private String district;
    private String city;
    private int number;

    public CommonCustomer() {
    }

    public CommonCustomer(Long id, String name, int age, String cep, String street, String district, String city, int number) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.number = number;
    }

    @Override
    public boolean isOk() {
        return !name.isEmpty();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getDistrict() {
        return district;
    }

    @Override
    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
