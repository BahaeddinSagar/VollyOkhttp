package com.example.vollyokhttp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void VolleyRequest(View view) {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=London&mode=json&units=metric&appid=56f68190828428adfaf9f8d42c54e960";
        makeVolleyRequest(urlString);

    }

    void makeVolleyRequest(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        interactWithResponse(response);
                        Log.d("Volley", "makeVolleyRequest: At request ");

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(MainActivity.this, "Request failed, please try again", Toast.LENGTH_SHORT).show();
            }
        }
        );
        Log.d("Volley", "makeVolleyRequest: Before request ");
        queue.add(stringRequest);
        Log.d("Volley", "makeVolleyRequest: After request 1");

    }

    void interactWithResponse(String s){
        TextView textView = findViewById(R.id.Response);
        textView.setText(s);
    }


}

