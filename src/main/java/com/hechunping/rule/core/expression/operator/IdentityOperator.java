package com.hechunping.rule.core.expression.operator;

/**
 * @author hechunping
 * date: 2019/8/14 20:28
 * contact: hechunping@corp.netease.com
 * description:
 */
public class IdentityOperator<T> extends UnaryOperator<T,T>{
    public static final IdentityOperator INSTANCE = new IdentityOperator();
    public static final String SYMBOL = "identity";
    @Override
    public T apply(T arg) {
        return arg;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
