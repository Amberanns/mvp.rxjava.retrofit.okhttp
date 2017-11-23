package com.bawei.mvprjo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.mvprjo.adapter.Adapter;
import com.bawei.mvprjo.api.Api;
import com.bawei.mvprjo.bean.MyBean;
import com.bawei.mvprjo.persenter.Presenter;
import com.bawei.mvprjo.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview{

    private RecyclerView re;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re = (RecyclerView) findViewById(R.id.re);
        presenter = new Presenter(MainActivity.this);
        presenter.getok(Api.PATH);
    }

    @Override
    public void showList(List<MyBean.SongListBean> list) {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        re.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(list,MainActivity.this);
        re.setAdapter(adapter);
    }

    @Override
    public void showError(String e) {

    }
}
