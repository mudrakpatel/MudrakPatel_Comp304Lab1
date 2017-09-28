package com.example.mudrakpatel_comp304lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    String restaurantName;
    String[] itemNames = {};
    ArrayList<CheckBox> checkBoxesArray = new ArrayList<>();
    public ArrayList<String> userOrderArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        restaurantName = getIntent().getStringExtra("restaurantName");
        //Get a reference to the RelativeLayout
        LinearLayout linearLayoutMenu = (LinearLayout) findViewById(R.id.linearLayoutMenu);

        //Generate the menu based on the restaurantName
        if(restaurantName.equals("American Heaven")){
            itemNames = getResources().getStringArray(R.array.americanHeavenItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("American Paradise")){
            itemNames = getResources().getStringArray(R.array.americanParadiseItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("American Beyond")){
            itemNames = getResources().getStringArray(R.array.americanBeyondItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Italian Heaven")){
            itemNames = getResources().getStringArray(R.array.italianHeavenItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Italian Paradise")){
            itemNames = getResources().getStringArray(R.array.italianParadiseItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Italian Beyond")){
            itemNames = getResources().getStringArray(R.array.italianBeyondItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Chinese Heaven")){
            itemNames = getResources().getStringArray(R.array.chineseHeavenItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Chinese Paradise")){
            itemNames = getResources().getStringArray(R.array.chineseParadiseItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Chinese Beyond")){
            itemNames = getResources().getStringArray(R.array.chineseBeyondItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Indian Heaven")){
            itemNames = getResources().getStringArray(R.array.indianHeavenItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Indian Paradise")){
            itemNames = getResources().getStringArray(R.array.indianParadiseItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        } else if(restaurantName.equals("Indian Beyond")){
            itemNames = getResources().getStringArray(R.array.indianBeyondItemsArray);
            //loop through the array and generate checkboxes dynamically
            for(String itemName : itemNames){
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(itemName);
                checkBox.setTextSize(25);
                checkBoxesArray.add(checkBox);
                linearLayoutMenu.addView(checkBox);
            }
        }

        //Create a button
        //The Button will be next button
        Button nextButton = new Button(getApplicationContext());
        nextButton.setText("Next");
        nextButton.setHeight(35);
        nextButton.setTextSize(25);
        linearLayoutMenu.addView(nextButton);
        //Set a click event listener on the Button
        nextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Check which checkboxes are checked and add them to the order
                for(CheckBox checkBox : checkBoxesArray){
                    if(checkBox.isChecked()){
                        userOrderArray.add(checkBox.getText().toString());
                    }
                }
            }
        });

        //Declare the Button backBtnMenu
        Button backBtnMenu = (Button) findViewById(R.id.backBtnMenu);
        //Attach a click/tap event listener
        backBtnMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Remove all items from the order
                userOrderArray.clear();
                onBackPressed();
            }
        });
    }
}
