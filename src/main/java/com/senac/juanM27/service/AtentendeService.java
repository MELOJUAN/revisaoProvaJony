package com.senac.juanM27.service;


import com.senac.juanM27.dto.CreateUserDto;
import com.senac.juanM27.entity.Atendente;
import com.senac.juanM27.entity.Role;
import com.senac.juanM27.repository.AtendenteRepository;
import com.senac.juanM27.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtentendeService {
    private final AtendenteRepository atendenteRepository;
    private  final  RoleRepository roleRepository;

    public AtentendeService(AtendenteRepository atendenteRepository, RoleRepository roleRepository) {
        this.atendenteRepository = atendenteRepository;
        this.roleRepository = roleRepository;
    }

    public List<Atendente>listarTodos(){
        return atendenteRepository.findAll();
    }

    public Atendente listarPorId(Integer id){
        return atendenteRepository.findById(id).orElse(null);
    }

    public void criarAtendente(CreateUserDto createUserDto) {
        Role role = roleRepository.findByName(createUserDto.role().name());
    }

}

