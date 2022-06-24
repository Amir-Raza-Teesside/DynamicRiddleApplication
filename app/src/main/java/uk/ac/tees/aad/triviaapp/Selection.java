package uk.ac.tees.aad.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabItem;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Selection extends AppCompatActivity {

    Button btn,btn2;
    JsonObjectRequest request;

  public  static  ArrayList<QuestionModel> models;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        models = new ArrayList<>();

        btn2 = findViewById(R.id.button2);
        btn= findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Toast.makeText(Selection.this, models.get(0).getOptionA().toString(),Toast.LENGTH_LONG).show();

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Selection.this,MainActivity.class);
                startActivity(intent);
            }
        });
       // RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    for(int i =0;i<10;i++){
                    JSONArray array = response.getJSONArray("results");
                    JSONObject obj = array.getJSONObject(i);
                    String question = obj.getString("question");

                    String rightAnswer = obj.getString("correct_answer");
                    JSONArray arr = obj.getJSONArray("incorrect_answers");


                    //Toast.makeText(Selection.this,question,Toast.LENGTH_LONG).show();

                   Toast.makeText(Selection.this, "sddsd",Toast.LENGTH_LONG).show();
                    models.add(new QuestionModel(question,rightAnswer,arr.getString(0),arr.getString(1),arr.getString(2)));

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // String x = obj.getString("question");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Selection.this,"eeejkhjh",Toast.LENGTH_LONG).show();

            }
        });

        Singleton.getInstance(this).addToRequestQueue(request);
    }
}