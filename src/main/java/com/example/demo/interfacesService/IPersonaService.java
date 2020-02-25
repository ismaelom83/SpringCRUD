package com.example.demo.interfacesService;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	public Optional<Persona> listarID(int id);
	public int save(Persona p);
	public void delete(int id);

}
