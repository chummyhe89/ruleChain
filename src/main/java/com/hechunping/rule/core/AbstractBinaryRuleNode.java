package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.Expression;
import com.hechunping.rule.core.expression.operator.BinaryOperator;

/**
 * @author hechunping
 * date: 2019/8/14 20:35
 * contact: hechunping@corp.netease.com
 * description:
 */
public abstract class AbstractBinaryRuleNode<L,R> extends AbstractRuleNode {

    /**
     * 比较符号
     */
    protected BinaryOperator<L,R,Boolean> operator;

    public AbstractBinaryRuleNode(String name,String description,Integer priority,BinaryOperator<L,R,Boolean> operator) {
        super(name,description,priority);
        this.operator = operator;
    }

    /**
     *
     * @param ruleCtx
     * @return
     */
    public abstract Expression<L> buildLeftExpr(RuleContext  ruleCtx);

    /**
     *
     * @param ruleCtx
     * @return
     */
    public abstract Expression<R> buildRightExpr(RuleContext  ruleCtx);

    @Override
    public RuleEvalResult evaluate(RuleContext ruleCtx) {
        Expression<L> leftExp = buildLeftExpr(ruleCtx);
        Expression<R> rightExp = buildRightExpr(ruleCtx);
        Boolean isMatch = operator.apply(leftExp.value(),rightExp.value());
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
