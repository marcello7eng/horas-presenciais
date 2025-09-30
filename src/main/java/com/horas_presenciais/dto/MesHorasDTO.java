package com.horas_presenciais.dto;

public class MesHorasDTO {
    private Long id;
    private String mes;
    private double horasTotais;
    private double horasCumpridas;

    public MesHorasDTO() {}

    public MesHorasDTO(Long id, String mes, double horasTotais, double horasCumpridas) {
        this.id = id;
        this.mes = mes;
        this.horasTotais = horasTotais;
        this.horasCumpridas = horasCumpridas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public double getHorasTotais() { return horasTotais; }
    public void setHorasTotais(double horasTotais) { this.horasTotais = horasTotais; }

    public double getHorasCumpridas() { return horasCumpridas; }
    public void setHorasCumpridas(double horasCumpridas) { this.horasCumpridas = horasCumpridas; }
}