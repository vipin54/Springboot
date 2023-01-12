package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;


@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	//commented for REST methods
	/*
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
	} */
	
	//commmented for implementing rest webservices part
/*	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv= new ModelAndView("showAlien.jsp");
		
		//We have to save the output returned and the output type is Alien so
		Alien alien= repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		//System.out.println(repo.findByTech("Java"));
		//System.out.println(repo.findByAidGreaterThan(102));
		//System.out.println(repo.findByTechSorted("Java"));
		
		return mv;
	}
	
	*/
	/*
	@RequestMapping("/delAlien")
	public ModelAndView delAlien(@RequestParam int aid) {
		
		ModelAndView mv= new ModelAndView("deleteAlien.jsp");
		
		//We have to save the output returned and the output type is Alien so
		Alien alien1= repo.findById(aid).orElse(new Alien());
		repo.deleteById(aid);
		mv.addObject(alien1);
		return mv;
	}
	*/
	
	/*
	//for Rest Web services we do not want ModelandView or any view all below code is for REST
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/aliens/{aid}")
	@ResponseBody
	public String getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid).toString();
	}
	*/
	
	//abovee code will look like after extentding jparepositry in repo interface
	@GetMapping("/aliens")        //@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	//Now in new spring feture there is seperate for requestmapping i.e @GetMapping and PostMapping
	@PostMapping("/aliens")
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> delAlien(@PathVariable("aid") int aid) {
		Optional <Alien> a = repo.findById(aid);
		repo.deleteById(aid);
		return a;
	}
	
	@PutMapping(path="/aliens")
	@ResponseBody
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		
		repo.save(alien);
		return alien;
	}
	
}
