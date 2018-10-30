package ub.poros.divisimobile.poinkeaktifan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import ub.poros.divisimobile.poinkeaktifan.adapter.ListPostAdapter;

public class ListPostActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String TAG = "hmm";
    Gson gson = new GsonBuilder().create();
    List<Poin> poins = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_post);

        getPoin();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ListPostAdapter(poins);
        mRecyclerView.setAdapter(mAdapter);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(mRecyclerView);
    }

    private void getPoin() {

        AndroidNetworking.get("https://poin-keaktifan.glitch.me/poin")
                .addQueryParameter("limit", "3")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++){
                                Poin poin = gson.fromJson(response.getJSONObject(i).toString(), Poin.class);
                                poins.add(poin);
                                Log.d(TAG, "onResponse: arrayilstVal"+poins.get(i));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        initRecyclerView();

                    }
                    @Override
                    public void onError(ANError error) {
                        Log.d(TAG, "onResponse error: "+error.toString());
                        // handle error
                    }
                });
    }
}
