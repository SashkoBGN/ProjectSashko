package com.example.ProjectSashko.CustomDetailsService;

import com.example.ProjectSashko.CustomDetails.CustomEmployeeDetails;
import com.example.ProjectSashko.Entity.Employees;
import com.example.ProjectSashko.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeesRepository empRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employees employees = empRep.findByEmail(username);
        if (employees == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomEmployeeDetails(employees);
    }
}
