package com.example.mudrakpatel_comp304lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class CuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        //Instantiate the Buttons
        Button cuisineBackButton = (Button) findViewById(R.id.cuisineBackButton),
                cuisineNextButton = (Button) findViewById(R.id.cuisineNextButton);

        //Attach click/tap event listener on both the buttons
        //1) on cuisineBackButton
        cuisineBackButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onBackPressed();
            }
        });

        //2) on cuisineNextButton
        cuisineNextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Instantiate and initialise all the RadioButtons
                RadioButton americanRadioButton = (RadioButton) findViewById(R.id.americanRadioButton),
                        italianRadioButton = (RadioButton) findViewById(R.id.italianRadioButton),
                        chineseRadioButton = (RadioButton) findViewById(R.id.chineseRadioButton),
                        indianRadioButton = (RadioButton) findViewById(R.id.indianRadioButton);

                //Proceed to the next activity,
                //only if the user has selected
                //at least one RadioButton
                if(americanRadioButton.isChecked() ||
                        italianRadioButton.isChecked() ||
                        chineseRadioButton.isChecked() ||
                        indianRadioButton.isChecked()){
                        //Now check which cuisine is selected
                    if(americanRadioButton.isChecked()){
                        Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                        intent.putExtra("cuisineName", "american");
                        startActivity(intent);
                    } else if (italianRadioButton.isChecked()) {
                        Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                        intent.putExtra("cuisineName", "italian");
                        startActivity(intent);
                    } else if(chineseRadioButton.isChecked()){
                        Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                        intent.putExtra("cuisineName", "chinese");
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
                        intent.putExtra("cuisineName", "indian");
                        startActivity(intent);
                    }
                } else{
                    //Print a Toast message
                    //to alert the user to
                    //at least select one RadioButton
                    Toast.makeText(getApplicationContext(),
                            "ERROR! Please select at least one option!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
