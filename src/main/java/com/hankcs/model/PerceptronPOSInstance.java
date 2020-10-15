package com.hankcs.model;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.model.perceptron.model.LinearModel;

import java.io.IOException;

/**
 * Created on 2020/10/09
 *
 * @author Kenn
 */
public class PerceptronPOSInstance {

    //使用volatile关键字保其可见性
    volatile private static PerceptronPOSInstance instance = null;

    public static PerceptronPOSInstance getInstance() {
        if (instance == null) {
            synchronized (PerceptronPOSInstance.class) {
                if (instance == null) {//二次检查
                    instance = new PerceptronPOSInstance();
                }
            }
        }
        return instance;
    }

    private final LinearModel linearModel;

    private PerceptronPOSInstance() {
        LinearModel model;
        try {
            model = new LinearModel(HanLP.Config.PerceptronPOSModelPath);
        } catch (IOException e) {
            model = null;
        }
        linearModel = model;
    }

    public LinearModel getLinearModel() {
        return linearModel;
    }
}
