package com.medibot.spring.repositories;
import com.medibot.spring.models.Hospitales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalesRepo extends JpaRepository<Hospitales, Integer>{
	public abstract Hospitales findByNombre(String nombre);	
        public abstract Hospitales findById(Long id);
}