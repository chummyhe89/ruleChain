package com.hechunping.rule.core.expression.operator.compare;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date 2019/8/2 18:02
 * contact: hechunping@corp.netease.com
 * description:
 */
public class GT<T extends Comparable<T>> extends BinaryOperator<T,T,Boolean> {
    public static final GT INSTANCE = new GT();
    public static final String SYMBOL = "gt";

    @Override
    public Boolean apply(T lhs, T rhs) {
        return lhs.compareTo(rhs) > 0;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
