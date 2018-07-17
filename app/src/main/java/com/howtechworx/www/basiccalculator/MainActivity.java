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
    private String display1;
    private String display;
    private float add,sub,div,mul;
    private EditText finalRes ,inputNo,first,operation;
    private float result;
    private boolean lastDot;
    private ShowcaseView.Builder showCaseView ;
    private ListView drawer_list;
    private String number;
    private int res;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);
        Button buttonAdd = (Button) findViewById(R.id.buttonadd);
        Button buttonSub = (Button) findViewById(R.id.buttonsub);
        Button buttonMul = (Button) findViewById(R.id.buttonmul);
        Button buttonDivision = (Button) findViewById(R.id.buttondiv);
        Button buttonEqual = (Button) findViewById(R.id.buttoneql);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        inputNo = (EditText) findViewById(R.id.result);
        finalRes = (EditText) findViewById(R.id.finalResult);
        first = (EditText) findViewById(R.id.first);
        operation = (EditText) findViewById(R.id.operation);
        drawer_list = (ListView) findViewById(R.id.drawer_list);
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

       /* buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(inputNo.getText()+".");
            }
        });
    }
}*/

/*
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
*/
/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;*//*


import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity
{
    EditText et,et1;
    ImageButton backButton;
    EditText result;
    String display,display1;
    ShowcaseView.Builder showCaseView;
    final int SHOWCASE_ID = 1;
  // private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.first);
        et1 = (EditText) findViewById(R.id.second);
       result = (EditText) findViewById(R.id.result);
        display="";
        display1="";
        showShowCaseView();
        backButton = (ImageButton) findViewById(R.id.back);
        backButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(et.isFocused())
                {
                    et.getText().clear();
                    display = et.getText().toString();
                }
               else if(et1.isFocused())
                {
                    et1.getText().clear();
                    display1 = et1.getText().toString();
                }
                return false;
            }
        });
      */
/* mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("BA44AD8470C705244173466DA7A32EB0")
                .build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, "ca-app-pub-7821588853671571/3337984846");
*//*


    }

    public void showShowCaseView()
    {
        showCaseView = new ShowcaseView.Builder(this)
        .withMaterialShowcase()
                .setTarget(new ViewTarget(R.id.add,this))
                .setContentTitle("Add")
                .setContentText("Click the operation button only after entering 2 numbers")
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


    public void add(View view)
    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '+'" + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y  before pressing '+'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing '+'" + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '+'" + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            } else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
                double y = Double.parseDouble(s1);
                double z = x + y;
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    //result.setText("" + z);
                    //et.setText(""+z);
                    result.setText(String.format("%.2f", z));//upto 2 decimal places
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    et1.setHint("0");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }

    public void sub(View view)

    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '-'" + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing '-'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing '-'" + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '-'" + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            } else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
                double y = Double.parseDouble(s1);
                double z = x - y;
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    //result.setText("" + z);
                    //et.setText(""+z);
                    result.setText(String.format("%.2f", z));//upto 2 decimal places
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    et1.setHint("0");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }
    //to perform no operation
   */
