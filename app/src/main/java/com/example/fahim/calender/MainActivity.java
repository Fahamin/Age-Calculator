package com.example.fahim.calender;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.util.Calendar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int sys_y, sys_m, sys_d;
    int iday, iyear, imonth, c, d, e, f, g;
    String sy, sm, sd;
    TextView t2;
    TextView t3;
    TextView t4;
    EditText e1;
    EditText e2;
    EditText e3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1 = (EditText) findViewById(R.id.editText2);
        e2 = (EditText) findViewById(R.id.editText3);
        e3 = (EditText) findViewById(R.id.editText4);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);

        Calendar cal = Calendar.getInstance();

        sys_y = cal.get(Calendar.YEAR);
        sys_m = cal.get(Calendar.MONTH);
        sys_d = cal.get(Calendar.DAY_OF_MONTH);

    }

    public void calculator(View view) {

        if (view.getId() == R.id.button) {

            iday = Integer.parseInt(e3.getText().toString());
            imonth = Integer.parseInt(e2.getText().toString());
            iyear = Integer.parseInt(e1.getText().toString());

            if (iday > 31 || imonth > 12)
                {
                    AlertDialog.Builder ab = new AlertDialog.Builder(this);
                    ab.setTitle("Warrning!!You Pass the Incorrect value!");
                    ab.setMessage("Are You Exit Here!");
                    ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Terminate!!",
                                Toast.LENGTH_LONG).show();
                                finish();
                            System.exit(1);
                        }
                    });
                     ab.setNegativeButton("No",null);
                     ab.create();
                     ab.show();


                }
            c=sys_d - iday;

            if(c<0)
                {
                    sys_d+=30;
                    d=sys_d-iday;
                    sd = String.valueOf(d);
                    t4.setText(sd);
                    imonth+=1;
                }
            else if(c==0)
                {
                    sd = String.valueOf(c);
                    t4.setText(sd);
                }
            else
                {
                    sd = String.valueOf(c);
                    t4.setText(sd);
                }

            e =(sys_m+1)-imonth;

            if(e<0)
                {
                    sys_m=(sys_m+1)+11;
                    f=(sys_m+1)-imonth;
                    sm = String.valueOf(f);
                    t3.setText(sm);
                    iyear+=1;
                }
            else if(e==0)
                {
                    sm = String.valueOf(e);
                    t3.setText(sm);
                }
            else
                {
                    sm = String.valueOf(e);
                    t3.setText(sm);
                }

                g=sys_y - iyear;

                    if(g==0)
                    {
                        sy = String.valueOf(g);
                        t2.setText(sy);
                    }
                        else
                        {
                            sy = String.valueOf(g);
                            t2.setText(sy);
                        }

            Toast.makeText(MainActivity.this,"See your age!!",
                    Toast.LENGTH_LONG).show();
        }
    }
}