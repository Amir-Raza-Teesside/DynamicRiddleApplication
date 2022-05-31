package uk.ac.tees.aad.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {


    Button btn;
    TextView t;

    private RequestQueue q;

    Button btn2,btn3,btn4,btn5;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q = Volley.newRequestQueue(this);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4= findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        question = findViewById(R.id.textView2);
        t = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this,"aa",Toast.LENGTH_LONG).show();

                String url ="https://opentdb.com/api.php?amount=10&category=21&difficulty=easy&type=multiple";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                        url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast.makeText(MainActivity.this, response., Toast.LENGTH_LONG).show();
                        try {

                            JSONArray array = response.getJSONArray("results");

                            for(int i = 0; i< array.length();i++) {

                                JSONObject obj = array.getJSONObject(i);
                                String x = obj.getString("question");
                                String answer= obj.getString("correct_answer");

                                JSONArray xxx  = obj.getJSONArray("incorrect_answers");

                              //  xxx.getJSONArray(0)
                                t.setText(xxx.getString(0)+xxx.getString(1));



                                String [] xd = x.split(",");

                                Toast.makeText(MainActivity.this,xd[0],Toast.LENGTH_LONG).show();

                                btn2.setText(xxx.getString(0));
                                btn3.setText(xxx.getString(1));
                                btn4.setText(xxx.getString(2));
                                btn5.setText(answer.toString());
                                question.setText(x.toString());






                                //Toast.makeText(MainActivity.this,x,Toast.LENGTH_LONG).show();

                              //  t.setText(x.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        t.setText(error.getMessage().toString());
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });


                q.add(request);
            }
        });


    }
}