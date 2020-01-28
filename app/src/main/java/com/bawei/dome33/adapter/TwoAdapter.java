package com.bawei.dome33.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dome33.R;
import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.entity.ListEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.MyHv> {
    Context context;
    List<ListEntity.OrderDataBean.CartlistBean> list;

    public TwoAdapter(Context context, List<ListEntity.OrderDataBean.CartlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.two_item, null);
        MyHv myHv = new MyHv(inflate);
        return myHv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHv holder, int position) {
        holder.twoTitle.setText(list.get(position).getProductName());
        Glide.with(context).load(list.get(position).getDefaultPic()).into(holder.twoImage);
      holder.twoText.setText(list.get(position).getPrice()+"$");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHv extends RecyclerView.ViewHolder {
        @BindView(R.id.two_cb)
        CheckBox twoCb;
        @BindView(R.id.two_image)
        ImageView twoImage;
        @BindView(R.id.two_title)
        TextView twoTitle;
        @BindView(R.id.two_text)
        TextView twoText;
        public MyHv(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
