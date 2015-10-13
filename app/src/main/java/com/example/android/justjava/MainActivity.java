package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


//this app displays an order form to order coffee
public class MainActivity extends AppCompatActivity {
    int quantity=0;



    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){

            quantity=quantity+1;
        displayQuantity(quantity);

    }

    public void decrement(View view){

            quantity =quantity-1;
        displayQuantity(quantity);

    }


    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean chocolatte){


        String priceMessage= "Name "+name+"\nAdd Whipped Cream?: "+addWhippedCream+"\nIs Chocolate: "+chocolatte+"\nTotal Amount: "+ "$"+price;
        priceMessage=priceMessage+"\nQuantity: "+quantity+".\nThank You!! ";
        return priceMessage;
    }
private int calculatePrice(boolean addWhippedCream,boolean chocolatte){
    int basePrice=5;
if(addWhippedCream){
    basePrice = basePrice+1;
}
    if(chocolatte){
        basePrice=basePrice+2;
    }

    return quantity*basePrice;
}

//this method is called whenever the order button is clicked
    public void SubmitOrder(View view){
        EditText name=(EditText)findViewById(R.id.Name);
        String Name_Value=name.getText().toString();

        CheckBox whippedCream=( CheckBox)findViewById(R.id.checkbox1);
        boolean hasWhippedCream=whippedCream.isChecked();
        CheckBox chocolate=(CheckBox)findViewById(R.id.checkbox2);
        boolean hasChocolate= chocolate.isChecked();
        int price=calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage=createOrderSummary(Name_Value,price,hasWhippedCream,hasChocolate);

        displayMessage(priceMessage);

    }
    //this method displays the given quantity on the screen
    private void displayQuantity(int number){

        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    private void displayMessage(String message){

        TextView orderSummaryTextView=(TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
