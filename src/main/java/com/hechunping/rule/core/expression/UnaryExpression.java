package com.hechunping.rule.core.expression;

import lombok.Getter;
import lombok.Setter;
import com.hechunping.rule.core.expression.operator.UnaryOperator;

/**
 * @author hechunping
 * date 2019/8/6 10:30
 * contact: hechunping@corp.netease.com
 * description:
 */
@Getter
@Setter
public class UnaryExpression<IN,R> implements Expression<R> {
    protected IN input;
    protected UnaryOperator<IN,R> operator;

    public UnaryExpression() {

    }

    public UnaryExpression(IN in,UnaryOperator<IN,R> operator) {
        this.input = in;
        this.operator = operator;
    }

    @Override
    public R value() {
        return operator.apply(input);
    }
}
