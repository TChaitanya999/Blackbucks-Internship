package com.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;
import com.business.loginCredentials.AdminLogin;

@SuppressWarnings("unused")
public interface AdminRepository extends CrudRepository<Admin, Integer>
{
public Admin findByadminEmail(String email);
}
