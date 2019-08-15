package com.hechunping.rule.core.expression.operator;

/**
 * @author hechunping
 * date 2019/8/6 10:15
 * contact: hechunping@corp.netease.com
 * description:
 */
public class NotOperator extends UnaryOperator<Boolean,Boolean> {
    public static final NotOperator INSTANCE = new NotOperator();
    public static final String SYMBOL = "not";
    @Override
    public Boolean apply(Boolean arg) {
        return !arg;
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
