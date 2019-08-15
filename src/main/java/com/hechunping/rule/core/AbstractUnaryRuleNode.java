package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.Expression;
import com.hechunping.rule.core.expression.operator.UnaryOperator;

/**
 * @author hechunping
 * date: 2019/8/15 9:15
 * contact: hechunping@corp.netease.com
 * description:
 */
public abstract class AbstractUnaryRuleNode<T> extends AbstractRuleNode {

    /**
     * 一元操作符号
     */
    protected UnaryOperator<T,Boolean> operator;

    public AbstractUnaryRuleNode(String name, String description, Integer priority, UnaryOperator<T,Boolean> operator) {
        super(name,description,priority);
        this.operator = operator;
    }

    public abstract Expression<T> buildExpr(RuleContext  ruleCtx);

    @Override
    public RuleEvalResult evaluate(RuleContext ruleCxt) {
        Expression<T> expression = buildExpr(ruleCxt);
        Boolean isMatch = operator.apply(expression.value());
        if(isMatch) {
            if(positiveBreak) {
                return RuleEvalResult.EXEC_AND_BREAK;
            }
            return RuleEvalResult.EXEC_AND_CONTINUE;
        }else {
            if(negativeBreak) {
                return RuleEvalResult.NOT_EXEC_AND_BREAK;
            }
            return RuleEvalResult.NOT_EXEC_AND_CONTINUE;
        }
    }
}
