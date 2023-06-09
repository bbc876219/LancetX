package com.knightboost.lancetx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProxyThread extends Thread{

    public ProxyThread(){
        System.out.println("ProxyThread created"+this);
    }

    public ProxyThread(@Nullable Runnable target) {
        super(target);
        System.out.println("ProxyThread created"+this+target);
    }

    public ProxyThread(@NonNull String name) {
        super(name);
        System.out.println("ProxyThread created"+this+name);
    }
}
