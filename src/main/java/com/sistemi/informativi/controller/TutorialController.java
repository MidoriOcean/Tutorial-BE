package com.sistemi.informativi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.entity.Tutorial;
import com.sistemi.informativi.service.TutorialService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

	@Autowired
	private TutorialService tutorialService; 
	
	@GetMapping("")
	public List<Tutorial> findAllTutorials() throws Exception{
		
		return tutorialService.findAllTutorials();
	}
	
	@GetMapping("/tutorial-id/{id}")
	public Tutorial findTutorialById(@PathVariable int id) throws Exception {
		
		return tutorialService.findTutorialById(id);
	}
	
	@PostMapping("")
	public Tutorial saveTutorial(@RequestBody Tutorial tutorial) throws Exception {
		
		return tutorialService.savedOrUpdated(tutorial);
	}
	
	@PutMapping("")
	public Tutorial updateTutorial(@RequestBody Tutorial tutorial) throws Exception {
		
		return tutorialService.savedOrUpdated(tutorial);
	}
	
	@DeleteMapping("tutorial-id/{id}")
	public Map<String, Boolean> deleteTutorial(@PathVariable int id){
		
		return tutorialService.deleteTutorial(id);
	} 
}
