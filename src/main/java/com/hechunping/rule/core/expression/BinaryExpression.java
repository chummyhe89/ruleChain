package com.hechunping.rule.core.expression;


import lombok.Getter;
import lombok.Setter;
import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date 2019/8/2 16:22
 * contact: hechunping@corp.netease.com
 * description:
 */
@Getter
@Setter
public class BinaryExpression<LHS,RHS,R> implements Expression<R>{
    private LHS lhs;
    private RHS rhs;
    private BinaryOperator<LHS,RHS,R> operator;

    public BinaryExpression() {

    }

    public BinaryExpression(LHS l, RHS r,BinaryOperator<LHS,RHS,R> operator) {
        this.lhs = l;
        this.rhs = r;
        this.operator = operator;
    }

    @Override
    public R value() {
        return operator.apply(lhs,rhs);
    }
}
