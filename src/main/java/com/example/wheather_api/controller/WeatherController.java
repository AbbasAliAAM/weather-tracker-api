package com.example.wheather_api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wheather_api.model.WheatherRequestResponse;
import com.example.wheather_api.service.WeatherService;

import jakarta.validation.constraints.NotBlank;


@CrossOrigin(
	    origins = {
	        "http://localhost:3000",
	        "https://abbasaliaam.github.io",
	        "https://*.netlify.app"
	    },
	    methods = {
	            RequestMethod.GET,
	            RequestMethod.POST,
	            RequestMethod.OPTIONS
	        }
	)

@RestController
@RequestMapping("/aam/weather")
public class WeatherController {

	
	private final WeatherService service;
	
//	Constructor Injection
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@GetMapping
	public WheatherRequestResponse getWeather(@RequestParam @NotBlank(message = "City Cant Be blank") String city) {
		return service.getWeather(city);
		
	}
}
