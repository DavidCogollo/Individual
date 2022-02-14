package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Alumno;



public interface AlumnoService {

	List<Alumno> getAlumno();

	Alumno getAlumno(long id);

	Alumno postAlumno(Alumno alumno);
	
	
	Alumno putAlumno(Alumno alumno, long id);
	
	
	Alumno deleteAlumno(long id);
}

