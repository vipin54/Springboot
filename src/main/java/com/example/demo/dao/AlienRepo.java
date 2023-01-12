package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;


//we are replacing CrudRepository with a JpaRepository as it have more features and enables to send data as json format
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	List<Alien> findByTech(String tech);
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
}
