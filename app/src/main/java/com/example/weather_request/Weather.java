package com.example.weather_request;

import okhttp3.OkHttpClient;

public class Weather {
  private final OkHttpClient client = new OkHttpClient();
  private String location;
  private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
  private final String APP_KEY = "appid=83f5137c3419c91f35a937d3ce9f7f54";

  public Weather(String location) {
    if (location == null) {
      this.location = "Mountain View";
    } else {
      this.location = location;
    }
  }

  
}
