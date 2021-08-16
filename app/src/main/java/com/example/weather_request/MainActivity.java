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

    mTextView = binding.text;
    // System.err.println("Hello Rohan");
    System.err.println("binding.text = " + binding.text);
  }
}