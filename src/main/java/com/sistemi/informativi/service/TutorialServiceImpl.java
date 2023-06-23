package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Tutorial;
import com.sistemi.informativi.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService{

	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Override
	public List<Tutorial> findAllTutorials() throws Exception {

		List<Tutorial> tutorials = new ArrayList<>();
		
		tutorials = tutorialRepository.findAll();
		
		if(tutorials.isEmpty()) {
			
			throw new Exception("Nun ce stanno tutorials brodo");
		}
		
		return tutorials;
	}

	@Override
	public Tutorial findTutorialById(int id) throws Exception {
		
		return tutorialRepository.findById(id).orElseThrow(()-> new Exception("Sto tutorial non esiste brodissimo"));
	}

	@Override
	public Tutorial savedOrUpdated(Tutorial tutorial) throws Exception {

		Tutorial savedOrUpdated = tutorialRepository.save(tutorial);
		
		if(!savedOrUpdated.getName().equals(tutorial.getName())) {
			
			throw new Exception("Nun l'ha salvato (o updatato, che ne so) brodins");
		}
		
		return savedOrUpdated;
	}

	@Override
	public Map<String, Boolean> deleteTutorial(int id) {

		Map<String, Boolean> deletionMap = new HashMap<>();
		
		try {
			
			tutorialRepository.deleteById(id);
			deletionMap.put("Deletion", true);
		} catch(IllegalArgumentException ex) {
			
			ex.printStackTrace();
			deletionMap.put("Deletion", false);
		}
		
		return deletionMap;
	}

}
