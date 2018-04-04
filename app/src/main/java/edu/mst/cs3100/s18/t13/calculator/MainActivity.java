package edu.mst.cs3100.s18.t13.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CalculatorModelObserver {

    /* Member Variables **************************************************************************/

    /* View */
    private TextView textView_primaryDisplay;
    private EditText editText_equation;

    /* Model */
    private CalculatorModel model;

    /* Application Lifecycle **********************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize View Elements */
        this.textView_primaryDisplay = ( TextView ) findViewById( R.id.textView_primaryDisplay );
        this.editText_equation = ( EditText ) findViewById( R.id.editText_equation );

        /* Initialize Model */
        this.model = new CalculatorModel( this );
    }

    /* Calculator Model Events ********************************************************************/

    @Override
    public void equationDidChange() {

        /* Update display with new model values */
        this.textView_primaryDisplay.setText( String.format(
                Locale.US,                 /* Make all formatting in context to the US */
                "%s = %f",         /* String = float */
                this.model.getEquation(), /* New Equation */
                this.model.getResult()    /* Same Result */
        ));
    }

    @Override
    public void resultDidChange() {

        /* Update display with new model values */
        this.textView_primaryDisplay.setText( String.format(
                Locale.US,                 /* Make all formatting in context to the US */
                "%s=%f",            /* String = float */
                this.model.getEquation(),  /* Same Equation */
                this.model.getResult()     /* New Result */
        ));
    }

    /* Button Listener ****************************************************************************/

    public void onEvaluateClick( View view ) {

        /* Get user input from EditText UI element */
        String equationString = editText_equation.getText().toString();

        /* Send text to model */
        this.model.newEquationEntered( equationString );
    }
}
