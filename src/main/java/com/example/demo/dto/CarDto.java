package com.example.demo.dto;

public class CarDto {
    private Integer id;
    private String marca;
    private String modelo;
    private int ano;
    private Integer revendedorId;
    private String revendedorNome;
    private String revendedorTelefone;

    public CarDto() {
    }

    public CarDto(Integer id, String marca, String modelo, int ano, Integer revendedorId, String revendedorNome, String revendedorTelefone) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.revendedorId = revendedorId;
        this.revendedorNome = revendedorNome;
        this.revendedorTelefone = revendedorTelefone;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public Integer getRevendedorId() { return revendedorId; }
    public void setRevendedorId(Integer revendedorId) { this.revendedorId = revendedorId; }

    public String getRevendedorNome() { return revendedorNome; }
    public void setRevendedorNome(String revendedorNome) { this.revendedorNome = revendedorNome; }

    public String getRevendedorTelefone() { // Getter para o telefone
        return revendedorTelefone;
    }

    public void setRevendedorTelefone(String revendedorTelefone) { // Setter para o telefone
        this.revendedorTelefone = revendedorTelefone;
    }
}