package com.knightboost.lancetx.weaver;

import com.knightboost.lancet.api.annotations.ChangeClassExtends;
import com.knightboost.lancet.api.annotations.Group;
import com.knightboost.lancet.api.annotations.Weaver;
import com.knightboost.lancetx.ProxyThread;

@Weaver
@Group("ExtendTest")
public class ExtendWeave {

    @ChangeClassExtends(
            beforeExtend = "java.lang.Thread",
            afterExtend = "com.knightboost.lancetx.ProxyThread",
            classNameFilterRegex = ""
    )
    public void extendThreadChange(){};
}
