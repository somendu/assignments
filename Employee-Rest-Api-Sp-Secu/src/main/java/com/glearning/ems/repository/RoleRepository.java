package com.glearning.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.ems.model.Role;

/**
 * 
 * Role Repository
 * 
 * @author Aditi Awasthi
 *
 * @since 05-Aug-2023
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
