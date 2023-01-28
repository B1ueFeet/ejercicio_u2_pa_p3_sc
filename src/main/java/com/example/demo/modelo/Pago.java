package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "pago")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_seq")
	@SequenceGenerator(name = "pago_seq", sequenceName = "pago_seq", allocationSize = 1)
	@Column(name = "pago_id")
	private Integer id;
	@Column(name = "pago_numero_tarjeta")
	private String numTarjeta;
	@Column(name = "pago_valor")
	private BigDecimal valor;
	
	//RELACION
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "pago_id_renta")
	private Renta renta;
	
	
	@Override
	public String toString() {
		return "Pago [id=" + id + ", numTarjeta=" + numTarjeta + ", valor=" + valor + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Renta getRenta() {
		return renta;
	}
	public void setRenta(Renta renta) {
		this.renta = renta;
	}
	
	
	
	

}
