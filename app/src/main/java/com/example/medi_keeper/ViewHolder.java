package com.example.medi_keeper;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public
    TextView title;
    TextView content;
    ImageView imageView;
    Button recordbtn;

    public ViewHolder(Context context, View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.listtitle);
        content = itemView.findViewById(R.id.listcontent);
        imageView = itemView.findViewById(R.id.mimage);
        recordbtn = itemView.findViewById(R.id.recordmidicine);
        recordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //근데 등록하기전에 확인해야되는데
                //데이터베이스에 등록하는 코드 작성
            }
        });
    }
}
