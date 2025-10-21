package com.senac.juanM27.service;


import com.senac.juanM27.config.SecurityConfiguration;
import com.senac.juanM27.dto.CreateUserDto;
import com.senac.juanM27.entity.Atendente;
import com.senac.juanM27.entity.Role;
import com.senac.juanM27.repository.AtendenteRepository;
import com.senac.juanM27.repository.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtentendeService {
    private final AtendenteRepository atendenteRepository;
    private  final  RoleRepository roleRepository;
    private final SecurityConfiguration securityConfiguration;

    public AtentendeService(AtendenteRepository atendenteRepository, RoleRepository roleRepository, SecurityConfiguration securityConfiguration) {
        this.atendenteRepository = atendenteRepository;
        this.roleRepository = roleRepository;
        this.securityConfiguration = securityConfiguration;
    }

    public List<Atendente>listarTodos(){
        return atendenteRepository.findAll();
    }

    public Atendente listarPorId(Integer id){
        return atendenteRepository.findById(id).orElse(null);
    }

    public void criarAtendente(CreateUserDto createUserDto) {
        Role role = roleRepository.findByName(createUserDto.role().name());

        Atendente novoAtendente = new Atendente();

        novoAtendente.setNome(createUserDto.nome());
        novoAtendente.setUsuarioLogin(createUserDto.usuarioLogin());
        novoAtendente.setChaveAcesso(securityConfiguration.passwordEncoder().encode(createUserDto.chaveAcesso()));
        novoAtendente.setDataCriacao(LocalDateTime.now());
        novoAtendente.setAtivo(1);
        novoAtendente.setRoles(List.of(role));
        atendenteRepository.save(novoAtendente);
    }

}

