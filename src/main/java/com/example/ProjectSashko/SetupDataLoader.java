package com.example.ProjectSashko;

import com.example.ProjectSashko.Entity.Admins;
import com.example.ProjectSashko.Entity.Privilege;
import com.example.ProjectSashko.Entity.Role;
import com.example.ProjectSashko.Repository.AdminsRepository;
import com.example.ProjectSashko.Repository.PrivilegeRepository;
import com.example.ProjectSashko.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = true;

    @Autowired
    private AdminsRepository adminRep;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) {
            return;
        }

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        Role admin = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_EMPLOYEE", Arrays.asList(writePrivilege));

        Admins Aleksandar = new Admins();
        Aleksandar.setFirstName("Aleksandar");
        Aleksandar.setLastName("Mingolov");
        Aleksandar.setPassword(passwordEncoder.encode("123321"));
        Aleksandar.setEmail("SashkoBossa@gmail.com");
        Aleksandar.setAdmin_roles(Arrays.asList(admin));
        adminRep.save(Aleksandar);
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            role.setAdminPrivileges(privileges);
            role.setEmployeePrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound (String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
}
