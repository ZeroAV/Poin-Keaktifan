package ub.poros.divisimobile.poinkeaktifan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testGet();
        startActivity(new Intent(this, BikinPostActivity.class));
    }

    private void testGet() {
        //get
        Fuel.get("https://httpbin.org/get").responseString(new Handler<String>() {
            @Override
            public void failure(Request request, Response response, FuelError error) {
                Log.d("fuel failed", "failure: ");
            }

            @Override
            public void success(Request request, Response response, String data) {
                Log.d("fuel success", response.toString());
            }
        });
    }
}
