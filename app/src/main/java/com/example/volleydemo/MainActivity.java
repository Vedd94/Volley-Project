package com.example.volleydemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    String url = "https://www.instagram.com";
   String apiurl = "https://www.bing.com/search?q=live+cricket+score&cvid=0027b0d5d5bb44ccb80eff0d86fb52c3&aqs=edge.0.69i59j69i57j0l6j69i61j69i11004.1306j0j1&pglt=41&FORM=ANSAB1&PC=LCTS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //queue = Volley.newRequestQueue(this);

        queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("SuperV", "onResponse: " + response.substring(0,100));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SuperV", "onErrorResponse: Error in loading");
            }
        });

        queue.add(stringRequest);

       /* JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.d("json", "onResponse: "  + jsonObject.getInt("id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("json", "onResponse: Error in loading...." );
            }
        });


        StringRequest stringRequest = getRequest();
        queue.add(jsonArrayRequest);
        queue.add(stringRequest); */


    }

    @NonNull
    private StringRequest getRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {

              Log.d("Main", "Instagram HTML : " + response.substring(0,20));

          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Log.d("Main", "Error in loading....");
          }
      });
        return stringRequest;
    }
}