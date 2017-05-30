package com.example.arsalankhan.firebaselistadapter;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    ArrayList<Artist> artists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);
        progressDialog=new ProgressDialog(this);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://test-fcm-9f93c.firebaseio.com/Artists");
        progressDialog.setMessage("Please Wait, Loading Data From Server");
        progressDialog.show();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Artist artist=snapshot.getValue(Artist.class);
                    artists.add(artist);
                }
                MyAdapter adapter=new MyAdapter(getApplicationContext(),artists);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
