package com.example.ProjectSashko.Repository;

import com.example.ProjectSashko.Entity.Employees;
import com.example.ProjectSashko.Entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    @Query("SELECT u FROM Privilege u WHERE u.name = ?1")
    public Privilege findByName(String name);
}