/* public void sub(View view) {
        try {
            String s = et.getText().toString();
            String s1 = et1.getText().toString();
            double x = Integer.parseInt(s);
            double y = Integer.parseInt(s1);
            double z = x - y;
            result.setText("" + z);
        }
        catch (Exception ex)
        {}
    }
*//*

    public void mul(View view)

    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'x'" + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing 'x'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing 'x'" + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'x'" + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            } else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                BigDecimal x = new BigDecimal(s);
                BigDecimal y = new BigDecimal(s1);
                BigDecimal z = x.multiply(y);
                //result.setText("" + z);
                //et.setText(""+z);
                int res = z.compareTo(BigDecimal.valueOf(999999999));
                if (res == 1) {
                    result.setText("E");

                } else {
                    result.setText(String.format("%.2f", z));//upto 2 decimal places
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    et1.setHint("0");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }
    public void div(View view)

    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '÷'" + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing '÷'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing '÷'" + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing '÷'" + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            } else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
                double y = Double.parseDouble(s1);
                double z = x / y;
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    //result.setText("" + z);
                    //et.setText(""+z);
                    result.setText(String.format("%.2f", z));//upto 2 decimal places
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    et1.setHint("0");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }
    public void mod(View view)

    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'mod'" + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing 'mod'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter Y before pressing 'mod'" + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'mod'" + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            } else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
                double y = Double.parseDouble(s1);
                double z = x % y;
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    //result.setText("" + z);
                    //et.setText(""+z);
                    result.setText(String.format("%.2f", z));
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    et1.setHint("0");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }

    public void squ(View view)

    {
        try {
            et1.getText().clear();
            et1.setHint("");
            et1.clearFocus();
            if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'x²'" + "</small></small>"));
                et.setHintTextColor(Color.RED);
            }
            else if (et1.isFocused()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter X before pressing 'x²'" + "</small></small>"));
                et1.setHintTextColor(Color.RED);

            }
            else {
                String s = et.getText().toString();
             //   String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
               // double y = Double.parseDouble(s1);
                double z = x * x;
                //result.setText("" + z);
                //et.setText(""+z);
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    result.setText(""+z);//upto 2 decimal places
                    et.setText(""+z);
                    et1.getText().clear();
                    display1 = "";
                    display = et.getText().toString();
                    et1.setHint("");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
          //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }

    public void pow(View view)

    {
        try {
            if (et1.getText().toString().isEmpty() && et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter 'x' before pressing 'xⁿ' " + "</small></small>"));
                et1.setHint(Html.fromHtml("<small><small>" + "Enter 'ⁿ' before pressing 'xⁿ' " + "</small></small>"));
                et.setHintTextColor(Color.RED);
                et1.setHintTextColor(Color.RED);
            } else if (et1.getText().toString().isEmpty()) {
                et1.setHint(Html.fromHtml("<small><small>" + "Enter 'ⁿ' before pressing 'Xⁿ' " + "</small></small>"));
                et1.requestFocus();//changes the focus from edittext to edittext 1
                et1.setHintTextColor(Color.RED);
            } else if (et.getText().toString().isEmpty()) {
                et.setHint(Html.fromHtml("<small><small>" + "Enter 'X' before pressing 'Xⁿ' " + "</small></small>"));
                et.requestFocus();//changes the focus from edit text 1 to edittext
                et.setHintTextColor(Color.RED);
                //  et.setHintTextColor(getResources().getColor(R.color.error));
            }
            else {
                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                double x = Double.parseDouble(s);
                double n = Double.parseDouble(s1);
                double z = Math.pow(x,n);
                //result.setText("" + z);
                //et.setText(""+z);
                if (z > 999999999) {
                    result.setText("E");

                } else {
                    result.setText(String.format("%.2f", z));
                    et.setText(String.format("%.2f", z));
                    et1.getText().clear();
                    display1 = "";
                    display = et.getText().toString();
                    et1.setHint("Power");
                    et1.setHintTextColor(getResources().getColor(R.color.hint));
                }
            }
        }
        catch (Exception ex)
        {
            //  result.setText(Html.fromHtml(("<small><small>"+"Invalid Input!"+"</small></small>")));
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }
   public void number(View view) {
       if (et.isFocused()) {
           Button button = (Button) view;
           display += button.getText().toString();
           et.setText(display);
       }
       if (et1.isFocused())
       {
           Button button = (Button) view;
           display1 += button.getText().toString();
           et1.setText(display1);
       }

   }
   public void enter(View view) {
       if (et.isFocused()) {
           et1.requestFocus();
       }
       else if(et1.isFocused())
       {
           et.requestFocus();
       }
   }

   public void back(View v) {
       String textInBox = et.getText().toString();
       String textInBox1 = et1.getText().toString();
       if(et.isFocused()) {
           if (et.length() > 0) {
               //Remove last character//
               String newText = textInBox.substring(0, textInBox.length() - 1);
               // Update edit text
               et.setText(newText);
               display = et.getText().toString();
           }
       }
       else if (et1.isFocused())
       {
           if (et1.length() > 0) {
           //Remove last character//
           String newText = textInBox1.substring(0, textInBox1.length() - 1);
           // Update edit text
           et1.setText(newText);
           display1 = et1.getText().toString();
       }
   }}
    public void clear(View view)
    {
        et.getText().clear();
        et1.getText().clear();
        et.setHint("Enter X");
        et1.setHint("Enter Y");
        et.setHintTextColor(getResources().getColor(R.color.hint));
        et1.setHintTextColor(getResources().getColor(R.color.hint));
        result.getText().clear();
        display= "";
        display1 ="";
        et.requestFocus();
    }
}
*/
