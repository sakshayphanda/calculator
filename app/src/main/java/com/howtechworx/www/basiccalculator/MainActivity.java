package com.howtechworx.www.basiccalculator;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class MainActivity extends AppCompatActivity
{

    private static final long SHOWCASE_ID =1 ;
    private float mValueOne , mValueTwo ,mValueThree;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision;
    private float add,sub,div,mul;
    private EditText finalRes ,inputNo,first,operation;
    private float result;
    private boolean lastDot;
    private ShowcaseView.Builder showCaseView ;
    private ListView drawer_list;
    private String number;
    private int res;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private Button buttonEqual;
    private Button back;
    private Button button10;
    private Button buttonAdd;
    private Button buttonSub;
    private Button buttonMul;
    private Button buttonDivision;
    private String display,display1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1
                , new String[]{"dummy", "dummy", "dummy", "dummy", "dummy", "dummy"});
        drawer_list.setAdapter(adapter);

        showShowCaseView();
        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                    inputNo.getText().clear();
                return true;
            }
        });


        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "2");

            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "3");

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "4");

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "5");

            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "6");

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "7");

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "8");

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "9");

            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText() + "0");

            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!lastDot) {
                    inputNo.append(".");
                    lastDot = true;
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//correct
                try {
                    finalRes.getText().clear();
                    finalRes.setText("");
                    operation.setText("");
                    String a = inputNo.getText().toString();
                    lastDot = false;
                    if (first.getText().toString().isEmpty()) {
                        mValueThree = 0;
                    } else {
                        String b = first.getText().toString();
                        mValueThree = Float.parseFloat(b);
                    }
                    mValueOne = Float.parseFloat(a);
                    result = mValueThree + mValueOne;
                    number = String.valueOf(result);
                    number = number.substring(number.indexOf(".")).substring(1);
                    int num = Integer.parseInt(number);
                    if(num >0) {
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("+");
                        mAddition = true;
                        mDivision = false;
                        mSubtract = false;
                        mMultiplication = false;
                    }
                    else
                    {
                        first.setText(String.format("%.0f", result));
                        inputNo.setText(null);
                        operation.setText("+");
                        mAddition = true;
                        mDivision = false;
                        mSubtract = false;
                        mMultiplication = false;
                    }
                } catch (Exception ex) {

                }
            }

        });

        buttonSub.setOnClickListener(new View.OnClickListener() {//correct
            @Override
            public void onClick(View v) {
                try {
                    finalRes.getText().clear();
                    finalRes.setText("");
                    operation.setText("");

                    String a = inputNo.getText().toString();
                    lastDot = false;
                    if (first.getText().toString().isEmpty()) {
                        mValueThree = 0;
                        mValueOne = Float.parseFloat(a);
                        result = mValueOne - mValueThree;
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("-");
                        mSubtract = true;
                        mAddition = false;
                        mDivision= false;
                        mMultiplication=false;



                    } else {
                        String b = first.getText().toString();
                        mValueThree = Float.parseFloat(b);
                        mValueOne = Float.parseFloat(a);
                        result = mValueThree - mValueOne;
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("-");
                        mSubtract = true;
                        mAddition = false;
                        mDivision= false;
                        mMultiplication=false;

                    }

                } catch (Exception ignored) {

                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener()//correct
        {
            @Override
            public void onClick(View v) {
                try {
                    finalRes.getText().clear();
                    finalRes.setText("");
                    operation.setText("");

                    String a = inputNo.getText().toString();
                    lastDot = false;

                    if (first.getText().toString().isEmpty())
                    {
                        mValueThree = 1;
                        mValueOne = Float.parseFloat(a);
                        result = mValueOne;
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("x");
                        mMultiplication = true;
                        mAddition = false;
                        mDivision= false;
                        mSubtract=false;
                        ;

                    } else {
                        String b = first.getText().toString();
                        mValueThree = Float.parseFloat(b);
                        mValueOne = Float.parseFloat(a);
                        result = mValueThree * mValueOne;
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("x");
                        mMultiplication = true;
                        mAddition = false;
                        mDivision= false;
                        mSubtract=false;
                        ;

                    }

                } catch (Exception ignored) {
                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {//correct
            @Override
            public void onClick(View v) {
                try {
                    finalRes.getText().clear();
                    finalRes.setText("");
                    operation.setText("");

                    String a = inputNo.getText().toString();
                    lastDot = false;
                    if (first.getText().toString().isEmpty()) {
                        mValueThree = 1;
                        mValueOne = Float.parseFloat(a);
                        result = mValueOne;
                        first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("÷");
                        mDivision = true;
                        mAddition = false;
                        mSubtract=false;
                        mMultiplication=false;
                        ;
                    } else
                        {
                        String b = first.getText().toString();
                        mValueThree = Float.parseFloat(b);
                        mValueOne = Float.parseFloat(a);
                        result = mValueThree / mValueOne;
                            first.setText(String.format("%.2f", result));
                        inputNo.setText(null);
                        operation.setText("÷");
                        mDivision = true;
                            mAddition = false;
                            mSubtract=false;
                            mMultiplication=false;
                            ;
                    }
                } catch (Exception ignored)
                {

                }
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                String d = first.getText().toString();
                mValueThree = Float.parseFloat(d);
                finalRes.setText(String.format("%.2f", mValueThree));
                 }
                catch (Exception e)
                {

                }

                try {

                    mValueTwo = Float.parseFloat(inputNo.getText() + "");
                    operation.setText("");

                    if (mAddition) {
                        String a  = first.getText().toString();
                        mValueThree = Float.parseFloat(a);
                        String b  = inputNo.getText().toString();
                        mValueTwo = Float.parseFloat(b);
                        add = mValueThree + mValueTwo;
                        finalRes.setText(String.format("%.2f", add));
                        first.setText(String.format("%.2f", add));
                        inputNo.setText("");
                        mAddition = false;

                    } else if (mSubtract)
                    {
                        if(mValueThree != 0)
                        {
                            String a  = first.getText().toString();
                            mValueThree = Float.parseFloat(a);
                            String b  = inputNo.getText().toString();
                            mValueTwo = Float.parseFloat(b);
                            String c  = inputNo.getText().toString();
                            mValueOne = Float.parseFloat(c);
                            sub = mValueThree-mValueTwo;
                            finalRes.setText(String.format("%.2f", sub));
                            first.setText(String.format("%.2f", sub));
                            inputNo.setText("");
                            mSubtract = false;
                        }
                        else
                        {
                            sub = mValueOne - mValueTwo;
                            finalRes.setText(String.format("%.2f", sub));
                            first.setText(String.format("%.2f", sub));
                            inputNo.setText("");
                            mSubtract = false;

                        }
                    } else if (mMultiplication) {
                        String a  = first.getText().toString();
                        mValueThree = Float.parseFloat(a);
                        String b  = inputNo.getText().toString();
                        mValueTwo = Float.parseFloat(b);
                        String c  = inputNo.getText().toString();
                        mValueOne = Float.parseFloat(c);
                        mul = mValueThree * mValueTwo;
                        finalRes.setText(String.format("%.2f", mul));
                        first.setText(String.format("%.2f", mul));
                        inputNo.setText("");
                        mMultiplication = false;
                    } else if (mDivision) {
                        if (mValueThree != 1) {
                            String a = first.getText().toString();
                            mValueThree = Float.parseFloat(a);
                            String b = inputNo.getText().toString();
                            mValueTwo = Float.parseFloat(b);
                            String c = inputNo.getText().toString();
                            mValueOne = Float.parseFloat(c);
                            div = mValueThree / mValueTwo;
                            finalRes.setText(String.format("%.2f", div));
                            first.setText(String.format("%.2f", div));
                            inputNo.setText("");
                            mDivision = false;
                        } else {
                            String a = first.getText().toString();
                            mValueThree = Float.parseFloat(a);
                            String b = inputNo.getText().toString();
                            mValueTwo = Float.parseFloat(b);
                            String c = inputNo.getText().toString();
                            mValueOne = Float.parseFloat(c);
                            div = mValueOne / mValueTwo;
                            finalRes.setText(String.format("%.2f", div));
                            first.setText(String.format("%.2f", div));
                            inputNo.setText("");
                            mDivision = false;
                        }
                    }
                }
                catch (Exception ignored)
                {
                    lastDot=true;
                }
            }
            });
        }

    private void initUI() {
         button0 = (Button) findViewById(R.id.button0);
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);
         button4 = (Button) findViewById(R.id.button4);
         button5 = (Button) findViewById(R.id.button5);
         button6 = (Button) findViewById(R.id.button6);
         button7 = (Button) findViewById(R.id.button7);
         button8 = (Button) findViewById(R.id.button8);
         button9 = (Button) findViewById(R.id.button9);
         button10 = (Button) findViewById(R.id.button10);
         buttonAdd = (Button) findViewById(R.id.buttonadd);
         buttonSub = (Button) findViewById(R.id.buttonsub);
         buttonMul = (Button) findViewById(R.id.buttonmul);
         buttonDivision = (Button) findViewById(R.id.buttondiv);
         buttonEqual = (Button) findViewById(R.id.buttoneql);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        inputNo = (EditText) findViewById(R.id.result);
        finalRes = (EditText) findViewById(R.id.finalResult);
        first = (EditText) findViewById(R.id.first);
        operation = (EditText) findViewById(R.id.operation);
        drawer_list = (ListView) findViewById(R.id.drawer_list);
    }

    public void showShowCaseView()
    {
        showCaseView = new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(new ViewTarget(R.id.buttonadd,this))
                .setContentTitle("Operation Button")
                .setContentText("Click the operation button only after entering a number")
                .setStyle(R.style.ShowCaseViewStyle)
                .singleShot(SHOWCASE_ID)
                .setShowcaseEventListener(new OnShowcaseEventListener()
                {@Override
                public void onShowcaseViewHide(ShowcaseView showcaseView) {

                    Snackbar.make(showcaseView,"Welcome user",Snackbar.LENGTH_SHORT).show();
                }

                    @Override
                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                    }});
        showCaseView.build();
    }

    public void squ(View view)

    {
        finalRes.getText().clear();
        finalRes.setText("");
        try {

            operation.setText("x²");
            lastDot=false;
                String a = inputNo.getText().toString();
                mValueOne = Float.parseFloat(a);

            mValueThree = mValueOne * mValueOne;
            finalRes.setText(String.format("%.2f", mValueThree));
            first.setText(String.format("%.2f", mValueThree));
            }
            catch (Exception ex)
            {

            }
        }


    public void clear(View view)//correct
    {
        first.getText().clear();
        lastDot=false;
        first.setHint("");
        operation.getText().clear();
        operation.setHint("");
        inputNo.getText().clear();
        finalRes.getText().clear();
        display = "";
        display1 = "";
    }
    public void back(View v) {//correct
        lastDot=false;
        String textInBox = inputNo.getText().toString();
            if (inputNo.length() > 0) {
                //Remove last character//
                String newText = textInBox.substring(0, textInBox.length() - 1);
                // Update edit text
                inputNo.setText(newText);
                display = inputNo.getText().toString();
            }
        }

    public void cubeRoot(View view) {
        {
            finalRes.getText().clear();
            finalRes.setText("");
            try {
                lastDot=false;
                String a = inputNo.getText().toString();
                mValueOne = Float.parseFloat(a);
                mValueThree = (float) Math.sqrt(mValueOne);
/*
                mValueThree = mValueOne * mValueOne * mValueOne;
*/
                finalRes.setText(String.format("%.2f", mValueThree));
                first.setText(String.format("%.2f", mValueThree));
            }
            catch (Exception ex)
            {

            }
        }

    }
}