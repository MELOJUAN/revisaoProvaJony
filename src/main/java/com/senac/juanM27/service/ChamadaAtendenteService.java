package com.senac.juanM27.service;


import com.senac.juanM27.repository.ChamadaAtendenteRepository;
import org.springframework.stereotype.Service;

@Service
public class ChamadaAtendenteService {
    private final ChamadaAtendenteRepository chamadaAtendenteRepository;

    public ChamadaAtendenteService(ChamadaAtendenteRepository chamadaAtendenteRepository) {
        this.chamadaAtendenteRepository = chamadaAtendenteRepository;
    }
}
