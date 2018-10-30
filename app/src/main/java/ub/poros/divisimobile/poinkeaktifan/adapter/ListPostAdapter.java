package ub.poros.divisimobile.poinkeaktifan.adapter;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ub.poros.divisimobile.poinkeaktifan.ListPostActivity;
import ub.poros.divisimobile.poinkeaktifan.Poin;
import ub.poros.divisimobile.poinkeaktifan.Post;
import ub.poros.divisimobile.poinkeaktifan.R;

public class ListPostAdapter extends RecyclerView.Adapter<ListPostAdapter.MyViewHolder>{
    private List<Poin> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTextName, mTextPoint, mTextDesc;
        private Button btn10, btn20, btn50, btn100;

        public MyViewHolder(View v) {
            super(v);
            mTextName = v.findViewById(R.id.text_name);
            mTextPoint = v.findViewById(R.id.text_poin);
            mTextDesc = v.findViewById(R.id.text_desc);
            btn10 = (Button) v.findViewById(R.id.btn_10);
            btn20 = (Button) v.findViewById(R.id.btn_20);
            btn50 = (Button) v.findViewById(R.id.btn_50);
            btn100 = (Button) v.findViewById(R.id.btn_100);

            btn10.setOnClickListener(this);
            btn20.setOnClickListener(this);
            btn50.setOnClickListener(this);
            btn100.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_10:
                    Toast.makeText(v.getContext(), "10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_20:
                    Toast.makeText(v.getContext(), "20", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_50:
                    Toast.makeText(v.getContext(), "50", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_100:
                    Toast.makeText(v.getContext(), "100", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }

        // Provide a suitable constructor (depends on the kind of dataset)
        public ListPostAdapter(List<Poin> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ListPostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_post_item, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Poin poin = mDataset.get(position);
            holder.mTextName.setText(poin.getName());
            holder.mTextDesc.setText(poin.getDescription());
            holder.mTextPoint.setText(poin.getPoin().toString());

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
