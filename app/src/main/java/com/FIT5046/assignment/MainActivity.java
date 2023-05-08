package com.FIT5046.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private EditText accountName,AddressOne,AddressTwo,Cityinput,stateinput,zipinput,countryinput;

    private Spinner spinnergender;

    private Button SignUP;

    EditText datePicker;
    TextView DateOfBirth;

    DatePickerDialog.OnDateSetListener setListener;

    private Button mapbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountName = findViewById(R.id.enterAccountname);
        SignUP = findViewById(R.id.SignUP);
        AddressOne = findViewById(R.id.AddressOne);
        AddressTwo = findViewById(R.id.AddressTwo);
        Cityinput = findViewById(R.id.Cityinput);
        stateinput = findViewById(R.id.stateinput);
        zipinput = findViewById(R.id.zipinput);
        countryinput = findViewById(R.id.countryinput);
        spinnergender = findViewById(R.id.genderspinner);





        //calendar
        datePicker = findViewById(R.id.datePicker);
        DateOfBirth = findViewById(R.id.DateOfBirth);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);




                datePicker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                month = month + 1;
                                String date = day + "/" + month + "/" + year;
                                datePicker.setText(date);
                            }


                        },year,month,day);
                        datePickerDialog.show();
                    }
                });


                //spinner for gender
                Spinner spinner = findViewById(R.id.genderspinner);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.genderarray, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                //button for map
                mapbtn = findViewById(R.id.mapbutton);

                mapbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,mapActivity.class);
                        startActivity(intent);
                    }
                });

        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account_name = accountName.getText().toString();
                String date_picker = datePicker.getText().toString();
                String Address_One = AddressOne.getText().toString();
                String Address_two = AddressTwo.getText().toString();
                String city_input = Cityinput.getText().toString();
                String state_input =stateinput.getText().toString();
                String zip_input = zipinput.getText().toString();
                String country_input = countryinput.getText().toString();
                String spinner_gender = spinnergender.getSelectedItem().toString();
                CreateAccountClass createAccountClass = new CreateAccountClass(account_name,date_picker,Address_One,Address_two,city_input,state_input,zip_input,country_input,spinner_gender);
                if(account_name.isEmpty() || Address_One.isEmpty() || date_picker.isEmpty() || city_input.isEmpty() || state_input.isEmpty() || zip_input.isEmpty() || country_input.isEmpty() )
                {
                    Toast.makeText(MainActivity.this,"None of the value is enter",Toast.LENGTH_SHORT).show();
                }
                else{
                    FirebaseDatabase.getInstance().getReference().child("Data entry for create account").push().child(account_name).setValue(createAccountClass);
                }
            }
        });

    }
}







