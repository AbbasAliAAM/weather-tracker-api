package com.example.wheather_api.dto;

import java.util.List;

public class WeatherApiResponse {
	
	public Main main;
	
	public List<Weather> weather;
	
	public static class Main{
		public double temp;
        public int humidity;			
	}
	public static class Weather {
        public String description;
    }
}
