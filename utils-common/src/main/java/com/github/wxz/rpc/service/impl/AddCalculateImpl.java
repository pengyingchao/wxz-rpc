package com.github.wxz.rpc.service.impl;

import com.github.wxz.rpc.service.AddCalculate;

/**
 * @author xianzhi.wang
 * @date 2017/12/19 -15:41
 */
public class AddCalculateImpl implements AddCalculate {
    /**
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
