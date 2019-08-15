package com.hechunping.rule.core.expression.operator;

/**
 * @author hechunping
 * date 2019/8/2 17:02
 * contact: hechunping@corp.netease.com
 * description:
 */
public abstract class BinaryOperator<LHS,RHS,R> implements Operator {
    public abstract R apply(LHS lhs,RHS rhs);

    @Override
    public int getArgNum() {
        return 2;
    }
}
