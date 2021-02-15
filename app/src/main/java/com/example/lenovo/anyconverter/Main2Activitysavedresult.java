package com.example.lenovo.anyconverter;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activitysavedresult extends AppCompatActivity {
    DataBaseHelper myDb;
    TextView textviewresult;
    Button btnread;
    private void Clickme()
    {

        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();

        if (res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                stringBuffer.append("ID: " +res.getString(0)+"\n");
                stringBuffer.append("From: " +res.getString(1)+"  ");
                stringBuffer.append(res.getString(3)+"\n");
                stringBuffer.append("to: " +res.getString(2)+"  ");

                stringBuffer.append(res.getString(4)+"\n");


            }

            textviewresult.setText(stringBuffer.toString());

        } else {
            Toast.makeText(this, "no data", Toast.LENGTH_LONG).show();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitysavedresult);
        myDb=new DataBaseHelper(this);
        textviewresult=findViewById(R.id.textviewresult);
        btnread=findViewById(R.id.btnread);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickme();
            }
        });

    }

/*private void Clickme()
{

        Cursor res = myDb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();

        if (res!=null && res.getCount()>0)
        {
            while (res.moveToNext())
            {
                stringBuffer.append("ID:" +res.getString(0)+"\n");
                stringBuffer.append("From:" +res.getString(1)+"\n");
                stringBuffer.append("to:" +res.getString(2)+"\n");
                stringBuffer.append("valFrom:" +res.getString(3)+"\n");
                stringBuffer.append("valTo" +res.getString(4)+"\n");


            }

            textviewresult.setText(stringBuffer.toString());

        } else {
            Toast.makeText(this, "no data", Toast.LENGTH_LONG).show();

        }
    }*/



}
