package uk.ac.tees.aad.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




   ArrayList<QuestionModel> models;

   TextView t;
   Button btn;
   Button btn2,btn3,btn4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = Selection.models;
        t= findViewById(R.id.MainQuestion);
        btn = findViewById(R.id.button3);
        btn2 = findViewById(R.id.button);
        btn3 = findViewById(R.id.button4);
        btn4 = findViewById(R.id.button5);

        Log.w("Fir", models.get(0).getQuestion());

        t.setText(models.get(0).getQuestion().toString());
        btn.setText(models.get(0).getAnswer().toString());
        btn2.setText(models.get(0).getOptionA().toString());
        btn3.setText(models.get(0).getOptionB().toString());
        btn4.setText(models.get(0).getOptionC().toString());







    }
}