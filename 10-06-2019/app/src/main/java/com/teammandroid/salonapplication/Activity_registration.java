package com.teammandroid.salonapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.Calendar;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class Activity_registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText username,Phone,Email,Address;
    TextView Dob;
    Spinner State,District,City;
    String[] states = { "Maharashtra", "Rajasthan", "Bengal", "Punjab", "Delhi"};
    String[] districts = { "Aurangabad", "Pune", "Mumbai", "Beed", "Solapur"};
    Button createbtn;
    Spinner sp_state,sp_District;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        awesomeValidation = new AwesomeValidation(BASIC);


       /* ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,states);
        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,districts);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_state.setAdapter(aa);
        sp_District.setAdapter(bb);*/
        initView();
    }
    private void initView() {
        sp_state = findViewById(R.id.s_state);
        sp_state.setOnItemSelectedListener(this);
        sp_District = findViewById(R.id.s_district);
        sp_state.setOnItemSelectedListener(this);

        username = (EditText) findViewById(R.id.et_name);
        Phone = (EditText) findViewById(R.id.et_mobileno);
        Email = (EditText) findViewById(R.id.et_email);
        State = (Spinner) findViewById(R.id.s_state);
        District=(Spinner) findViewById(R.id.s_district);
        City=(Spinner) findViewById(R.id.s_city);

        Address=(EditText) findViewById(R.id.et_address);

        createbtn = findViewById(R.id.b_Continue);
        createbtn.setOnClickListener(this);
        addValidationToViews();
        if (State.getSelectedItem().toString().trim().equals("Pick one")) {
            Toast.makeText(Activity_registration.this, "Error", Toast.LENGTH_SHORT).show();
        }

        if (District.getSelectedItem().toString().trim().equals("Pick one")) {
            Toast.makeText(Activity_registration.this, "Error", Toast.LENGTH_SHORT).show();
        }




    }
    private void addValidationToViews() {

        awesomeValidation.addValidation(this, R.id.et_name, RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        awesomeValidation.addValidation(this, R.id.et_mobileno, "^[+]?[0-9]{10,13}$", R.string.invalid_phone);

        awesomeValidation.addValidation(this, R.id.et_email, Patterns.EMAIL_ADDRESS, R.string.invalid_email);

        awesomeValidation.addValidation(this, R.id.et_address, RegexTemplate.NOT_EMPTY, R.string.invalid_education);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void submitForm() {
        // Validate the form...
        if (awesomeValidation.validate()) {
            // Here, we are sure that form is successfully validated. So, do your stuffs now...
            Toast.makeText(this, "Form Validated Successfully", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_Continue:
                submitForm();
                    /*Intent intent = new Intent(ActivityRegistration.this,HomeActivity.class);
                    startActivity(intent);
                    finish();*/
                break;

        }
    }
}
