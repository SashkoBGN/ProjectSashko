package com.example.ProjectSashko.Repository;

import com.example.ProjectSashko.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

}