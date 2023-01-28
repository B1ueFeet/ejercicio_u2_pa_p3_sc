package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.manager.persist(cliente);
	}

	@Override
	public Cliente buscar(String cedula) {
		
		return this.manager.find(Cliente.class, cedula);
	}

}
