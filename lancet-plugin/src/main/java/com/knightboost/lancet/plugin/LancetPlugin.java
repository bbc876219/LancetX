package com.knightboost.lancet.plugin;

import com.android.build.api.transform.Transform;
import com.android.build.gradle.AppExtension;
import com.knightboost.lancet.internal.asm.visitor.WeaveTransformer;
import com.knightboost.lancet.internal.log.WeaverLog;
import com.knightboost.lancet.internal.parser.WeaverClassesParser;
import com.knightboost.lancet.api.annotations.Weaver;
import com.ss.android.ugc.bytex.common.CommonPlugin;
import com.ss.android.ugc.bytex.common.TransformConfiguration;
import com.ss.android.ugc.bytex.common.flow.TransformFlow;
import com.ss.android.ugc.bytex.common.flow.main.MainTransformFlow;
import com.ss.android.ugc.bytex.common.flow.main.Process;
import com.ss.android.ugc.bytex.common.log.ILogger;
import com.ss.android.ugc.bytex.common.visitor.ClassVisitorChain;
import com.ss.android.ugc.bytex.pluginconfig.anno.PluginConfig;
import com.ss.android.ugc.bytex.transformer.TransformContext;
import com.ss.android.ugc.bytex.transformer.TransformEngine;
import com.ss.android.ugc.bytex.transformer.utils.FetchStackTrace;

import org.gradle.api.Project;
import org.gradle.internal.reflect.Instantiator;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.Nonnull;


@PluginConfig("LancetX")
public class LancetPlugin extends CommonPlugin<LancetExtension, LancetContext> {

    private ILogger logger;
    private WeaverClassesParser weaverClassesParser;
    @Override
    protected LancetContext getContext(Project project,
                                       AppExtension android,
                                       LancetExtension extension) {
        LancetContext lancetContext = new LancetContext(project, android, extension);
        return lancetContext;
    }

    @Override
    protected void onApply(@Nonnull @NotNull Project project) {
        super.onApply(project);
    }

    @Override
    public void init() {
        super.init();
        WeaverLog.w("init() called");
        logger = context.getLogger();
        LancetContext.setInstance(context);
        weaverClassesParser = new WeaverClassesParser();
    }

    int index4 =1;
    @Override
    public void traverse(@Nonnull String relativePath, @Nonnull org.objectweb.asm.tree.ClassNode node) {
        List<AnnotationNode> annotations = node.visibleAnnotations;
        if (annotations != null) {
            for (AnnotationNode annotationNode : annotations) {
                if (annotationNode.desc.equals(Type.getDescriptor(Weaver.class))) {
                    //this is weave class
                    WeaverLog.w("traverse() called with: relativePath = [" + relativePath + "], node = [" + node + "]");
                    if (index4>0){
                        WeaverLog.w(FetchStackTrace.getStackTraceString(new Throwable()));
                        index4=0;
                    }
                    weaverClassesParser.addWeaverClass(node);
                }
            }
        }
        super.traverse(relativePath, node);
    }
    int index=3,index2=3,index3=1;
    @Override
    public void beforeTransform(@Nonnull @NotNull TransformEngine engine) {
        super.beforeTransform(engine);
        if (index>0){
            index=0;
            WeaverLog.w("start beforeTransform() \n" + FetchStackTrace.getStackTraceString(new Throwable()));
        }

        weaverClassesParser.graph = context.getClassGraph();
        weaverClassesParser.parse();

        LancetContext.instance().getLogger()
                .i("transform info \n" + LancetContext.instance().getTransformInfo());
    }

    @Override
    public boolean transform(@Nonnull String relativePath, @Nonnull ClassVisitorChain chain) {
        if (index2>0){

            index2=0;
            WeaverLog.w( "transform() called with: relativePath = [" + relativePath + "], chain = [" + chain + "]\n"+ FetchStackTrace.getStackTraceString(new Throwable()));
        }

        WeaveTransformer weaveTransformer = new WeaveTransformer(
                context.getClassGraph());
        weaveTransformer.initVisitorChain(chain);

        return true;
    }


    @Override
    protected TransformFlow provideTransformFlow(@Nonnull MainTransformFlow mainFlow, @Nonnull TransformContext transformContext) {
        WeaverLog.w( "provideTransformFlow() called with: mainFlow = [" + mainFlow + "], transformContext = [" + transformContext + "]");
        return super.provideTransformFlow(mainFlow, transformContext);
    }


    @Override
    protected Transform getTransform() {
        WeaverLog.w( "getTransform() called");
        return super.getTransform();
    }

    @Nonnull
    @Override
    public TransformConfiguration transformConfiguration() {
        return new TransformConfiguration() {
            @Override
            public boolean isIncremental() {
                return false;
            }
        };
    }

    @Override
    protected LancetExtension createExtension(Instantiator instantiator,
                                              Class<LancetExtension> clazz) {
        LancetExtension extension = instantiator.newInstance(clazz, project);
        return extension;
    }

    @Override
    public int flagForClassReader(Process process) {
        switch (process) {
            case TRAVERSE:
            case TRAVERSE_ANDROID:
            case TRANSFORM:
                return ClassReader.SKIP_DEBUG
                        | ClassReader.SKIP_FRAMES
                        | ClassReader.EXPAND_FRAMES;
            default:
                return 0;
        }
    }

    // @Override
    // public int flagForClassWriter() {
    //     return 0;
    // }
}
