package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AutomovilRepoImpl implements IAutomovilRepo{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.manager.persist(automovil);
	}

	@Override
	public Automovil buscar(String placa) {
		// TODO Auto-generated method stub
		return this.manager.find(Automovil.class, placa);
	}
	
	

}
