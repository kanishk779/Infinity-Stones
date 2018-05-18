package com.example.android.infinity_stones;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    //static int selector=6;
   /* static ArrayList<Integer> list1 = new ArrayList<Integer>();
    {
        list1.add(1);
        list1.add(2);
        list1.add(3);              //THIS LIST WAS CREATED FOR RANDOMIZING THE STONE PICKED
        list1.add(4);              // WITHOUT REPETITION, BUT THE APP CRASHES IF I USE THEM
        list1.add(5);
        list1.add(6);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> words=new ArrayList<String>();
        final ArrayList<String> words1=new ArrayList<String>();


        //CREATING ARRAY-LIST OF STONES


        words.add("Power stone-Purple");
        words.add("Space stone-Blue");
        words.add("Time stone-Green");
        words.add("Reality stone-Red");
        words.add("Soul stone-Orange");
        words.add("Mind stone-Yellow");

        //CODE FOR SEE_LIST BUTTON


        Button See_list_button=(Button)findViewById(R.id.see_list);
        See_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("list", words1);
                startActivity(i);
            }
        });

        //CODE FOR ADD_STONE BUTTON


        Button Add_stone_button=(Button)findViewById(R.id.Add_stone);
        Add_stone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(words1.size()<=5){
                    int x=(int)getRandomIntegerBetweenRange(1,6);

                    words1.add(words.get(x).toString());
                    TextView change_color_textview = (TextView)findViewById(R.id.change_color);

                    //CODE FOR COLOR INDICATOR

                    switch (x+1){
                        case 1:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.purple));
                                break;
                        case 2:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.blue));
                                break;
                        case 3:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.green));
                               break;
                        case 4:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.red));
                               break;
                        case 5:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.orange));
                               break;
                        case 6:change_color_textview.setText(R.string.imp);
                            change_color_textview.setTextColor(getResources().getColor(R.color.yellow));
                               break;
                    }

                    TextView stone_teller_textview= (TextView)findViewById(R.id.stone_teller);
                    stone_teller_textview.setText("You got " + words.get(x).toString());

                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putStringArrayListExtra("list", words1);
                    startActivity(i);
                }
                else if(words1.size()==6){
                    Context context = getApplicationContext();
                    CharSequence text = "BRAVO!! You Have All The Stones";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


        //CODE FOR RESET BUTTON


        Button Reset_button=(Button)findViewById(R.id.Reset_button);
        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no_of_words=words1.size();
                for(int i=0;i<no_of_words;i++){
                    words1.remove(0);
                }
                words1.add("Now you Have No Infinity Stones-Thanos Took Them Away");
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("list", words1);
                startActivity(i);
            }
        });



    }
    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
  /* public static int abc(){
       if(selector==1){
           int x;             //THIS IS THE FUNCTION THAT WOULD PREVENT THE SAME STONE FROM SELECTING
                              //MORE THAN ONCE
           Integer y;
           x = (int)getRandomIntegerBetweenRange(1,selector);
           selector=6;
           y=list1.remove(x);
           {
               list1.add(1);
               list1.add(2);
               list1.add(3);
               list1.add(4);
               list1.add(5);
               list1.add(6);
           }
           return y;
       }
       else{
           int x;
           Integer y;
           x = (int)getRandomIntegerBetweenRange(1,selector);
           selector--;
           y=list1.remove(x);
           return y;
       }
   }*/

}
