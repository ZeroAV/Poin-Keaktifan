package ub.poros.divisimobile.poinkeaktifan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ub.poros.divisimobile.poinkeaktifan.adapter.ListPostAdapter;

public class ListPostActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_post);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Post> myDataset = new ArrayList<>();
        Post post = new Post("Mat","Piket",10);
        myDataset.add(post);
        post = new Post("Mat","Piket",12);
        myDataset.add(post);
        post = new Post("S","Piket",10);
        myDataset.add(post);
        post = new Post("Mat","Rapat",10);
        myDataset.add(post);
        post = new Post("Mat","Piket",10);
        myDataset.add(post);
        for (int i=0;i<50;i++){
            post = new Post("Mat","Piket",i);
            myDataset.add(post);
        }
        // specify an adapter (see also next example)
        mAdapter = new ListPostAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
