package com.e.upload_image;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapterAll extends FirebaseRecyclerAdapter<DetailModel,adapterAll.myviewholder> {
      class myviewholder extends RecyclerView.ViewHolder
      {
          ImageView img;
          TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

          public myviewholder(@NonNull View itemView) {
              super(itemView);
              img=(ImageView)itemView.findViewById(R.id.imageview);
              tv1=(TextView)itemView.findViewById(R.id.textView1);
              tv2=(TextView)itemView.findViewById(R.id.textView2);
              tv3=(TextView)itemView.findViewById(R.id.textView3);
              tv4=(TextView)itemView.findViewById(R.id.textView4);
              tv5=(TextView)itemView.findViewById(R.id.textView5);
              tv6=(TextView)itemView.findViewById(R.id.textView6);
              tv7=(TextView)itemView.findViewById(R.id.textView7);
              tv8=(TextView)itemView.findViewById(R.id.textView8);
          }
      }
}
