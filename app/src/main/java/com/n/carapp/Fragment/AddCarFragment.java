package com.n.carapp.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.n.carapp.R;
import com.parse.ParseObject;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class AddCarFragment extends Fragment {


    public AddCarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.addcarfragment, container, false);

        Button button = (Button) rootView.findViewById(R.id.addcarbutton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                EditText carmodelText = (EditText) rootView.findViewById(R.id.carmodelinput);
                String modeltext = carmodelText.getText().toString();

                EditText carmakeText = (EditText) rootView.findViewById(R.id.carmakeinput);
                String maketext = carmakeText.getText().toString();

                EditText youtubeText = (EditText) rootView.findViewById(R.id.youtubekeyinput);
                String youtext = youtubeText.getText().toString();

                EditText engineText = (EditText) rootView.findViewById(R.id.enginelabelinput);
                String enginetext = engineText.getText().toString();

                EditText sixtyText = (EditText) rootView.findViewById(R.id.sixtyTimelabelinput);
                String sixtytext = sixtyText.getText().toString();

                EditText topText = (EditText) rootView.findViewById(R.id.topSpeedinput);
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

        return rootView;

    }


}
