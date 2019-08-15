package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.Expression;
import com.hechunping.rule.core.expression.LiteralValue;
import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date: 2019/8/15 9:31
 * contact: hechunping@corp.netease.com
 * description: fixed right handle side value rule node
 */
public class FixedRhsValRuleNode<L,R> extends AbstractBinaryRuleNode<L,R> {

    private R rhsValue;

    private String lhsKey;

    public FixedRhsValRuleNode(String name, String description, Integer priority, BinaryOperator<L,R,Boolean> operator,R rhsValue,String lhsKey) {
        super(name,description,priority,operator);
        this.rhsValue = rhsValue;
        this.lhsKey = lhsKey;
    }

    @Override
    public Expression<L> buildLeftExpr(RuleContext ruleCtx) {
        Object lhsValue =  ruleCtx.getValue(lhsKey);
        L lhsVal = (L)lhsValue;
        return LiteralValue.of(lhsVal);
    }

    @Override
    public Expression<R> buildRightExpr(RuleContext ruleCtx) {
        return LiteralValue.of(rhsValue);
    }
}
