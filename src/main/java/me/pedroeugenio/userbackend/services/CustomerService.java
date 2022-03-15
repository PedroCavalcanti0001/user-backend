package me.pedroeugenio.userbackend.services;

import me.pedroeugenio.userbackend.entity.CommonCustomer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CommonCustomer> findAll();

    CommonCustomer save(CommonCustomer customer);

    void delete(Long id);

    Optional<CommonCustomer> get(Long id);

    boolean existsById(Long id);
}
