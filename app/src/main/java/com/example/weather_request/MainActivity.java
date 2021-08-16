package com.example.weather_request;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.weather_request.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

  private TextView mTextView;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    try {
      Weather weather = new Weather("San Jose", mTextView, binding);
      weather.sendGet();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}