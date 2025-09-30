package com.horas_presenciais.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;

import com.horas_presenciais.util.HorasUtil;

@Entity
public class MesHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mes; // armazena "yyyy-MM" no banco
    
    @DecimalMax(value = "999.9", inclusive = true, message = "O valor máximo permitido é 999,9 horas")
    private double horasTotais;
    @DecimalMax(value = "999.9", inclusive = true, message = "O valor máximo permitido é 999,9 horas")
    private double horasCumpridas;
    
    @Transient
    private String mesFormatado; // apenas para exibir na view

    public MesHoras() {}

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public double getHorasTotais() { return horasTotais; }
    public void setHorasTotais(double horasTotais) { this.horasTotais = horasTotais; }

    public double getHorasCumpridas() { return horasCumpridas; }
    public void setHorasCumpridas(double horasCumpridas) { this.horasCumpridas = horasCumpridas; }
    
    @Transient
    public String getMesFormatado() { return mesFormatado; }
    public void setMesFormatado(String mesFormatado) { this.mesFormatado = mesFormatado; }

    @Transient
    public String getDiasRestantesFormatado() {
        return HorasUtil.formatarDiasRestantes(horasTotais, horasCumpridas);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MesHoras other = (MesHoras) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}