package com.example.conversion;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private RadioButton euroToDinarRadioButton;
    private RadioButton dinarToEuroRadioButton;
    private Button convertButton;
    private TextView resultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputField = findViewById(R.id.input_field);
        euroToDinarRadioButton = findViewById(R.id.euro_to_dinar_radio_button);
        dinarToEuroRadioButton = findViewById(R.id.dinar_to_euro_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultField = findViewById(R.id.result_field);

        // Set click listener for convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input value
                String inputText = inputField.getText().toString();
                if (inputText.isEmpty()) {
                    resultField.setText("Please enter a number");
                    return;
                }
                double inputValue = Double.parseDouble(inputText);

                // Check selected radio button and convert
                double result;
                if (euroToDinarRadioButton.isChecked()) {
                    result = inputValue / 3.5;
                } else {
                    result = inputValue * 3.5;
                }

                // Show result
                resultField.setText(String.valueOf(result));
            }
        });
    }
}
