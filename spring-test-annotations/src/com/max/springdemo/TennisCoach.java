package com.max.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// will use the defaul bean ID (class name with lower first letter)
public class TennisCoach implements Coach {
	
	
	//auto wiring using field injection (reflection)
	@Autowired
	@Qualifier("randomFortuneService") // first letter should be lower case of class name
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
//	//auto wiring using method
//	
//	@Autowired
//	public void doSomeStuff(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: inside doSomeStuff");
//		fortuneService = theFortuneService;
//	}

//	//auto wiring using setter
//	// define a setter method
//	
//	@Autowired // when we reach this part it will try to inject a dependency and it will search
//				// for a class that implements fortuneService
//	
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService");
//		this.fortuneService = fortuneService;
//	}

//  //auto wiring using constructor
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyWorkout() {

		return "Practive your volley!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
