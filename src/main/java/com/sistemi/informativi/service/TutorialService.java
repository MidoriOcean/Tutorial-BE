package com.sistemi.informativi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.informativi.entity.Tutorial;

public interface TutorialService {

	public List<Tutorial> findAllTutorials() throws Exception;
	
	public Tutorial findTutorialById(int id) throws Exception;
	
	public Tutorial savedOrUpdated(Tutorial tutorial) throws Exception;
	
	public Map<String, Boolean> deleteTutorial(int id);
}
