package com.hechunping.rule.core.expression;

import com.hechunping.rule.core.expression.operator.IdentityOperator;

/**
 * @author hechunping
 * date: 2019/8/15 9:35
 * contact: hechunping@corp.netease.com
 * description:
 */
public class LiteralValue<T> extends UnaryExpression<T,T> {

    public LiteralValue(T input) {
        super(input,IdentityOperator.INSTANCE);
    }

    public static <TYPE> LiteralValue of(TYPE rawValue) {
        return new LiteralValue(rawValue);
    }
}
