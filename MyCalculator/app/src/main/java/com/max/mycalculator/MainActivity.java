package com.max.mycalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double n;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView screen=findViewById(R.id.output);

        Button num0=findViewById(R.id.no_0);
        Button num00=findViewById(R.id.zeros);
        Button num1=findViewById(R.id.no_1);
        Button num2=findViewById(R.id.no_2);
        Button num3=findViewById(R.id.no_3);
        Button num4=findViewById(R.id.no_4);
        Button num5=findViewById(R.id.no_5);
        Button num6=findViewById(R.id.no_6);
        Button num7=findViewById(R.id.no_7);
        Button num8=findViewById(R.id.no_8);
        Button num9=findViewById(R.id.no_9);

        Button add=findViewById(R.id.addition);
        Button sub=findViewById(R.id.subraction);
        Button mul=findViewById(R.id.multiplication);
        Button div=findViewById(R.id.division);
        Button mod=findViewById(R.id.modulus);
        Button equals=findViewById(R.id.equals);
        Button point=findViewById(R.id.decimal);
        Button del=findViewById(R.id.delete);
        Button ac=findViewById(R.id.all_clear);

        ArrayList<Button>num=new ArrayList<>();
        num.add(num0);
        num.add(num00);
        num.add(num1);
        num.add(num2);
        num.add(num3);
        num.add(num4);
        num.add(num5);
        num.add(num6);
        num.add(num7);
        num.add(num8);
        num.add(num9);

        for (Button b: num){
            b.setOnClickListener(view -> {
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }else {
                        screen.setText(b.getText().toString());
                }

            });
        }

        ArrayList<Button>actions=new ArrayList<>();
        actions.add(add);
        actions.add(sub);
        actions.add(div);
        actions.add(mod);
        actions.add(mul);

        for (Button b: actions){
            b.setOnClickListener(view ->{
                n=Double.parseDouble(screen.getText().toString());
                operation=b.getText().toString();
                screen.setText("0");
            });
        }
        ac.setOnClickListener(view ->{
            n=0;
            screen.setText("0");
        });
        del.setOnClickListener(view ->{
            String number=screen.getText().toString();
            if(number.length()>1){
                screen.setText(number.substring(0,number.length()-1));
            }else if(number.length()==1 && !number.equals("0")){
                screen.setText("0");
            }
        });
        point.setOnClickListener(view ->{
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString()+".");
            }
        });
        equals.setOnClickListener(view->{
            double n2=Double.parseDouble(screen.getText().toString());
            double res;
            switch (operation){
                case "/":
                    res=n/n2;
                    break;
                case "+":
                    res=n+n2;
                    break;
                case "-":
                    res=n-n2;
                    break;
                case "X":
                    res=n*n2;
                    break;
                case "%":
                    res=n%n2;
                    break;
                default:
                    res=n+n2;
            }
            if (res == (int) res) {
                screen.setText(String.valueOf((int) res));
            } else {
                screen.setText(String.valueOf(res));
            }
            n=res;
        });
        }
    }
