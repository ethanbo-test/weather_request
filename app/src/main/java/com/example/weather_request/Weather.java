package com.example.weather_request;

import android.widget.TextView;
import com.example.weather_request.databinding.ActivityMainBinding;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Weather {
  private final OkHttpClient client = new OkHttpClient();
  private String location;
  private TextView textView;
  private ActivityMainBinding binding;
  private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
  private final String APP_KEY = "appid=83f5137c3419c91f35a937d3ce9f7f54";
  private String result;

  public Weather(String location, TextView textView, ActivityMainBinding binding) {
    if (location == null) {
      this.location = "Mountain View";
    } else {
      this.location = location;
    }
    this.textView = textView;
    this.binding = binding;
  }

  private String getUrl() {
    return BASE_URL + "?" + this.APP_KEY + "&q=" + this.location;
  }

  protected void sendGet() throws IOException {
    String url = this.getUrl();
    Request request = new Request.Builder()
        .url(url)
        .build();

    this.client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        System.err.println("1111111");
        e.printStackTrace();
        textView = binding.t1;
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        System.err.println("22222");
        try (ResponseBody responseBody = response.body()) {
          if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
          result = responseBody.string();
          System.err.println("result = " + result);
          binding.t1.setText(result);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          textView = binding.t1;
        }
      }
    });
  }
}
