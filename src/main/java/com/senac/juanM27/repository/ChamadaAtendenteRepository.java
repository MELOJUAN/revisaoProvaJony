package com.senac.juanM27.repository;

import com.senac.juanM27.entity.ChamadaAtendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadaAtendenteRepository extends JpaRepository<ChamadaAtendente, Integer> {
    List<ChamadaAtendente> findByAtendenteId(int atendenteId);
}
