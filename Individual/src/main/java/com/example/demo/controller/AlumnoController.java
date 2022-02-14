package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Alumno;
import com.example.demo.service.AlumnoServiceImpl;



@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	AlumnoServiceImpl alumnoServiceImpl;
	
	@GetMapping("/all")
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		return new ResponseEntity<>(alumnoServiceImpl.getAlumno(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCliente(@PathVariable Long id) {
		Alumno alumno = null;
		Map<String, Object> response = new HashMap<>();
		try {
			alumno = alumnoServiceImpl.getAlumno(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (alumno == null) {
			response.put("mensaje", "El alumno ID: " + id.toString() + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);

	}
	
	@PostMapping("")
	public ResponseEntity<?> postAlumno(@RequestBody Alumno alumno) {
		Alumno newAlumno = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newAlumno = alumnoServiceImpl.postAlumno(alumno);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (newAlumno == null) {
			response.put("mensaje", "El cliente: " + alumno.getNombre()+" "+alumno.getApellidos() + " no se ha guardado en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("cliente", newAlumno);
		response.put("mensaje", "Se ha guardado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	
	@PutMapping("/{id}")
	public ResponseEntity<?> putAlumno(@RequestBody Alumno alumno, @PathVariable long id) {
		Alumno editCliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			editCliente = alumnoServiceImpl.putAlumno(alumno, id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al editar al usuario");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (editCliente == null) {
			response.put("mensaje", "No se han hecho cambios para este cliente");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("cliente", editCliente);
		response.put("mensaje", "Se ha editado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAlumno(@PathVariable long id) {
		Alumno deleteAlumno = null;
		Map<String, Object> response = new HashMap<>();
		try {
			deleteAlumno = alumnoServiceImpl.deleteAlumno(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			if (deleteAlumno == null) {
				response.put("error2", "No existe el usuario: " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
			}
			response.put("mensaje", "Error al eliminar al usuario");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("alumno", deleteAlumno);
		response.put("mensaje", "Se ha eliminado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}


