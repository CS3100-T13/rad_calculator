package edu.mst.cs3100.s18.t13.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_primaryDisplay;
    private EditText editText_equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView_primaryDisplay = ( TextView ) findViewById( R.id.textView_primaryDisplay );
        this.editText_equation = ( EditText ) findViewById( R.id.editText_equation );
    }

    /* Button Listener ****************************************************************************/

    public void onEvaluateClick( View view ) {

        String equationString = editText_equation.getText().toString();

        this.textView_primaryDisplay.setText( equationString );

    }
}
