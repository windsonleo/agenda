package com.tecsoluction.agenda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsoluction.agenda.entidade.Role;

import java.util.UUID;

@Repository
public interface IRoleDAO extends JpaRepository<Role, UUID> {
}
