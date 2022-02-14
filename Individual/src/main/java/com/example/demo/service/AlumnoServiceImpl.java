package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AlumnoDao;
import com.example.demo.entity.Alumno;


@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	

		@Autowired
		AlumnoDao alumnoDAO;
		
		@Transactional(readOnly=true)
		@Override
		public List<Alumno> getAlumno() {
			return (List<Alumno>) this.alumnoDAO.findAll();
		}
		
		@Transactional(readOnly=true)
		@Override
		public Alumno getAlumno(long id) {
			return this.alumnoDAO.findById(id).orElse(null);
		}

		@Transactional
		@Override
		public Alumno postAlumno(Alumno alumno) {
			return this.alumnoDAO.save(alumno);
		}
		
			
		
		
		
		@Transactional
		@Override
		public Alumno putAlumno(Alumno alumno, long id) {
			Alumno toUpdateAlumno = getAlumno(id);
			
			if (toUpdateAlumno==null) return null;
			
			toUpdateAlumno.setNombre(alumno.getNombre());
			toUpdateAlumno.setApellidos(alumno.getApellidos());
			toUpdateAlumno.setEmail(alumno.getEmail());
			toUpdateAlumno.setDireccion(alumno.getDireccion());
			toUpdateAlumno.setDni(alumno.getDni());
			toUpdateAlumno.setCodigoP(alumno.getCodigoP());
			toUpdateAlumno.setDni(alumno.getDni());
			toUpdateAlumno.setTelefono(alumno.getTelefono());
//			toUpdateAlumno.setImagen(alumno.getImagen());
			return this.alumnoDAO.save(toUpdateAlumno);
		}	

		@Transactional
		@Override
		public Alumno deleteAlumno(long id) {
			Alumno deletedAlumno = this.alumnoDAO.findById(id).orElse(null);
			this.alumnoDAO.deleteById(id);
			return deletedAlumno;
		}

	}


