package example.org.test.w05d03solapp02;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    ArrayList<Product> productArrayList;

    public MyRecycleViewAdapter(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()))
                .inflate(R.layout.product_item, viewGroup, false);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewAdapter.ViewHolder viewHolder, int position) {
        Product currentProductBeingPopulated = productArrayList.get(position);
        viewHolder.tvProductName.setText(currentProductBeingPopulated.getProductName());
        viewHolder.tvProductIdNumber.setText(currentProductBeingPopulated.getProductIdNumber());
        viewHolder.tvProductInventoryCount.setText(currentProductBeingPopulated.getProductInventoryCount());
        viewHolder.tvProductDescription.setText(currentProductBeingPopulated.getProductDescription());
        Log.d("TAG", "onBindViewHolder: item being rendered = " + position);

    }

    @Override
    public int getItemCount() {
        return  productArrayList.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductIdNumber;
        TextView tvProductInventoryCount;
        TextView tvProductDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductIdNumber = itemView.findViewById(R.id.tvProductIdNumber);
            tvProductInventoryCount = itemView.findViewById(R.id.tvProductInventoryCount);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
        }
    }
    }

