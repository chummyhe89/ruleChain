package com.hechunping.rule.core.expression.operator;

/**
 * @author hechunping
 * date 2019/8/2 17:00
 * contact: hechunping@corp.netease.com
 * description:
 */
public abstract class UnaryOperator<IN,R> implements Operator{
    public abstract R apply(IN arg);

    @Override
    public int getArgNum() {
        return 1;
    }
}
