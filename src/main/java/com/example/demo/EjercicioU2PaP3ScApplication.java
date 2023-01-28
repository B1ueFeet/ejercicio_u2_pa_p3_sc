package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.Cliente;
import com.example.demo.service.IAutomovilService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IRentaService;

@SpringBootApplication
public class EjercicioU2PaP3ScApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU2PaP3ScApplication.class, args);
	}

	@Autowired
	private IRentaService rentaService;
	
	@Autowired
	private IAutomovilService automovilService;
	
	@Autowired 
	private IClienteService clienteService;
	
	@Override
	public void run(String... args) throws Exception {

		//PARTE 1
		Automovil automovil1 = new Automovil();
		automovil1.setPlaca("123");
		automovil1.setValorDias(new BigDecimal(30));
		
		Automovil automovil2 = new Automovil();
		automovil2.setPlaca("456");
		automovil2.setValorDias(new BigDecimal(30));
		
		this.automovilService.guardar(automovil1);
		this.automovilService.guardar(automovil2);
		
		
		Cliente cliente1 = new Cliente();
		cliente1.setCedula("12345");
		cliente1.setNombre("Maria Bonita");
		
		
		Cliente cliente2 = new Cliente();
		cliente2.setCedula("67890");
		cliente2.setNombre("Josue Castillo");
		
		this.clienteService.guardar(cliente1);
		this.clienteService.guardar(cliente2);
		
		//PARTE 2
		
		this.rentaService.realizar("123", "12345", 2 , "1234567890");
		//PARTE 3
		
		System.out.println("Automovil:\n" + this.automovilService.buscar("456"));
		System.out.println("Cliente:\n" + this.clienteService.buscar("67890"));
		
		//PARTE 4
		
		this.rentaService.eliminar(1);
		
		
		
		
		
	}

}
