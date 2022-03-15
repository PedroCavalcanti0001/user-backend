package me.pedroeugenio.userbackend.repository;

import me.pedroeugenio.userbackend.entity.CommonCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CommonCustomer, Long> {
}
