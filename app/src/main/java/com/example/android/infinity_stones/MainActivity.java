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

import java.util.*;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    static int selector=5;
    //static ArrayList<String> list1 = new ArrayList<String>();
    static ArrayList<String> words=new ArrayList<String>();
    static ArrayList<String> words1=new ArrayList<String>();
    String a1 =new String("Power stone-Purple");
    String a2 =new String("Space stone-Blue");
    String a4 =new String("Reality stone-Red");
    String a5 =new String("Soul stone-Orange");
    String a3 =new String("Time stone-Green");
    String a6 =new String("Mind stone-Yellow");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //CREATING ARRAY-LIST OF STONES
        /*list1.add("Power stone-Purple");
        list1.add("Space stone-Blue");
        list1.add("Time stone-Green");
        list1.add("Reality stone-Red");
        list1.add("Soul stone-Orange");
        list1.add("Mind stone-Yellow");*/
        words.add("Power stone-Purple");
        words.add("Space stone-Blue");
        words.add("Time stone-Green");
        words.add("Reality stone-Red");
        words.add("Soul stone-Orange");
        words.add("Mind stone-Yellow");
        Collections.shuffle(words);

        //CODE FOR SEE_LIST BUTTON


        Button See_list_button=findViewById(R.id.see_list);
        See_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("list", words1);
                startActivity(i);
            }
        });

        //CODE FOR ADD_STONE BUTTON


        Button Add_stone_button=findViewById(R.id.Add_stone);
        Add_stone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = new String();
                message="Now you Have No Infinity Stones-Thanos Took Them Away";
                if(words1.contains(message))
                {
                    words1.remove(0);
                }
                if(words1.size()<=5){
                    //int x=(int)getRandomIntegerInRange(5);
                    String z = new String();
                    z = giveStone();
                    words1.add(z);
                    TextView change_color_textview = findViewById(R.id.change_color);

                    //CODE FOR COLOR INDICATOR

                    if(z.equals(a1)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.purple));
                    }
                    else if(z.equals(a2)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.blue));
                    }
                    else if(z.equals(a3)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.green));
                    }
                    else if(z.equals(a4)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.red));
                    }
                    else if(z.equals(a5)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.orange));
                    }
                    else if(z.equals(a6)){
                        change_color_textview.setText(R.string.imp);
                        change_color_textview.setTextColor(getResources().getColor(R.color.yellow));
                    }
                    /*switch (x){
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
                    }*/

                    TextView stone_teller_textview= findViewById(R.id.stone_teller);
                    stone_teller_textview.setText("You got " + z);

                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    i.putStringArrayListExtra("list", words1);
                    startActivity(i);
                }
                if(words1.size()==6){
                    Context context = getApplicationContext();
                    CharSequence text = "BRAVO!! You Have All The Stones";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });


        //CODE FOR RESET BUTTON


        Button Reset_button=findViewById(R.id.Reset_button);
        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no_of_words=words1.size();
                for(int i=0;i<no_of_words;i++){
                    words1.remove(0);
                }
                //selector=0;
                words1.add("Now you Have No Infinity Stones-Thanos Took Them Away");
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                i.putStringArrayListExtra("list", words1);
                startActivity(i);
            }
        });



    }
    /*public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }*/
    public static int getRandomIntegerInRange(int n){
        Random ran = new Random();
        int nxt = ran.nextInt(n);
        return (nxt +1);
    }
    public static String giveStone(){
        int ab= words.size();
        String above = new String();
        above = words.remove(ab-1);
        if(words.isEmpty()){
            words.add("Power stone-Purple");
            words.add("Space stone-Blue");
            words.add("Time stone-Green");
            words.add("Reality stone-Red");
            words.add("Soul stone-Orange");
            words.add("Mind stone-Yellow");
            Collections.shuffle(words);
        }
        return above;
    }
  /* public static int abc(){
       if(selector==0){
           int x;             //THIS IS THE FUNCTION THAT WOULD PREVENT THE SAME STONE FROM SELECTING
                              //MORE THAN ONCE
           Integer y;
           x = getRandomIntegerInRange(selector);
           selector=5;
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
           x = getRandomIntegerInRange(selector);
           selector--;
           y=list1.remove(x);
           return y;
       }
   }*/

}
