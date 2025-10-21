package com.senac.juanM27.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "atendente")
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atendente_id")
    private Integer id;

    @Column(name = "atendente_nome")
    private String nome;

    @Column(name = "atendente_usuario_login")
    private String usuarioLogin;

    @Column(name = "atendente_chave_acesso")
    private String chaveAcesso;

    @Column(name = "atendente_data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "atendente_ativo")
    private Integer ativo;

    @OneToMany(mappedBy = "atendente")
    private List<com.senac.juanM27.entity.ChamadaAtendente> chamadasAtendente;

    @ManyToMany
    @JoinTable(name = "atendente_role",
            joinColumns = @JoinColumn(name = "atendente_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public List<ChamadaAtendente> getChamadasAtendente() {
        return chamadasAtendente;
    }

    public void setChamadasAtendente(List<ChamadaAtendente> chamadasAtendente) {
        this.chamadasAtendente = chamadasAtendente;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}