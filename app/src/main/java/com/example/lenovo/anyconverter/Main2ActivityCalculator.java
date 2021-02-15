package com.example.lenovo.anyconverter;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2ActivityCalculator extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private enum OPERATOR {
        PLUS, MINUS, DIVIDE, MULTIPLY, EQUAL
    }

    private String currentNumber;
    private String numberLeft;
    private String numberRight;
    private OPERATOR currentOperator;
    private OPERATOR lateOperator;
    private int f;
    private int c;
    private  int v;
    private double calculationResult;
    private String calculationString;
    private String carry;
    TextView txtCalculation;
    TextView txtResult;
    String hold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_calculator);
        mDrawerLayout=findViewById(R.id.DrawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        currentOperator=null;
        lateOperator=null;
        currentNumber = "";
        numberLeft="";
        v=1;
        c = 0;
        //calculationResult=0;
        calculationString = "";
        numberRight="";
        carry = "";
        f=0;
        txtCalculation = findViewById(R.id.txtCalculation);
        txtResult = findViewById(R.id.txtResult);
        findViewById(R.id.btnEqual).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnSeven).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnEight).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnNine).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnFour).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnFive).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnSix).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnOne).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnTwo).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnThree).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnZero).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnDel).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnMinus).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Main2ActivityCalculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Main2ActivityCalculator.this);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {

        try {
            switch (v.getId()) {
                case R.id.btnEqual:
                    operatorIsTapped(OPERATOR.EQUAL);

                    break;

                case R.id.btnSeven:
                    numberIsTapped(7);

                    break;
                case R.id.btnEight:
                    numberIsTapped(8);

                    break;
                case R.id.btnNine:
                    numberIsTapped(9);

                    break;
                case R.id.btnFour:
                    numberIsTapped(4);


                    break;
                case R.id.btnFive:
                    numberIsTapped(5);

                    break;
                case R.id.btnSix:
                    numberIsTapped(6);

                    break;
                case R.id.btnOne:
                    numberIsTapped(1);

                    break;
                case R.id.btnTwo:
                    numberIsTapped(2);

                    break;
                case R.id.btnThree:
                    numberIsTapped(3);

                    break;
                case R.id.btnClear:
                    clearIsTapped();
                    break;
                case R.id.btnZero:
                    numberIsTapped(0);

                    break;
                case R.id.btnDel:

                    delButton();
                    break;
                case R.id.btnDivide:
                    calculationString = calculationString + "/";
                    carry = "/";
                    operatorIsTapped(OPERATOR.DIVIDE);
                    break;
                case R.id.btnMinus:
                    calculationString += "-";
                    carry = "-";
                    operatorIsTapped(OPERATOR.MINUS);
                    break;
                case R.id.btnPlus:
                    calculationString += "+";
                    carry = "+";
                    operatorIsTapped(OPERATOR.PLUS);
                    break;
                case R.id.btnMultiply:
                    calculationString += "*";
                    carry = "*";
                    operatorIsTapped(OPERATOR.MULTIPLY);
                    break;



            }

            txtCalculation.setText(calculationString);

        } catch (NumberFormatException ex) {
            mathError();
        }
    }

    private void numberIsTapped(int tapped) {

        /*if(currentNumber=="")
        {
            c++;
        }*/
        if((String.valueOf(calculationResult)).equals(calculationString))
        {
            clearIsTapped();
        }
        currentNumber = currentNumber + String.valueOf(tapped);
        calculationString += String.valueOf(tapped);
        txtResult.setText(currentNumber);
        // numberLeft=currentNumber;  //abhi is ko lagaya



    }

    private void operatorIsTapped(OPERATOR tapped) {

        lateOperator = tapped;
        if (c == 0) {
            numberLeft = currentNumber;
            currentOperator = lateOperator;
            c=1;

        } else {

            numberRight = currentNumber;
            if(numberRight=="")
            {
                if(v==0) // this zero checking is for : after giving = sign when we give 1St operator toast should not operate
                {
                    v++;  // this is for while del aleast 1 string should delete

                }
                else {
                    v++;
                    Toast.makeText(getApplicationContext(), "considering last operator of multiple operators", Toast.LENGTH_SHORT).show();

                }
                f = 1;

            }


        }



        //if (currentOperator != null && currentNumber != "") {

        // numberRight = currentNumber;

        currentNumber = "";
        if (numberRight != "") {
            switch (currentOperator) {
                case PLUS:

                    calculationResult = Double.parseDouble(numberLeft) + Double.parseDouble(numberRight);


                    break;
                case MINUS:


                    calculationResult = Double.parseDouble(numberLeft) - Double.parseDouble(numberRight);


                    break;
                case MULTIPLY:

                    calculationResult = Double.parseDouble(numberLeft) * Double.parseDouble(numberRight);


                    break;
                case DIVIDE:

                    calculationResult = Double.parseDouble(numberLeft) / Double.parseDouble(numberRight);


                    break;
                // case EQUAL:


                //   break;
            }
            if(lateOperator==OPERATOR.EQUAL)
            {
                currentOperator=null;
                lateOperator=null;
                v=0;  // this is because after equal button in 1st operator button toast should not be activated

            }
            else {
                currentOperator = lateOperator;
            }
            numberLeft = String.valueOf(calculationResult);
            //c++;

            calculationString = String.valueOf(calculationResult);
            if (tapped != OPERATOR.EQUAL) {
                calculationString += carry;
            }


            hold=String.format("%.4f",calculationResult);
            if(hold.length()<=18)
            {
                txtResult.setText(hold);
            }else {
                txtResult.setText(String.valueOf(calculationResult));
            }       // instead of string.valueof use string.format
            numberRight="";
        }else
        {

            if(tapped==OPERATOR.EQUAL&&currentOperator==null)  // this is for :when multiple = button press
            {
                txtCalculation.setText(calculationString);
                txtResult.setText(calculationString);
            }else {
                if (tapped == OPERATOR.EQUAL)     // this is for :  3*/=
                    mathError();
                currentOperator=lateOperator;
            }

        }
    }



    //} else {

    // ye else part hai math error wala ka
           /* if (currentNumber == "") {
                if (tapped == OPERATOR.EQUAL) {
                    mathError();
                }


                numberLeft = String.valueOf(calculationResult);

            } else {
                numberLeft = currentNumber;

            }

            // }
            currentNumber = "";


            currentOperator = tapped; // aage shirf ye tha


        }*/

    private void clearIsTapped() {
        numberRight = "";
        numberLeft = "";
        currentNumber = "";
        calculationString = "";
        txtCalculation.setText("0");
        txtResult.setText("0");
        lateOperator=null;
        currentOperator = null;
        c=0;
        v=1;
        f=0;

    }

    private void mathError() {
        // ye hai math error didhane k liye

        txtResult.setText("Syntax Error");
        currentNumber = "";
        currentOperator = null;
        lateOperator=null;
        calculationString = "";
        txtCalculation.setText("0");
        numberRight = "";
        numberLeft = "";
        c=0;
        v=1;
        f=0;

    }



    private void delButton()
    {
        if(calculationString.length()!=0) {

            if (lateOperator == null) {
                if (currentNumber != "") {
                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                    calculationString = calculationString.substring(0, calculationString.length() - 1);

                }
            } else {
                if (lateOperator != null && currentNumber == "") {
                    if(f==1) {
                        calculationString = calculationString.substring(0, calculationString.length() - v);
                        v=1;

                    }else {
                        calculationString = calculationString.substring(0, calculationString.length() - 1);
                    }
                    txtResult.setText(calculationString);
                    c = 0;
                    lateOperator = null;
                    currentNumber = calculationString;

                } else {

                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);

                    if (currentNumber.length() == 0) {
                        currentNumber = "";
                    }

                    calculationString = calculationString.substring(0, calculationString.length() - 1);
                }
            }


            txtResult.setText(currentNumber);
        }else
        {
            clearIsTapped();
            Toast.makeText(getApplicationContext(),"nothing to delete",Toast.LENGTH_SHORT).show();
        }


    }



    // private void openSecondActivity() {
    //   Intent intent = new Intent(this, activity2.class);
    // startActivity(intent);

    //}

}
