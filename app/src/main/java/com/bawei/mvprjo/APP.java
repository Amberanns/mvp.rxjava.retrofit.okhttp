package com.bawei.mvprjo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class APP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }}
