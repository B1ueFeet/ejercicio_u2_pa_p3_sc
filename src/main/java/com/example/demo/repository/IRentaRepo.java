package com.example.demo.repository;

import com.example.demo.modelo.Renta;

public interface IRentaRepo {

	public void insertar(Renta renta);
	public void eliminar(Integer id);
	public Renta buscar(Integer id);
}
