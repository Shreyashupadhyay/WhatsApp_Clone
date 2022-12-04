package com.example.whatsapp_clone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp_clone.Models.massageModel;
import com.example.whatsapp_clone.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class chatAdapter extends RecyclerView.Adapter{
    ArrayList<massageModel> massageModels;
    Context context;
    String recId;

    int SENDER_VIEW_TYPE =1;
    int RECIVER_VIEW_TYPE = 2;

    public chatAdapter(ArrayList<massageModel> massageModels, Context context) {
        this.massageModels = massageModels;
        this.context = context;
    }

    public chatAdapter(ArrayList<massageModel> massageModels, Context context, String recId) {
        this.massageModels = massageModels;
        this.context = context;
        this.recId = recId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==SENDER_VIEW_TYPE){
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return  new SenderViewHolder((view));
        }else
        {
            View view = LayoutInflater.from(context).inflate(R.layout.sample_reciver,parent,false);
            return  new ReciverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(massageModels.get(position).getUid().equals(FirebaseAuth.getInstance().getUid())){
            return SENDER_VIEW_TYPE;
        }else{
            return RECIVER_VIEW_TYPE;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        massageModel massageModel = massageModels.get(position);

        if(holder.getClass()==SenderViewHolder.class){
            ((SenderViewHolder) holder).senderMsg.setText(massageModel.getMessage());

        }else {
            ((ReciverViewHolder)holder).reciverMsg.setText(massageModel.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return massageModels.size();
    }

    public class ReciverViewHolder extends RecyclerView.ViewHolder{

        TextView reciverMsg, receiverTime;


        public ReciverViewHolder(@NonNull View itemView) {
            super(itemView);
            reciverMsg = itemView.findViewById(R.id.reciverText);
            receiverTime = itemView.findViewById(R.id.reciverTime);
        }
    }
    public class SenderViewHolder extends  RecyclerView.ViewHolder{
        TextView senderMsg ,senderTime;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMsg = itemView.findViewById(R.id.senderText);
            senderTime = itemView.findViewById(R.id.sendTime);
        }
    }

}
