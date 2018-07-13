package com.example.dylanshoupe.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = findViewById(R.id.signature_canvas);

        final Spinner spinner = findViewById(R.id.brushes);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.brushsizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Spinner s = findViewById(R.id.colors);
                String text = s.getSelectedItem().toString();
                Spinner s2 = findViewById(R.id.brushes);
                String text2 = s2.getSelectedItem().toString();
                customCanvas.updatePaint(text, text2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        Spinner spinner2 = findViewById(R.id.colors);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Spinner s = findViewById(R.id.colors);
                String text = s.getSelectedItem().toString();
                Spinner s2 = findViewById(R.id.brushes);
                String text2 = s2.getSelectedItem().toString();
                customCanvas.updatePaint(text, text2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }
}
