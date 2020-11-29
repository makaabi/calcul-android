package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private Button btnsomme,btnsous,btnmultu,btndiv,btnvir,btnclear,btnresult;
    private TextView txt;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txt = (TextView) findViewById(R.id.textContent);


    btn1 = (Button) findViewById(R.id.button1);
    btn2 = (Button) findViewById(R.id.button2);
    btn3 = (Button) findViewById(R.id.button3);
    btn4 = (Button) findViewById(R.id.button4);
    btn5 = (Button) findViewById(R.id.button5);
    btn6 = (Button) findViewById(R.id.button6);
    btn7 = (Button) findViewById(R.id.button7);
    btn8 = (Button) findViewById(R.id.button8);
    btn9 = (Button) findViewById(R.id.button9);
    btn0 = (Button) findViewById(R.id.button0);
    btnclear = (Button) findViewById(R.id.buttonclear);
    btn1.setOnClickListener(new OnChiffreClick());
    btn2.setOnClickListener(new OnChiffreClick());
    btn3.setOnClickListener(new OnChiffreClick());
    btn4.setOnClickListener(new OnChiffreClick());
    btn5.setOnClickListener(new OnChiffreClick());
    btn6.setOnClickListener(new OnChiffreClick());
    btn7.setOnClickListener(new OnChiffreClick());
    btn8.setOnClickListener(new OnChiffreClick());
    btn9.setOnClickListener(new OnChiffreClick());
    btn0.setOnClickListener(new OnChiffreClick());

    btnclear.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            txt.setText("");
        }
    });
    btnsomme = (Button) findViewById(R.id.buttonsomme);
    btnsous = (Button) findViewById(R.id.buttonsub);
    btnmultu = (Button) findViewById(R.id.buttonmult);
    btndiv = (Button) findViewById(R.id.buttondiv);
    btnvir = (Button) findViewById(R.id.buttonvirg);
    btnsomme.setOnClickListener(new OperationClick());
    btnsous.setOnClickListener(new OperationClick());
    btnmultu.setOnClickListener(new OperationClick());
    btndiv.setOnClickListener(new OperationClick());
    btnvir.setOnClickListener(new OperationClick());

    btnresult = (Button) findViewById(R.id.buttonresult);
    btnresult.setOnClickListener(new View.OnClickListener() {
        private static final String TAG = "yay";

        public void onClick(View v) {
            String zonetxt = (String) txt.getText();
            String lastcharactere = zonetxt.substring(zonetxt.length() - 1);
            if (!lastcharactere.equals("+") && !lastcharactere.equals("-") && !lastcharactere.equals("*") && !lastcharactere.equals("/") && !lastcharactere.equals(".")) {
                String[] nombres = zonetxt.split("-|\\+|\\*|\\/");
                ArrayList<Character> operations = new ArrayList<Character>();
                for (Character c : zonetxt.toCharArray()) {
                    if (c == '+' || c == '-' || c == '*' || c == '/')
                        operations.add(c);

                }

                double res = Double.parseDouble(String.valueOf(nombres[0]));
                int i = 1;
                for (Character c : operations) {
                    double n = Double.parseDouble(String.valueOf(nombres[i]));
                    Log.i(TAG, String.valueOf(n));
                    Log.i(TAG, nombres[1]);
                    Log.i(TAG, zonetxt);
                    if (c == '+')
                        res += n;
                    else if (c == '-')
                        res -= n;
                    else if (c == '*')
                        res *= n;
                    else if (c == '/')
                        res /= n;
                    i++;
                }

                txt.setText(String.valueOf(res));
            }
        }
    });



}


    private class OnChiffreClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view==btn1)
            txt.setText(txt.getText()+"1");
            else if(view==btn2)
                txt.setText(txt.getText()+"2");
            else if(view==btn3)
                txt.setText(txt.getText()+"3");
            else if(view==btn4)
                txt.setText(txt.getText()+"4");
            else if(view==btn5)
                txt.setText(txt.getText()+"5");
            else if(view==btn6)
                txt.setText(txt.getText()+"6");
            else if(view==btn7)
                txt.setText(txt.getText()+"7");
            else if(view==btn8)
                txt.setText(txt.getText()+"8");
            else if(view==btn9)
                txt.setText(txt.getText()+"9");
            else if(view==btn0)
                txt.setText(txt.getText()+"0");
        }
    }

    private class OperationClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String zonetxt=(String) txt.getText();

            if (verifformat(zonetxt,view))
            {
                if(view==btnsomme)
                    txt.setText(txt.getText()+"+");
                else if(view==btnsous)
                    txt.setText(txt.getText()+"-");
                else if(view==btnmultu)
                    txt.setText(txt.getText()+"*");
                else if(view==btndiv)
                    txt.setText(txt.getText()+"/");
                else if(view==btnvir)
                    txt.setText(txt.getText()+".");

        }
    }

        private boolean verifformat(String zonetxt, View view) {
            String lastcharactere= zonetxt.substring(zonetxt.length() - 1);
            String [] zonearray=zonetxt.split("");
            String lastchar="";
            Boolean test=(!lastcharactere.equals("+") && !lastcharactere.equals("-") && !lastcharactere.equals("*") && !lastcharactere.equals("/")&& !lastcharactere.equals("."));
            if(view==btnvir){
                int i=zonearray.length-1;
                while(i>0 && test){
                    if(zonearray[i].equals("+") || zonearray[i].equals("-") || zonearray[i].equals("*") || zonearray[i].equals("/") ||zonearray[i].equals(".")){
                        lastchar=zonearray[i];
                    }
                    if(lastchar.equals("."))
                        test=false;
                    i--;
                }

            }
            return test;
        }

}
}