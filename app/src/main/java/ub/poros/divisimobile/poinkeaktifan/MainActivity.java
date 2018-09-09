package ub.poros.divisimobile.poinkeaktifan;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab_buat);
        Log.d("test intent", this.toString());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("fab","instance initializer: fab clicked");
                startActivity(new Intent(view.getContext(), BikinPostActivity.class));
                Log.d("test intent", this.toString());
                Log.d("test intent context", view.getContext().toString());
            }
        });
    }


}
