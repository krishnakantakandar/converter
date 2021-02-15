package com.example.lenovo.anyconverter;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;
public class Main2ActivityData extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    DataBaseHelper myDb;

    private Spinner spinner1, spinner2;
    private TextView textView1,textView2;
    String currentNumber;
    String text1 , text2 ;
    int k,l;
    double h;
    double d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_data);
      //  mDrawerLayout=findViewById(R.id.DrawerLayout);
        currentNumber="";
        myDb=new DataBaseHelper(this);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
      //  mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
       // mDrawerLayout.addDrawerListener(mToggle);
        //mToggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ddata, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        findViewById(R.id.one).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.two).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.three).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.four).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.five).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.six).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.seven).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.eight).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.nine).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.zero).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.del).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.cal).setOnClickListener(Main2ActivityData.this);
        findViewById(R.id.save).setOnClickListener(Main2ActivityData.this);
    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent==spinner1) {
            text1 = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), text1, Toast.LENGTH_SHORT).show();
            k=position+1;
            if(currentNumber.length()>0)
                calExchange(Double.parseDouble(currentNumber));
        }
        else {
            text2 = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), text2, Toast.LENGTH_SHORT).show();
            l=position+1;
            if(currentNumber.length()>0)
                calExchange(Double.parseDouble(currentNumber));
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.one:
                numberIsTapped(1);

                break;

            case R.id.two:
                numberIsTapped(2);

                break;
            case R.id.three:
                numberIsTapped(3);

                break;
            case R.id.four:
                numberIsTapped(4);

                break;
            case R.id.five:
                numberIsTapped(5);


                break;
            case R.id.six:
                numberIsTapped(6);

                break;
            case R.id.seven:
                numberIsTapped(7);

                break;
            case R.id.eight:
                numberIsTapped(8);

                break;
            case R.id.nine:
                numberIsTapped(9);

                break;
            case R.id.zero:
                numberIsTapped(0);

                break;
            case R.id.del:
                Delete();

                break;
            case R.id.cal:
                pointIsTapped(".");

                break;

            case R.id.save:
                inert();
                myDb=new DataBaseHelper(this);

        }
    }
    private void numberIsTapped(int tapped) {


        currentNumber = currentNumber + String.valueOf(tapped);
        // calculationString += String.valueOf(tapped);
        textView1.setText(currentNumber);
        calExchange(Double.parseDouble(currentNumber));



    }
    private void pointIsTapped(String a)
    {
        currentNumber=currentNumber+a;
        textView1.setText(currentNumber);
        calExchange(Double.parseDouble(currentNumber));
    }
    private void calExchange(double Number)
    {


       if(k<=3&&l<=3) {
           d = k - l;
           if (d > 0) {
               d=Number * 4 * d;
               textView2.setText(String.valueOf(d));
           }
           if (d < 0) {
               d=(Number / (4 * Math.abs(d)));

               textView2.setText(String.valueOf(d));
           }
           if(k==l) {
               d=Number;
               textView2.setText(String.valueOf(d));
           }
       }
       else {
           if ((l != 1 && l != 2) && (k != 2 && k != 1))
           {
               d = k - l;
               if (d > 0) {
                   d=Number * Math.pow(1024.0f, d);

                   textView2.setText(String.valueOf(d ));
               }
               if (d < 0) {
                   d=Number / Math.pow(1024.0f, Math.abs(d));
                   textView2.setText(String.valueOf(d ));
               }
               if(k==l) {
                   d=Number;
                   textView2.setText(String.valueOf(d));
               }
           }
           else{
               if(k==l) {
                   d=Number;
                   textView2.setText(String.valueOf(d));
               }
               else{
                   d=k-l;
                   if(d>0)
                   {
                       h=Number*Math.pow(1024.0f,(k-3.0f));
                       d=h*(4.0f*Math.abs(3.0f-l));
                       textView2.setText(String.valueOf(d));
                   }
                   if(d<0)
                   {
                       h=Number / (4 * Math.abs(k-3.0f));
                       d=h/Math.pow(1024.0f,Math.abs(3.0f-l));
                       textView2.setText(String.valueOf(d));
                   }

               }

           }
       }


    }
    private void Delete() {
        try {


            if (currentNumber.length() > 0) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                textView1.setText(currentNumber);
                calExchange(Double.parseDouble(currentNumber));
            } else {
                textView1.setText("0");
                textView2.setText("0");
            }
        }catch (NumberFormatException ex)
        {
            Toast.makeText(getApplicationContext(),"Nothing To Delete",Toast.LENGTH_SHORT).show();
        }
    }
    public void inert()
    {

        Boolean result=myDb.insertData(text1,text2,(Double.parseDouble(currentNumber)),d);
        if(result==true)
        {
            Toast.makeText(this,"data inserted successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"data insertion failed ",Toast.LENGTH_SHORT).show();
        }
    }
}
