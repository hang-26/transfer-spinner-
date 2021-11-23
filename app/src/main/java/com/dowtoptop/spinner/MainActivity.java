package com.dowtoptop.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_value;
    TextView btn_result;
    TextView tv_result;
    Spinner spn_list_one;
    Spinner spn_list_two;
    String value;
    int he_so_1=1;
    int he_so_2=1;

    float number;
    String  spinner_one[]={
            "Kilometers",
            "meters",
            "centimeter"};
    String spinner_two[]=
    {
         "meters",
         "centimeter",
         "millimeters"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, spinner_one
                );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //Thiết lập adapter cho Spinner
        spn_list_one.setAdapter(adapter);
        //thiết lập sự kiện chọn phần tử cho Spinner
        spn_list_one.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        he_so_1 = 1000000;
                        break;
                    case  1:
                        he_so_1 = 1000;
                        break;
                    case 2:
                        he_so_1 = 10;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
        (this, android.R.layout.simple_spinner_item, spinner_two);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spn_list_two.setAdapter(adapter1);
        spn_list_two.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        he_so_2 = 1000;
                        break;
                    case 1:
                        he_so_2 = 10;
                        break;
                    case 2:
                        he_so_2 = 1;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void init()
    {
        edt_value = findViewById(R.id.edt_value);
        btn_result = findViewById(R.id.btn_result);
        spn_list_one = findViewById(R.id.spn_list_one);
        spn_list_two = findViewById(R.id.spn_list_two);
        tv_result = findViewById(R.id.tv_result);
    }
    private void addListener()
    {
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();

            }
        });

        edt_value.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                convert();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void convert() {
        value = edt_value.getText().toString();
        number = Float.parseFloat(value);
        float result = number*he_so_1/he_so_2;
       tv_result.setText(String.valueOf(result));
        Log.d("__TH__", String.valueOf(result));

    }


}