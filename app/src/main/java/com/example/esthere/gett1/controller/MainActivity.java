package com.example.esthere.gett1.controller;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.esthere.gett1.R;
import com.example.esthere.gett1.model.datasource.Globals;
import com.example.esthere.gett1.model.entities.Ride;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class MainActivity extends Activity {

    EditText name, email, phone, sourceL, destinationL;//, leaveT,destinationT;

    private PlaceAutocompleteFragment placeAutocompleteFragment1;
    private PlaceAutocompleteFragment placeAutocompleteFragment2;
    private Button button;
    private TextView statusTextView;

    String from, to;


    Location locationA = new Location("A");//= new Location(from);
    Location locationB = new Location("B");//= new Location(to);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        email = (EditText) findViewById(R.id.emailCostumer);
        name = (EditText) findViewById(R.id.nameCostumer);
        phone = (EditText) findViewById(R.id.phoneCostumer);
        //sourceL = (EditText) findViewById(R.id.sourceLocation);
        //destinationL = (EditText) findViewById(R.id.targetLocation);
        //leaveT= (EditText) findViewById(R.id.leaveTime);
        //destinationT = (EditText) findViewById(R.id.arriveTime);

    }

    public void addRideClicked(View view) {
        //int hour = ((TimePicker) findViewById(R.id.timeRide)).getHour();
        //int minute = ((TimePicker) findViewById(R.id.timeRide)).getMinute();
        //Date time=new Date(hour,minute,0);
        Ride ride = new Ride();//(null, null, !((RadioButton) findViewById(R.id.rbLeaving)).isChecked(), time, name.getText().toString(), phone.getText().toString(), email.getText().toString());
        ride.setName(name.getText().toString());
        ride.setPhone(phone.getText().toString());
        ride.setEmail(email.getText().toString());
        ride.setArrivingOrLeaving(!((RadioButton) findViewById(R.id.rbLeaving)).isChecked());
        //ride.setSourceLocation();
        //ride.setTargetLocation();
        //ride.setTimeRide(time);

        ride.setSourceLocation(locationA);
        ride.setTargetLocation(locationB);

        Globals.backend.addRide(ride);

        // Write a message to the database https://gett-9a48c.firebaseio.com/
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        HashMap<String,Object> hashMap = new HashMap();
//        hashMap.put("key-1","value 1 ");
//        hashMap.put("key-2","value 2 ");
//        hashMap.put("key-3","value 3 ");
//        myRef.setValue(hashMap);


        sendBroadcast(view);

        DialogEnd.Dialog(MainActivity.this, "Successful order", getString(R.string.dialog_end), getString(R.string.ok));

        //finish();

    }


    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-07-06 13:00:00 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        placeAutocompleteFragment1 = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_sourceLocation);
        placeAutocompleteFragment2 = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_targetLocation);
        //button = (Button)findViewById( R.id.button );
        //statusTextView = (TextView)findViewById( R.id.statusTextView );

        //button.setOnClickListener(this);


        placeAutocompleteFragment1.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                locationA.setLatitude(place.getLatLng().latitude);
                locationA.setLongitude(place.getLatLng().longitude);
                // .getAddress().toString();//get place details here
            }

            @Override
            public void onError(Status status) {

            }
        });

        placeAutocompleteFragment2.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                //  to = place.getAddress().toString();//get place details here
                locationB.setLatitude(place.getLatLng().latitude);
                locationB.setLongitude(place.getLatLng().longitude);
            }

            @Override
            public void onError(Status status) {

            }
        });
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.example.esthere.gett1");
        intent.putExtra("user","esthere");
        intent.putExtra("password","1111");
        intent.putExtra("tel","0548420225");
        intent.putExtra("lng",21.3434);
        intent.putExtra("lat",21.3434);
        sendBroadcast(intent);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2018-07-06 13:00:00 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    //@Override
//    public void onClick(View v) {
//        if (v == button) {
//            showDistance();
//        }
//    }

//    private void showDistance() {
//
//
//        float[] results = new float[5];
//        Location.distanceBetween(locationA.getLatitude(), locationA.getLongitude(),
//                locationB.getLatitude(), locationB.getLongitude(), results);
//
//
//        float distance = locationA.distanceTo(locationB);
//        // locationA.bearingTo()
//
//        if (distance > 1000)
//            statusTextView.setText("" + distance / 1000 + " km");
//        else {
//            statusTextView.setText("" + distance + " meter");
//        }
//
//    }
}
