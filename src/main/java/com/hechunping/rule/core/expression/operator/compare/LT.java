package com.hechunping.rule.core.expression.operator.compare;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date 2019/8/2 18:16
 * contact: hechunping@corp.netease.com
 * description:
 */
public class LT<T extends Comparable<T>> extends BinaryOperator<T,T,Boolean> {
    public static final LT INSTANCE = new LT();
    public static final String SYMBOL = "lt";

    @Override
    public Boolean apply(T lhs, T rhs) {
        return lhs.compareTo(rhs) < 0;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
