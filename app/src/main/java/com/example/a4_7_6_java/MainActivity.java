package com.example.a4_7_6_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import com.example.a4_7_6_java.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        initViews();
    }
    void initViews(){

        binding.btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=binding.etHome.getText().toString();

      //  String text = "I would like to visit https://www.google.com and https://www.youtube.com";
        SpannableString spannable = new SpannableString(text);
        Pattern pattern = Pattern.compile("(https?://\\S+)");
        Matcher matcher = pattern.matcher(spannable);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            spannable.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    // Handle click event here
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(Color.BLUE);
                    ds.setUnderlineText(false);
                }
            }, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        binding.tvClone.setText(spannable);
        binding.tvClone.setMovementMethod(LinkMovementMethod.getInstance());

            }
        });

    }
}