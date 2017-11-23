package com.bawei.mvprjo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mvprjo.R;
import com.bawei.mvprjo.bean.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<MyBean.SongListBean> list;
    Context context;

    public Adapter(List<MyBean.SongListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.itemImg.setImageURI(list.get(position).getPic_big());
        holder.title.setText(list.get(position).getTitle());
        holder.name.setText(list.get(position).getAuthor());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_img)
        SimpleDraweeView itemImg;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.name)
        TextView name;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
