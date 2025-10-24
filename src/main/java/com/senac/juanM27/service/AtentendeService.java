package com.senac.juanM27.service;


import com.senac.juanM27.config.SecurityConfiguration;
import com.senac.juanM27.dto.CreateUserDto;
import com.senac.juanM27.dto.LoginUserDto;
import com.senac.juanM27.dto.RecoveryJwtTokenDto;
import com.senac.juanM27.entity.Atendente;
import com.senac.juanM27.entity.Role;
import com.senac.juanM27.repository.AtendenteRepository;
import com.senac.juanM27.repository.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtentendeService {
    private final AtendenteRepository atendenteRepository;
    private  final  RoleRepository roleRepository;
    private final SecurityConfiguration securityConfiguration;
    private  final AuthenticationManager authenticationManager;
    private final  JwtTokenService jwtTokenService;

    public AtentendeService(AtendenteRepository atendenteRepository, RoleRepository roleRepository, SecurityConfiguration securityConfiguration, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.atendenteRepository = atendenteRepository;
        this.roleRepository = roleRepository;
        this.securityConfiguration = securityConfiguration;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public List<Atendente>listarTodos(){
        return atendenteRepository.findAll();
    }

    public Atendente listarPorId(Integer id){
        return atendenteRepository.findById(id).orElse(null);
    }

    public void criarAtendente(CreateUserDto createUserDto) {
        Role role = roleRepository.findByName(createUserDto.role());

        Atendente novoAtendente = new Atendente();

        novoAtendente.setNome(createUserDto.nome());
        novoAtendente.setUsuarioLogin(createUserDto.usuarioLogin());
        novoAtendente.setChaveAcesso(securityConfiguration.passwordEncoder().encode(createUserDto.chaveAcesso()));
        novoAtendente.setDataCriacao(LocalDateTime.now());
        novoAtendente.setAtivo(1);
        novoAtendente.setRoles(List.of(role));
        atendenteRepository.save(novoAtendente);
    }

    public RecoveryJwtTokenDto login(LoginUserDto loginUserDTO) {

        //passo1

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUserDTO.login(),loginUserDTO.chaveAcesso());

        //passo2

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //passo3

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        //passo4

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));


    }
}

