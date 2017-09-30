package com.example.mudrakpatel_comp304lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText),
                addressEditText = (EditText)findViewById(R.id.addressEditText);
        final EditText creditCardNumberEditText
                = (EditText) findViewById(R.id.creditCardNumberEditText);

        //Populate the LinearLayout inside the ScrollView
        // with the items that the customer ordered
        try {
            LinearLayout linearLayoutInScrollView = (LinearLayout) findViewById(R.id.linearLayoutInScrollView);
            for(String item : MenuActivity.userOrderArray){
                TextView textView = new TextView(getApplicationContext());
                textView.setText(item);
                textView.setTextSize(25);
                textView.setTextColor(Color.BLACK);
                textView.setGravity(Gravity.CENTER);
                linearLayoutInScrollView.addView(textView);
            }
        } catch (Exception e) {
            System.out.println(">>>>>>>> Exception");
            System.out.println(">>>>>>>> " + e.getMessage());

        }

        //Declare a nextButton
        Button nextButtonOrder = (Button)findViewById(R.id.nextButtonOrder);
        nextButtonOrder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //get the value from number picker
                String numberPickerValue = creditCardNumberEditText.getText().toString();
                //Validate the input fields
                if(nameEditText.getText().toString().isEmpty()
                        || addressEditText.getText().toString().isEmpty()
                        || numberPickerValue.isEmpty()
                        || numberPickerValue.length() != 16){
                    Toast.makeText(getApplicationContext(), "PLEASE FILL OUT ALL THE FIELDS"
                                    + "\n" + "CREDIT CARD NUMBER SHOULD BE EXACTLY 16 DIGITS LONG!",
                            Toast.LENGTH_LONG).show();
                } else {
                        //Validation successful
                        //Confirm the order and thank the user
                        Intent intent = new Intent(getApplicationContext(), LastActivity.class);
                        startActivity(intent);
                }
            }
        });

        //Declare a back button
        Button backButtonOrder = (Button)findViewById(R.id.backButtonOrder);
        backButtonOrder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                /*Clear the array otherwise
                otherwise user won't be able
                to register the new order
                because the old order will be
                saved in the userOrderArray*/
                MenuActivity.userOrderArray.clear();
                onBackPressed();
            }
        });
    }
}
