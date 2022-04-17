package com.example.ProjectSashko.AppControlers;

import com.example.ProjectSashko.Entity.Admins;
import com.example.ProjectSashko.Entity.Customers;
import com.example.ProjectSashko.Entity.Employees;
import com.example.ProjectSashko.Entity.Protocol;
import com.example.ProjectSashko.Repository.AdminsRepository;
import com.example.ProjectSashko.Repository.CustomersRepository;
import com.example.ProjectSashko.Repository.EmployeesRepository;
import com.example.ProjectSashko.Repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
