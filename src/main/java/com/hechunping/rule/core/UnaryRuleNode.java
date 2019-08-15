package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.Expression;
import com.hechunping.rule.core.expression.UnaryExpression;
import com.hechunping.rule.core.expression.operator.UnaryOperator;

/**
 * @author hechunping
 * date: 2019/8/15 10:15
 * contact: hechunping@corp.netease.com
 * description:
 */
public class UnaryRuleNode<T> extends AbstractUnaryRuleNode<T> {

    private String valKey;

    public UnaryRuleNode(String name, String description, Integer priority, UnaryOperator<T,Boolean> operator,String valKey) {
        super(name,description,priority,operator);
        this.valKey = valKey;
    }

    @Override
    public Expression buildExpr(RuleContext ruleCtx) {
        T val = (T)ruleCtx.getValue(valKey);
        return new UnaryExpression(val,operator);
    }
}
