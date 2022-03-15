package me.pedroeugenio.userbackend.services;

import me.pedroeugenio.userbackend.entity.CommonCustomer;
import me.pedroeugenio.userbackend.entity.Customer;
import me.pedroeugenio.userbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonCustomerService implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<CommonCustomer> findAll() {

        return repository.findAll();
    }

    @Override
    public CommonCustomer save(CommonCustomer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CommonCustomer> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
