package com.example.lenovo.anyconverter;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   private DrawerLayout mDrawerLayout;
   private Button checksave;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=findViewById(R.id.DrawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.Length).setOnClickListener(MainActivity.this);
        findViewById(R.id.checksave).setOnClickListener(MainActivity.this);
        findViewById(R.id.Tempreture).setOnClickListener(MainActivity.this);
        findViewById(R.id.Volumes).setOnClickListener(MainActivity.this);
        findViewById(R.id.Calculator).setOnClickListener(MainActivity.this);
        findViewById(R.id.Data).setOnClickListener(MainActivity.this);
        findViewById(R.id.Currency).setOnClickListener(MainActivity.this);
       // findViewById(R.id.SAVED).setOnClickListener(MainActivity.this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public  void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.Length:
                openActivity1();
                break;
            case R.id.Tempreture:
                openActivity2();
                break;
            case R.id.Volumes:
                openActivity3();
                break;
            case R.id.Calculator:
                openActivity4();
                break;
            case R.id.Data:
                openActivity5();
                break;
            case R.id.Currency:
                openActivity6();
                break;
                case R.id.checksave:
                   openActivity10();
                   break;
            case R.id.SAVED:
                openActivity10();




        }
    }

    private void openActivity1()
    {
        Intent intent = new Intent(this, Main2ActivityLength.class);
        startActivity(intent);
    }

    private void openActivity2()
    {
        Intent intent = new Intent(this, Main2ActivityTempreture.class);
        startActivity(intent);
    }
    private void openActivity3()
    {
        Intent intent = new Intent(this, Main2ActivityVolumes.class);
        startActivity(intent);
    }
    private void openActivity4()
    {
        Intent intent = new Intent(this, Main2ActivityCalculator.class);
        startActivity(intent);
    }
    private void openActivity5()
    {
        Intent intent = new Intent(this, Main2ActivityData.class);
        startActivity(intent);
    }
    private void openActivity6()
    {
        Intent intent = new Intent(this, Main2ActivityCurrency.class);
        startActivity(intent);
    }
    private void openActivity10()
    {
        Intent intent = new Intent(this, Main2Activitysavedresult.class);
        startActivity(intent);
    }
}
