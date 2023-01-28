package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Pago;
import com.example.demo.modelo.Renta;
import com.example.demo.repository.IAutomovilRepo;
import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.IRentaRepo;

@Service
public class RentaServiceImpl implements IRentaService{
	@Autowired
	private IClienteRepo clienteRepo;
	@Autowired
	private IAutomovilRepo automovilRepo;
	
	@Autowired
	private IRentaRepo rentaRepo;
	
	@Override
	public void realizar(String placa, String Cedula, Integer numDias, String numTarjeta) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepo.buscar(Cedula);
		Automovil automovil = this.automovilRepo.buscar(placa);
		Pago pago = new Pago();

		Renta renta = new Renta();
		renta.setAutomovil(automovil);
		renta.setCliente(cliente);
		renta.setFecha(LocalDateTime.now());
		renta.setNumDias(numDias);
		
		BigDecimal valorRenta = automovil.getValorDias().multiply(new BigDecimal(numDias));
		BigDecimal valorPago = valorRenta.add(valorRenta.multiply(new BigDecimal(0.5))); 
				
		pago.setNumTarjeta(numTarjeta);
		pago.setValor(valorPago);
		pago.setRenta(renta);
		
		renta.setPago(pago);
		renta.setValor(valorRenta);
		
		this.rentaRepo.insertar(renta);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.rentaRepo.eliminar(id);
	}

}
