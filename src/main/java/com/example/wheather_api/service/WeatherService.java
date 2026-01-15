package com.example.wheather_api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.wheather_api.dto.WeatherApiResponse;
import com.example.wheather_api.exception.WeatherException;
import com.example.wheather_api.model.WheatherRequestResponse;
import com.example.wheather_api.repository.WheatherRepository;

@Service
public class WeatherService {

	@Value("${weather.api.key}")
	public String apikey;
	
	@Value("${weather.api.url}")
	public String apiurl;
	
	
	private final WheatherRepository repository;
	private final RestTemplate restTempelate = new RestTemplate();
	
	public WeatherService(WheatherRepository repository) {
        this.repository = repository;
    }
	
	
	public WheatherRequestResponse getWeather(String city) {
		try {
		String url = apiurl + "?q=" + city + "&appid=" + apikey + "&units=metric";
		WeatherApiResponse response = restTempelate.getForObject(url, WeatherApiResponse.class);
		
		WheatherRequestResponse record = new WheatherRequestResponse();
		record.setCity(city);
		record.setTemp(response.main.temp);
		record.setHumidity(response.main.humidity);
		record.setDesc(response.weather.get(0).description);
		record.setRequestTime(LocalDateTime.now());
		return repository.save(record);
		
	}
	
	catch (Exception ex) {
        throw new WeatherException("Failed to fetch weather for city: " + city);
    }
}
}
