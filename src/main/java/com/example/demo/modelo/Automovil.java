package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil {
	
	@Id
	@Column(name = "auto_placa")
	private String placa;
	@Column(name = "auto_valor_dias")
	private BigDecimal valorDias;
	
	//RELACION
	
	@OneToMany(mappedBy = "automovil")
	private List<Renta> renta;
	
	//TO STRING
	@Override
	public String toString() {
		return "Automovil [placa=" + placa + ", valorDias=" + valorDias + "]";
	}
	
	//GETTER & SETTER

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValorDias() {
		return valorDias;
	}

	public void setValorDias(BigDecimal valorDias) {
		this.valorDias = valorDias;
	}

	public List<Renta> getRenta() {
		return renta;
	}

	public void setRenta(List<Renta> renta) {
		this.renta = renta;
	}
	
	
	
	
	
	
	

}
