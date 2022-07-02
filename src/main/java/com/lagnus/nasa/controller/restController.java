package com.lagnus.nasa.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class restController {
	
	@GetMapping("/asteroid")
	//@ResponseBody
	private String asteroids(@RequestParam int days) {
		
		String currentD = currentDate();
		String plusD = plusDate(days);
		
		//String uri = "https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=DEMO_KEY";
		String uri = "https://api.nasa.gov/neo/rest/v1/feed?start_date="+  currentD + "&end_date="+ plusD +"&api_key=DEMO_KEY";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;		
		
	}
	
	private String currentDate() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date_str = sdf.format(date);
		return date_str;
	}
	
	private String plusDate(int day) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		date = calendar.getTime();
		String date_str = sdf.format(date);
		
		return date_str;
	}
}
