package ub.poros.divisimobile.poinkeaktifan.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ub.poros.divisimobile.poinkeaktifan.Post;
import ub.poros.divisimobile.poinkeaktifan.R;

public class ListPostAdapter extends RecyclerView.Adapter<ListPostAdapter.MyViewHolder>{
    private List<Post> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextName,mTextPoint,mTextDesc;
        public MyViewHolder(View v) {
            super(v);
            mTextName = v.findViewById(R.id.text_name);
            mTextPoint = v.findViewById(R.id.text_poin);
            mTextDesc = v.findViewById(R.id.text_desc);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListPostAdapter(List<Post> myDataset) {
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
        Post post = mDataset.get(position);
        holder.mTextName.setText(post.getNama());
        holder.mTextDesc.setText(post.getDeskripsi());
        holder.mTextPoint.setText(post.getPoin().toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
