package com.senac.juanM27.repository;

import com.senac.juanM27.entity.Atendente;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {


    Optional<Atendente> findByUsuarioLogin(String subject);
}
