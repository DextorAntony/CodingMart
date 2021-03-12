package com.codingmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;
    private List<club> courses;
private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
         b = findViewById(R.id.sout);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(courses);
        initializeData();
        initializeAdapter();
    }
    private void initializeAdapter() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(courses);
        recyclerView.setAdapter(adapter);
    }

    private void initializeData() {
        courses = new ArrayList<>();
        courses.add(new club("Android",R.drawable.android));
        courses.add(new club("Angular",R.drawable.angular));
        courses.add(new club("Appstore",R.drawable.appstore));
        courses.add(new club("Ios",R.drawable.ios));
        courses.add(new club("Puma",R.drawable.puma));
        courses.add(new club("React",R.drawable.react));
        courses.add(new club("node",R.drawable.nodejs));
        courses.add(new club("Java",R.drawable.java));
    }


    class club {

        String name;
        int logoId;

        club(String name, int logoId){
            this.name = name;
            this.logoId = logoId;
        }}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.sout: {
                GoogleSignInOptions gso = new GoogleSignInOptions.
                        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                        build();

                GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(getApplicationContext(),gso);
                googleSignInClient.signOut();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Logged Out",Toast.LENGTH_SHORT);

            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.out, menu);
        return true;
    }
    @Override
    public void onBackPressed() {

        finishAffinity();
      //  onDestroy();

        super.onBackPressed();
    }

}