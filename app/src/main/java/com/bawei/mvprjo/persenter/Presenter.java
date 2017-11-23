package com.bawei.mvprjo.persenter;

import com.bawei.mvprjo.bean.MyBean;
import com.bawei.mvprjo.model.Imodel;
import com.bawei.mvprjo.model.Onclick;
import com.bawei.mvprjo.model.model;
import com.bawei.mvprjo.view.Iview;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class Presenter {
    Imodel imodel;
    Iview iview;

    public Presenter( Iview iview) {

        this.iview = iview;
        imodel=new model();
    }
    public  void getok(String url){
        imodel.Request(url, new Onclick() {
            @Override
            public void datasuccess(List<MyBean.SongListBean> list) {
                iview.showList(list);

            }

            @Override
            public void error(String rr) {
                iview.showError(rr);
            }
        });

    }
}
