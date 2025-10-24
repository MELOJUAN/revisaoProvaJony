package com.senac.juanM27.dto;

import com.senac.juanM27.entity.Role;

import java.util.List;

public record LoginUserDto(
        String login,
        String chaveAcesso
) {
}