package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comunidad;

@Repository
public interface ComunidadDao extends CrudRepository<Comunidad, Long> {

}
