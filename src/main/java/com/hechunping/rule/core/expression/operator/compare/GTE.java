package com.hechunping.rule.core.expression.operator.compare;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date 2019/8/2 18:14
 * contact: hechunping@corp.netease.com
 * description:
 */
public class GTE<T extends Comparable<T>> extends BinaryOperator<T,T,Boolean> {
    public static final GTE INSTANCE = new GTE();
    public static final String SYMBOL = "gte";

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public Boolean apply(T lhs, T rhs) {
        return lhs.compareTo(rhs) >= 0;
    }
}
