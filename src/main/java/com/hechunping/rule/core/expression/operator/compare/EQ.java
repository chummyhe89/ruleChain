package com.hechunping.rule.core.expression.operator.compare;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date: 2019-08-05 17:52
 * contact: hechunping@corp.netease.com
 * description:
 */
public class EQ<T extends Comparable<T>> extends BinaryOperator<T,T,Boolean> {
    public static final EQ INSTANCE = new EQ();
    public static final String SYMBOL = "eq";

    @Override
    public Boolean apply(T lhs, T rhs) {
        return lhs.compareTo(rhs) == 0;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
