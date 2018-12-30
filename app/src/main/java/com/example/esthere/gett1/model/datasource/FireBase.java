package com.example.esthere.gett1.model.datasource;

import com.example.esthere.gett1.model.backend.IBackend;
import com.example.esthere.gett1.model.entities.Ride;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase implements IBackend {
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rides = db.getReference("Ride");
    @Override
    public void addRide(Ride ride) {

        rides.push().setValue(ride);
        return;

//        HashMap<String,Object> hashMap = new HashMap();
//        hashMap.put("key-1","value 1 ");
//        hashMap.put("key-2","value 2 ");
//        hashMap.put("key-3","value 3 ");
        //myRef1.push().setValue("student message 1"); myRef1.push().setValue("student message 2"); myRef1.push().setValue("student message 3");
        //myRef.push().setValue(ride);
//myRef.child("ride1").setValue(ride);
        //DatabaseReference myRef1=myRef.child("ride1");
        //myRef1.push().setValue(ride);

//
//        Ride ride1 =new Ride();
//        ride1.setEmail(ride.getEmail());
//        ride1.setStatus(Ride.Status.AVAILABLE);
//        ride1.setPhone(ride.getPhone());
//        ride1.setName(ride.getName());
//        ride1.setArrivingOrLeaving(ride.isArrivingOrLeaving());
//        //ride1.setTimeRide(ride.getTimeRide());
//
//        DatabaseReference newRef = myRef.push();
//        //DatabaseReference newRef = myRef.child("ride").push();
//        newRef.setValue(ride1);
//        //myRef1.setValue(ride);


    }
}
