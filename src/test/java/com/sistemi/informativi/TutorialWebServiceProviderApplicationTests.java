package com.sistemi.informativi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sistemi.informativi.entity.Tutorial;
import com.sistemi.informativi.service.TutorialService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TutorialWebServiceProviderApplicationTests {

	
	@Autowired
	private TutorialService tutorialService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void savetTutorial() throws Exception {
		
		Tutorial tutorial = new Tutorial("System", "Cisco");
		Tutorial savedOrUpdated = tutorialService.savedOrUpdated(tutorial);
		
		int id = savedOrUpdated.getId();
		assertEquals(id,7);
	}

}
