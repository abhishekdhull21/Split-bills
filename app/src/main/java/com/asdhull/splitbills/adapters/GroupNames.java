package com.asdhull.splitbills.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asdhull.splitbills.GroupView;
import com.asdhull.splitbills.R;
import com.asdhull.splitbills.modals.GroupsNameModal;

import java.util.ArrayList;

public class GroupNames extends  RecyclerView.Adapter<GroupNames.ViewHolder> {
    private ArrayList<GroupsNameModal> list;
    private final Activity context;
    public GroupNames(Activity context, ArrayList<GroupsNameModal> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_group_names, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    GroupsNameModal modal = list.get(position) ;
    holder.TextViewGroupName.setText(modal.getGroupName());
    holder.TextViewPCount.setText(modal.getPCount());

    holder.TextViewGroupName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, GroupView.class);
            i.putExtra("group",  list.get(position));
                context.startActivity(i);
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView TextViewGroupName, TextViewPCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewGroupName=itemView.findViewById(R.id.textGroupName);
            TextViewPCount=itemView.findViewById(R.id.textPCount);
        }
    }
}
