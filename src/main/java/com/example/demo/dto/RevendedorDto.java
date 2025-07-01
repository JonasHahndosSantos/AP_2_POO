package com.example.demo.dto;

import java.util.List;

public class RevendedorDto {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private List<CarInfoDto> carros;

    public RevendedorDto() {
    }

    public RevendedorDto(Integer id, String nome, String email, String telefone, List<CarInfoDto> carros) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.carros = carros;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<CarInfoDto> getCarros() { return carros; }
    public void setCarros(List<CarInfoDto> carros) { this.carros = carros; }
}