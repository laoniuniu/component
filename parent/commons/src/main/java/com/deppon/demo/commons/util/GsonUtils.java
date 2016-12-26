package com.deppon.demo.commons.util;

import com.deppon.demo.commons.model.BaseDO;
import com.google.gson.Gson;

/**
 * gson类
 *
 * @author <a href="mailto:yihui#pamirs.top">yihui</a>
 * @version 1.0
 * @since 2016/12/5 下午10:46
 */
public class GsonUtils {

    private static class GsonHolder {
        private static final Gson INSTANCE = new Gson();
    }

    /**
     * 获取Gson实例，由于Gson是线程安全的，这里共同使用同一个Gson实例
     */
    public static Gson getInstance() {
        return GsonHolder.INSTANCE;
    }

    private static <T> T fromJson(String json, Class<T> clazz){
        return GsonUtils.getInstance().fromJson(json, clazz);
    }

    public static void main(String[] args){
        GsonUtils.fromJson("{}", BaseDO.class);
    }

}
