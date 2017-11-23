package com.bawei.mvprjo.view;

import com.bawei.mvprjo.bean.MyBean;

import java.util.List;

/**
 * @author 郭丽君
 *         类的作用：
 */

public interface Iview {
    void showList(List<MyBean.SongListBean> list);
    void showError(String e);
}
