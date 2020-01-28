package com.bawei.dome33.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bawei.dome33.R;
import com.bawei.dome33.entity.ListEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHv> {
    Context context;
    List<ListEntity.OrderDataBean> list;


    public ListAdapter(Context context, List<ListEntity.OrderDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.one_item, null);
        MyHv myHv = new MyHv(inflate);
        return myHv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHv holder, int position) {
        holder.oneName.setText( list.get(position).getShopName());
        List<ListEntity.OrderDataBean.CartlistBean> cartlist = list.get(position).getCartlist();
        TwoAdapter twoAdapter = new TwoAdapter(context, cartlist);
        holder.oneRv.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
        holder.oneRv.setAdapter(twoAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHv extends RecyclerView.ViewHolder {
        @BindView(R.id.one_cb)
        CheckBox oneCb;
        @BindView(R.id.one_name)
        TextView oneName;
        @BindView(R.id.one_rv)
        RecyclerView oneRv;
        public MyHv(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
