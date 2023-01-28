package com.example.demo.service;

public interface IRentaService {
	
	public void realizar(String placa, String Cedula, Integer numDias, String numTarjeta);
	public void eliminar (Integer id);

}
