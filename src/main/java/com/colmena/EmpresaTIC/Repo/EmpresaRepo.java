package com.colmena.EmpresaTIC.Repo;

import com.colmena.EmpresaTIC.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepo extends JpaRepository<Empresa, Long> {
}
