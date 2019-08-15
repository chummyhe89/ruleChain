package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.Expression;
import com.hechunping.rule.core.expression.LiteralValue;
import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date: 2019/8/15 10:28
 * contact: hechunping@corp.netease.com
 * description:
 */
public class BinaryRuleNode<L,R> extends AbstractBinaryRuleNode<L,R>{

    private String leftKey;

    private String rightKey;

    public BinaryRuleNode(String name, String description, Integer priority, BinaryOperator<L,R,Boolean> operator,String leftKey,String rightKey) {
        super(name,description,priority,operator);
        this.leftKey = leftKey;
        this.rightKey = rightKey;
    }

    @Override
    public Expression<L> buildLeftExpr(RuleContext ruleCtx) {
        L leftVal = (L)ruleCtx.getValue(leftKey);
        return LiteralValue.of(leftVal);
    }

    @Override
    public Expression<R> buildRightExpr(RuleContext ruleCtx) {
        R rightVal = (R)ruleCtx.getValue(rightKey);
        return LiteralValue.of(rightVal);
    }
}
