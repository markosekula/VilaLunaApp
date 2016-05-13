package com.example.dev5.vilalunaapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<ItemObject> itemList;
    private Context context;
    LayoutInflater layoutInflater;

    public ImageAdapter(Context context, List<ItemObject> itemList) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public ItemObject getItem(int position) {

        Log.d("click", "position:" +position);
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.d("click", "position:" +position);

        return position;
    }

    public  class Holder {
        TextView title;
        ImageView photo;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ItemObject itemObject=getItem(position);
        Holder holder = new Holder();
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_layout, null);

        holder.title = (TextView) layoutView.findViewById(R.id.name_text);
        holder.photo = (ImageView)layoutView.findViewById(R.id.image_vila);

        holder.title.setText(itemObject.getName());
        holder.photo.setImageResource(itemObject.getPhoto());

            holder.photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        Intent intent = new Intent(context, Apartments.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "click:  " + position, Toast.LENGTH_SHORT).show();
                    }
                    else if (position == 1) {
                        Intent intent = new Intent(context, Zlatibor.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "click  " + position, Toast.LENGTH_SHORT).show();
                    }
                    else if (position == 2) {
                        Intent intent = new Intent(context, Gallery.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "click  " + position, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent intent = new Intent(context, Contact.class);
                        context.startActivity(intent);
                        Toast.makeText(context, "click  " + position, Toast.LENGTH_SHORT).show();
                    }

                }
            });

          return layoutView;
    }
}
