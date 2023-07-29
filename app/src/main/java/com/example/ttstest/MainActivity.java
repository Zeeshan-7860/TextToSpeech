package com.example.ttstest;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ttstest.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private EditText editText;
    private Button speakButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        speakButton = findViewById(R.id.speakButton);

        textToSpeech = new TextToSpeech(this, status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.forLanguageTag("en-US"));
            }
        });

        speakButton.setOnClickListener(v -> {
            String text = editText.getText().toString();
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textToSpeech.shutdown();
    }
}
