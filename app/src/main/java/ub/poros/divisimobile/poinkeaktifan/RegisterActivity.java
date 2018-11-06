package ub.poros.divisimobile.poinkeaktifan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etName, etPassword, etIdLine;
    Gson gson = new GsonBuilder().create();

    String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getUser();

        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        etIdLine = (EditText) findViewById(R.id.et_id_line);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, etName.getText().toString() + etIdLine.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUser() {
    AndroidNetworking.get("https://poin-keaktifan.glitch.me/user")
                .addQueryParameter("limit", "3")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        User user = null;
                        try {
                            user = gson.fromJson(response.getJSONObject(0).toString(), User.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(RegisterActivity.this, user.getLineId(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.d(TAG, "onResponse error: "+error.toString());
                        // handle error
                    }
                });
    }
}
