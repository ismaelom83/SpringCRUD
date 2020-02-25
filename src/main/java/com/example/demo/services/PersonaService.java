package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IPersona;
import com.example.demo.interfacesService.IPersonaService;
import com.example.demo.model.Persona;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarID(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Persona p) {
		int res = 0;
		Persona persona=data.save(p);
		if (!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
