package com.senac.juanM27.dto;


import com.senac.juanM27.entity.RoleName;

import java.time.LocalDateTime;

public record CreateUserDto(

        String nome,
        String usuarioLogin,
        String chaveAcesso,
        LocalDateTime dataCriacao,
        RoleName role

) {
}
