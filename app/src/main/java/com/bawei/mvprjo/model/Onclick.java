package com.bawei.mvprjo.model;


import com.bawei.mvprjo.bean.MyBean;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public interface Onclick {
    void  datasuccess(List<MyBean.SongListBean> list);
    void  error(String rr);
}
