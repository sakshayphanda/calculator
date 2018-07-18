package com.howtechworx.www.basiccalculator;

import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final long SHOWCASE_ID = 1;
    private float mValueOne, mValueThree;
    private float add, sub, div, mul;
    private EditText finalRes, inputNo, first, operation;
    private boolean lastDot;
    private GridView drawer_list;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonEqual;
    private Button button10;
    private Button buttonAdd;
    private Button buttonSub;
    private Button buttonMul;
    private Button buttonDivision;
    private float pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.list_item
                , new String[]{"π"});
        drawer_list.setAdapter(adapter);
        drawer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             /*   if(i==0)
                {
                    inputNo.setText(String.format("%s(", inputNo.getText()));
                }
                if(i==1)
                {
                    inputNo.setText(String.format("%s)", inputNo.getText()));
                }
             */
                if (i == 0) {
                    if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
                    } else if (finalRes.getText().toString().isEmpty()) {
                        String num = inputNo.getText().toString();
                        float no = Float.parseFloat(num);
                        pi = (float) (no * Math.PI);
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", pi));
                    } else {
                        String num = finalRes.getText().toString();
                        float no = Float.parseFloat(num);
                        pi = (float) (no * Math.PI);
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", pi));

                    }
                }
            }
        });

        showShowCaseView();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s1", inputNo.getText()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s2", inputNo.getText()));

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s3", inputNo.getText()));

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s4", inputNo.getText()));

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s5", inputNo.getText()));

            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s6", inputNo.getText()));

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s%s", inputNo.getText(), getString(R.string.seven)));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s8", inputNo.getText()));

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s9", inputNo.getText()));

            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNo.setText(String.format("%s0", inputNo.getText()));

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
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operationSym = operation.getText().toString();

                if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty() || inputNo.getText().toString().equals(".")) {
                    Toast.makeText(MainActivity.this, "Input is missing", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (operationSym.equals("+")) {
                    if (!first.getText().toString().isEmpty() && inputNo.getText().toString().isEmpty() && !finalRes.getText().toString().isEmpty()) {
                        finalRes.setText(first.getText().toString());
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        String no_one = first.getText().toString();
                        String no_two = inputNo.getText().toString();
                        float number_one = Float.parseFloat(no_one);
                        float number_two = Float.parseFloat(no_two);
                        add = number_one + number_two;
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", add));
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                        // first.setText(String.format("%.2f", add));
                        inputNo.setText("");
                        operation.setText("");
                        }
                }
                if (operationSym.equals("-")) {
                    if (!first.getText().toString().isEmpty() && inputNo.getText().toString().isEmpty() && !finalRes.getText().toString().isEmpty()) {
                        finalRes.setText(first.getText().toString());
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        String no_one = first.getText().toString();
                        String no_two = inputNo.getText().toString();
                        float number_one = Float.parseFloat(no_one);
                        float number_two = Float.parseFloat(no_two);
                        sub = number_one - number_two;
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", sub));
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                        // first.setText(String.format("%.2f", sub));
                        inputNo.setText("");
                        operation.setText("");

                    }
                }
                if (operationSym.equals("x")) {
                    if (!first.getText().toString().isEmpty() && inputNo.getText().toString().isEmpty() && !finalRes.getText().toString().isEmpty()) {
                        finalRes.setText(first.getText().toString());
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        String no_one = first.getText().toString();
                        String no_two = inputNo.getText().toString();
                        float number_one = Float.parseFloat(no_one);
                        float number_two = Float.parseFloat(no_two);
                        mul = number_one * number_two;
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", mul));
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                        // first.setText(String.format("%.2f", mul));
                        inputNo.setText("");
                        operation.setText("");

                    }
                }

                if (operationSym.equals("/")) {
                    if (!first.getText().toString().isEmpty() && inputNo.getText().toString().isEmpty() && !finalRes.getText().toString().isEmpty()) {
                        finalRes.setText(first.getText().toString());
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                    } else {
                        String no_one = first.getText().toString();
                        String no_two = inputNo.getText().toString();
                        float number_one = Float.parseFloat(no_one);
                        float number_two = Float.parseFloat(no_two);
                        div = number_one / number_two;
                        finalRes.setText(String.format(Locale.getDefault(), "%.2f", div));
                        finalRes.setTypeface(null, Typeface.BOLD_ITALIC);
                        // first.setText(String.format("%.2f", sub));
                        inputNo.setText("");
                        operation.setText("");

                    }
                }

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastDot = false;
                if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
                } else if ((!finalRes.getText().toString().isEmpty() && !first.getText().toString().isEmpty() && !inputNo.getText().toString().isEmpty())) {
                    first.setText(finalRes.getText().toString());
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    add = number_one + number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", add));
                    first.setText(String.format(Locale.getDefault(), "%.2f", add));
                    inputNo.setText("");

                } else if (finalRes.getText().toString().equals("") && first.getText().toString().equals("")) {
                    String input = inputNo.getText().toString();
                    inputNo.setText("");
                    first.setText(input);
                    operation.setText("+");
                } else if (finalRes.getText().toString().equals("")) {
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    add = number_one + number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", add));
                    first.setText(String.format(Locale.getDefault(), "%.2f", add));
                    inputNo.setText("");
                } else {
                    operation.setText("+");
                    inputNo.setText("");
                    first.setText(finalRes.getText().toString());
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {//correct
            @Override
            public void onClick(View v) {
                lastDot = false;
                if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
                } else if ((!finalRes.getText().toString().isEmpty() && !first.getText().toString().isEmpty() &&
                        !inputNo.getText().toString().isEmpty())) {
                    first.setText(finalRes.getText().toString());
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    sub = number_one - number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", sub));
                    first.setText(String.format(Locale.getDefault(), "%.2f", sub));
                    inputNo.setText("");

                } else if (finalRes.getText().toString().equals("") && first.getText().toString().equals("")) {
                    String input = inputNo.getText().toString();
                    inputNo.setText("");
                    first.setText(input);
                    operation.setText("-");
                } else if (finalRes.getText().toString().equals("")) {
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    sub = number_one - number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", sub));
                    first.setText(String.format(Locale.getDefault(), "%.2f", sub));
                    inputNo.setText("");
                } else {
                    operation.setText("-");
                    inputNo.setText("");
                    first.setText(finalRes.getText().toString());
                }

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener()//correct
        {
            @Override
            public void onClick(View v) {
                lastDot = false;
                if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
                } else if ((!finalRes.getText().toString().isEmpty() && !first.getText().toString().isEmpty() && !inputNo.getText().toString().isEmpty())) {
                    first.setText(finalRes.getText().toString());
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    mul = number_one * number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", mul));
                    first.setText(String.format(Locale.getDefault(), "%.2f", mul));
                    inputNo.setText("");

                } else if (finalRes.getText().toString().equals("") && first.getText().toString().equals("")) {
                    String input = inputNo.getText().toString();
                    inputNo.setText("");
                    first.setText(input);
                    operation.setText("x");
                } else if (finalRes.getText().toString().equals("")) {
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    mul = number_one * number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", mul));
                    first.setText(String.format(Locale.getDefault(), "%.2f", mul));
                    inputNo.setText("");
                } else {
                    operation.setText("x");
                    inputNo.setText("");
                    first.setText(finalRes.getText().toString());
                }

            }
        });


        buttonDivision.setOnClickListener(new View.OnClickListener() {//correct
            @Override
            public void onClick(View v) {
                lastDot = false;
                if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
                } else if ((!finalRes.getText().toString().isEmpty() && !first.getText().toString().isEmpty() && !inputNo.getText().toString().isEmpty())) {
                    first.setText(finalRes.getText().toString());
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    div = number_one / number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", div));
                    first.setText(String.format(Locale.getDefault(), "%.2f", div));
                    inputNo.setText("");

                } else if (finalRes.getText().toString().equals("") && first.getText().toString().equals("")) {
                    String input = inputNo.getText().toString();
                    inputNo.setText("");
                    first.setText(input);
                    operation.setText("/");
                } else if (finalRes.getText().toString().equals("")) {
                    String no_one = first.getText().toString();
                    String no_two = inputNo.getText().toString();
                    float number_one = Float.parseFloat(no_one);
                    float number_two = Float.parseFloat(no_two);
                    div = number_one / number_two;
                    finalRes.setTypeface(null, Typeface.NORMAL);
                    finalRes.setText(String.format(Locale.getDefault(), "%.2f", div));
                    first.setText(String.format(Locale.getDefault(), "%.2f", div));
                    inputNo.setText("");
                } else {
                    operation.setText("/");
                    inputNo.setText("");
                    first.setText(finalRes.getText().toString());
                }

            }
        });
    }

    private void initUI() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        buttonAdd = findViewById(R.id.buttonadd);
        buttonSub = findViewById(R.id.buttonsub);
        buttonMul = findViewById(R.id.buttonmul);
        buttonDivision = findViewById(R.id.buttondiv);
        buttonEqual = findViewById(R.id.buttoneql);
        inputNo = findViewById(R.id.input);
        finalRes = findViewById(R.id.finalResult);
        first = findViewById(R.id.first);
        operation = findViewById(R.id.operation);
        drawer_list = findViewById(R.id.drawer_list);
    }

    public void showShowCaseView() {
        ShowcaseView.Builder showCaseView = new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(new ViewTarget(R.id.buttonadd, this))
                .setContentTitle("Operation Button")
                .setContentText("Click the operation button only after entering a number")
                .setStyle(R.style.ShowCaseViewStyle)
                .singleShot(SHOWCASE_ID)
                .setShowcaseEventListener(new OnShowcaseEventListener() {
                    @Override
                    public void onShowcaseViewHide(ShowcaseView showcaseView) {

                        Snackbar.make(showcaseView, "Welcome user", Snackbar.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                    }
                });
        showCaseView.build();
    }

    public void squ(View view)

    {
        if (finalRes.getText().toString().isEmpty()) {
            try {
                operation.setText("");
                lastDot = false;
                String a = inputNo.getText().toString();
                mValueOne = Float.parseFloat(a);

                mValueThree = mValueOne * mValueOne;
                inputNo.setText(String.format("%s²", inputNo.getText()));
                finalRes.setText(String.format(Locale.getDefault(), "%.2f", mValueThree));
            } catch (Exception ex) {

                Log.d("---", ex.getMessage());
            }
        } else {
            inputNo.setText(finalRes.getText());
            String a = inputNo.getText().toString();
            mValueOne = Float.parseFloat(a);

            mValueThree = mValueOne * mValueOne;
            inputNo.setText(String.format("%s²", inputNo.getText()));
            finalRes.setText(String.format(Locale.getDefault(), "%.2f", mValueThree));
        }
    }


    public void clear(View view) {
        first.getText().clear();
        lastDot = false;
        first.setHint("");
        operation.getText().clear();
        operation.setHint("");
        inputNo.getText().clear();
        finalRes.getText().clear();

    }

    public void back(View v) {
        lastDot = false;
        String textInBox = inputNo.getText().toString();
        if (inputNo.length() > 0) {
            String newText = textInBox.substring(0, textInBox.length() - 1);
            inputNo.setText(newText);
        }
    }

    public void cubeRoot(View view) {
        {
            if (inputNo.getText().toString().isEmpty() && finalRes.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Input something", Toast.LENGTH_SHORT).show();
            } else if (finalRes.getText().toString().isEmpty()) {
                operation.setText("");
                lastDot = false;
                String a = inputNo.getText().toString();
                mValueOne = Float.parseFloat(a);

                mValueThree = (float) Math.sqrt(mValueOne);
                inputNo.setText(String.format("√%s", inputNo.getText()));
                finalRes.setText(String.format(Locale.getDefault(), "%.2f", mValueThree));
            } else {
                inputNo.setText(finalRes.getText());
                String a = inputNo.getText().toString();
                mValueOne = Float.parseFloat(a);

                mValueThree = (float) Math.sqrt(mValueOne);
                inputNo.setText(String.format("√%s", inputNo.getText()));
                finalRes.setText(String.format(Locale.getDefault(), "%.2f", mValueThree));
            }
        }

    }
}