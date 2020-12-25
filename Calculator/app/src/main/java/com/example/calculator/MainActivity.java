package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button c,power,back,div,mul,plus,minus,zero,one,two,three,four,five,six,seven,eight,nine,equal,dot,ans;
    private  String input,output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        c=findViewById(R.id.C);
        power=findViewById(R.id.power);
        //
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        //
        back=findViewById(R.id.back);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.multip);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        equal=findViewById(R.id.equal);
        dot=findViewById(R.id.dot);
        ans=findViewById(R.id.ans);
    }
    public void buttonClick(View view)
    {
        Button button=(Button)view;
        String data=button.getText().toString();
        switch (data)
        {
            case "C":
                input="";
                break;

            case "ans":

                input+=output;
                break;

            case "=":
                solve();
                output=input;
                break;

            case "+":
                solve();
                input+="+";
                break;

            case "X":
                solve();
                input+="*";
                break;
            case "/":
                solve();
                input+="/";
                break;
            case "^":
                solve();
                input+="^";
                break;
            case"del":
                String nText=input.substring(0,input.length()-1 );
                input=nText;
                break;
            default:
                if(input==null)
                {
                    input="";
                }
                if(data.equals("+")||data.equals("-")||data.equals("/"))
                {
                    solve();
                }
                input+=data;
                break;
        }
        Screen.setText(input);
    }

    private void solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul + "";
            } catch (Exception e) {

            }
        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {

            }
        } else if (input.split("^").length == 2) {
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\-").length > 1) {
            String number[] = input.split("\\-");
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            } catch (Exception e) {

            }
            String n[] = input.split("\\.");
            if (n.length > 1) {
                if (n[1].equals("0")) {
                    input = n[0];
                }
            }
        }
        Screen.setText(input);
    }
}