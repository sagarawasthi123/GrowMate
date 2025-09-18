package com.example.agrimitra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {
    private List<MarketPrice> marketList;

    public MarketAdapter(List<MarketPrice> marketList) {
        this.marketList = marketList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market_price, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarketPrice price = marketList.get(position);
        holder.commodity.setText(price.getCommodity());
        holder.city.setText("City: " + price.getCity());
        holder.min.setText("Min: " + price.getMinPrice());
        holder.max.setText("Max: " + price.getMaxPrice());
        holder.model.setText("Model: " + price.getModelPrice());
        holder.date.setText("Date: " + price.getDate());
    }

    @Override
    public int getItemCount() {
        return marketList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView commodity, city, min, max, model, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            commodity = itemView.findViewById(R.id.commodity);
            city = itemView.findViewById(R.id.city);
            min = itemView.findViewById(R.id.minPrice);
            max = itemView.findViewById(R.id.maxPrice);
            model = itemView.findViewById(R.id.modelPrice);
            date = itemView.findViewById(R.id.date);
        }
    }
}
