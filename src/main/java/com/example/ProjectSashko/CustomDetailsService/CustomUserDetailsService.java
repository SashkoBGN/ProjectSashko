package com.example.ProjectSashko.CustomDetailsService;

import com.example.ProjectSashko.CustomDetails.CustomAdminDetails;
import com.example.ProjectSashko.Entity.Admins;
import com.example.ProjectSashko.Repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminsRepository adminRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins admin = adminRep.findByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomAdminDetails(admin);
    }
}
