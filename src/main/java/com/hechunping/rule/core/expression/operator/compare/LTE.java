package com.hechunping.rule.core.expression.operator.compare;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date 2019/8/2 18:16
 * contact: hechunping@corp.netease.com
 * description:
 */
public class LTE<T extends Comparable<T>> extends BinaryOperator<T,T,Boolean> {
    public static final LTE INSTANCE = new LTE();
    public static final String SYMBOL = "lte";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public Boolean apply(T lhs, T rhs) {
        return lhs.compareTo(rhs) <= 0;
    }
}
