package com.example.ProjectSashko.AppControlers;

import com.example.ProjectSashko.Entity.Admins;
import com.example.ProjectSashko.Entity.Customers;
import com.example.ProjectSashko.Entity.Employees;
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
public class AppControllerUpdate {
    @Autowired
    private AdminsRepository adminsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    ProtocolRepository protocolRepository;
    @GetMapping("/update")
    public String updatePage(){
        return "/Admin/update";
    }
    @GetMapping("/customer")
    public String customer(Model model){
        List<Customers> listCustomer = customersRepository.findAll();
        model.addAttribute("listCustomer", listCustomer);
        return "/Admin/Update/customer";
    }
    @GetMapping("/customer_update/{id}")
    public String updateCustomer(@PathVariable long id, Model model){
        Customers customer = customersRepository.getById(id);
        model.addAttribute("customer", customer);
        return "/Admin/Update/customer_update";
    }
    @PostMapping("/customer_update/{id}")
    public String update(@PathVariable long id, Customers customers){
        customers.setId(id);
        customersRepository.save(customers);
        return "/Admin/Update/customer";
    }
    @PostMapping("/customer_delete/{id}")
    public String customerDelete(@PathVariable long id) {
        Customers customers = customersRepository.getById(id);
        customersRepository.delete(customers);
        return "/Admin/Update/customer";
    }
    @GetMapping("/admins")
    public String adminUpdate(Model model){
        List<Admins> listAdmin = adminsRepository.findAll();
        model.addAttribute("listAdmins", listAdmin);
        return "/Admin/Update/admins";
    }
    @PostMapping("/admin_delete/{id}")
    public String adminDelete(@PathVariable long id) {
        Admins admins = adminsRepository.getById(id);
        adminsRepository.delete(admins);
        return "/Admin/Update/admins";
    }
    @GetMapping("/employees")
    public String employeesUpdate(Model model){
        List<Employees> listEmployees = employeesRepository.findAll();
        model.addAttribute("listEmployees", listEmployees);
        return "/Admin/Update/employees";
    }
    @PostMapping("/employees_delete/{id}")
    public String employeesDelete(@PathVariable long id) {
        Employees employees = employeesRepository.getById(id);
        employeesRepository.delete(employees);
        return "/Admin/Update/employees";
    }
}
