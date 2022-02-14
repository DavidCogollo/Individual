package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ComunidadDao;
import com.example.demo.entity.Alumno;
import com.example.demo.entity.Comunidad;



public class ComunidadServiceImpl implements ComunidadService{
	@Autowired
	ComunidadDao comunidadDAO;
	@Override
	public List<Comunidad> getComunidad() {
		return (List<Comunidad>) this.comunidadDAO.findAll();
	
	}

	@Override
	public Comunidad getComunidad(long id) {
		return this.comunidadDAO.findById(id).orElse(null);
	}

	@Override
	public Comunidad postComunidad(Comunidad comunidad) {
		
		return this.comunidadDAO.save(comunidad);
	}
	

	@Transactional
	@Override
	public Comunidad putComunidad(Comunidad comunidad, long id) {
		Comunidad toUpdateComunidad = getComunidad(id);
		
		if (toUpdateComunidad==null) return null;
		
		toUpdateComunidad.setNombreComunidad(comunidad.getNombre());
		return this.comunidadDAO.save(toUpdateComunidad);
	}
	

	@Override
	public Comunidad deleteComunidad(long id) {
		Comunidad deletedComunidad = this.comunidadDAO.findById(id).orElse(null);
		this.comunidadDAO.deleteById(id);
		return deletedComunidad;
	}

}
