/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medibot.spring.services;

import com.medibot.spring.models.Hospitales;
import com.medibot.spring.repositories.HospitalesRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalesService {
    	@Autowired
	private HospitalesRepo hospitalesRepo;
        
	public List<Hospitales> listar() {
            
		return hospitalesRepo.findAll();
	
        }	
	public Hospitales burcarNombre(String nombre) {
            
		return hospitalesRepo.findByNombre(nombre);
	
        }	
	
        public void guardar(Hospitales hospitales) {
	
            hospitalesRepo.save(hospitales);
	
        }	
	
        public Hospitales buscar(long id) {
	
            return hospitalesRepo.findById(id);
	
        }	
        
        public boolean eliminar(Long id) {
		try {
			hospitalesRepo.delete(hospitalesRepo.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
