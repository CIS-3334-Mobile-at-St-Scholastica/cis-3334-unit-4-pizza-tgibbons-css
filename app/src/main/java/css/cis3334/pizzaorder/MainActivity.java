package css.cis3334.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements updateViewInterface {

    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    CheckBox chkbxCheese;
    CheckBox chkbxDelivery;
    TextView txtTotal;
    TextView txtStatus;
    TextView txtPizzasOrdered;
    Spinner spinnerToppings;

    PizzaOrderInterface PizzaOrderSystem;           // Pizza Order Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PizzaOrderSystem = new PizzaOrder(this);    // instantiate Pizza Order

        // Set up our radio buttons
        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);

        rbSmall.append(" -- Price: $" + PizzaOrderSystem.getPrice(Pizza.pizzaSize.SMALL));
        rbSmall.setText("Small -- Price: $" + PizzaOrderSystem.getPrice(Pizza.pizzaSize.SMALL));
        rbMedium.append(" -- Price: $" + PizzaOrderSystem.getPrice(Pizza.pizzaSize.MEDIUM));
        rbLarge.append(" -- Price: $" + PizzaOrderSystem.getPrice(Pizza.pizzaSize.LARGE));

        // Set up the Check Boxes
        chkbxCheese = (CheckBox) findViewById(R.id.checkBoxCheese);
        chkbxDelivery = (CheckBox) findViewById(R.id.checkBoxDeluvery);

        // Set up the TextViews
        txtTotal = (TextView) findViewById(R.id.textViewTotal);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);
        txtPizzasOrdered = (TextView) findViewById(R.id.textViewPizzasOrdered);
        // Set up the Spinner
        spinnerToppings = (Spinner) findViewById(R.id.spinnerToppings);

    }

    @Override
    public void updateOrderStatusInView(String orderStatus) {

        txtStatus.setText("Order Status: " + orderStatus);
    }

    public void onClickOrder(View view) {
        // ****** For the Assignment, students need to add code here to get information from the UI widgets...

        String orderDescription = "No orders yet";

        // ****** For the Practice Activity, students need to call to OrderPizza here
        // ****** For the Assignment, students will modify the order to fit the type of pizza the user selects using the UI widgets
        orderDescription = PizzaOrderSystem.OrderPizza("Pepperoni","large",false);
        txtTotal.setText("Total Due: " + PizzaOrderSystem.getTotalBill().toString());

        //display a pop up message for a long period of time
        Toast.makeText(getApplicationContext(), "You have ordered a "+orderDescription , Toast.LENGTH_LONG).show();
        // add this pizza to the textview the lists the pizzas
        txtPizzasOrdered.append(orderDescription+"\n");

    }
}
