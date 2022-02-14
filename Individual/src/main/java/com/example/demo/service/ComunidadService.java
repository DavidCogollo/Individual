package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Comunidad;

public interface ComunidadService {
	

		List<Comunidad> getComunidad();

		Comunidad getComunidad(long id);

		Comunidad postComunidad(Comunidad comunidad);
		
		
		Comunidad putComunidad(Comunidad comunidad, long id);
		
		
		Comunidad deleteComunidad(long id);
	}


