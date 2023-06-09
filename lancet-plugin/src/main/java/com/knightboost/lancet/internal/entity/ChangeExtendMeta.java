package com.knightboost.lancet.internal.entity;


import java.util.regex.Pattern;

public class ChangeExtendMeta {

    /**
     * lei
     */
    private String classNameFilterRegex;
    private String beforeExtend;
    private String afterExtend;
    private Pattern pattern;

    public ChangeExtendMeta(String beforeExtend, String afterExtend) {
        this.beforeExtend = beforeExtend;
        this.afterExtend = afterExtend;
    }

    public String getBeforeExtend() {
        return beforeExtend;
    }

    public void setBeforeExtend(String beforeExtend) {
        this.beforeExtend = beforeExtend;
    }

    public String getAfterExtend() {
        return afterExtend;
    }

    public void setClassNameFilterRegex(String filterRegex) {
        if (null != filterRegex && filterRegex.length() > 0) {
            pattern = Pattern.compile(filterRegex);
        }
    }

    public boolean isMatch(String className){
            return pattern == null || pattern.matcher(className).matches();
    }

    public void setAfterExtend(String afterExtend) {
        this.afterExtend = afterExtend;
    }

    @Override
    public String toString() {
        return "ChangeExtendMeta{" +
                "classNameFilterRegex='" + classNameFilterRegex + '\'' +
                ", beforeExtend='" + beforeExtend + '\'' +
                ", afterExtend='" + afterExtend + '\'' +
                ", pattern=" + pattern +
                '}';
    }
}
