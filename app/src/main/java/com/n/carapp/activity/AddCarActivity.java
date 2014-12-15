package com.n.carapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.n.carapp.R;
import com.parse.ParseObject;

/**
 * Created by Nick7 on 12/14/2014.
 */
public class AddCarActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcarfragment);

        Button button = (Button) findViewById(R.id.addcarbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                EditText carmodelText = (EditText) findViewById(R.id.carmodelinput);
                String modeltext = carmodelText.getText().toString();

                EditText carmakeText = (EditText) findViewById(R.id.carmakeinput);
                String maketext = carmakeText.getText().toString();

                EditText youtubeText = (EditText) findViewById(R.id.youtubekeyinput);
                String youtext = youtubeText.getText().toString();

                EditText engineText = (EditText) findViewById(R.id.enginelabelinput);
                String enginetext = engineText.getText().toString();

                EditText sixtyText = (EditText) findViewById(R.id.sixtyTimelabelinput);
                String sixtytext = sixtyText.getText().toString();

                EditText topText = (EditText) findViewById(R.id.topSpeedinput);
                String toptext = topText.getText().toString();


                ParseObject testObject = new ParseObject("CarClass");
                testObject.put("CarModel", modeltext);
                testObject.put("CarMake", maketext);
                testObject.put("youtubekey", youtext);
                testObject.put("Engine", enginetext);
                testObject.put("sixtyTime", sixtytext);
                testObject.put("TopSpeed", toptext);

                testObject.saveInBackground();

                carmodelText.setText("");
                carmakeText.setText("");
                youtubeText.setText("");
                engineText.setText("");
                sixtyText.setText("");
                topText.setText("");

                //Toast.makeText(getActivity().getApplicationContext(), R.string.color, Toast.LENGTH_SHORT);
            }

        });



    }







}


