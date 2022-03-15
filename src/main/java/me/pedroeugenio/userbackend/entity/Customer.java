package me.pedroeugenio.userbackend.entity;

public interface Customer {
    boolean isOk();
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    String getCep();
    void setCep(String cep);
    String getStreet();
    void setStreet(String street);
    String getDistrict();
    void setDistrict(String district);
    String getCity();
    void setCity(String city);
    int getNumber();
    void setNumber(int number);
    Long getId();
    void setId(Long id);
}
