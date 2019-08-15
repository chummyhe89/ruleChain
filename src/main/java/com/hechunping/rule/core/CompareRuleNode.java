package com.hechunping.rule.core;


import lombok.Getter;
import lombok.Setter;
import com.hechunping.rule.core.actor.NopRuleActor;
import com.hechunping.rule.core.actor.RuleActor;
import com.hechunping.rule.core.expression.operator.BinaryOperator;
import com.hechunping.rule.core.listener.DefaultRuleListenner;
import com.hechunping.rule.core.listener.RuleListenner;

/**
 * @author hechunping
 * date 2019/8/2 14:08
 * contact: hechunping@corp.netease.com
 * description:
 */
@Getter
@Setter
public class CompareRuleNode<T extends Comparable<T>> extends AbstractRuleNode {

    /**
     * compare operator
     */
    protected BinaryOperator<T,T,Boolean> operator;

    /**
     * right hand side value
     */
    protected T rhsValue;

    /**
     * left hand side value key
     */
    protected String lhsKey;

    /**
     * 匹配后是否需要跳出规则链
     */
    protected Boolean positiveBreak=true;

    /**
     * 不匹配后是否需要跳出规则链
     */
    protected Boolean negativeBreak=false;

    @Override
    public RuleEvalResult evaluate(RuleContext ruleCxt) {
        T lhsValue = (T)ruleCxt.getValue(lhsKey);
        if( lhsValue == null) {
            throw new RuntimeException("left hand size value is null");
        }
        Boolean isMatch = operator.apply(lhsValue,rhsValue);
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

    public static class CompareRuleNodeBuilder<T extends Comparable<T>> {

        /**
         * rule name
         */
        private String name;

        /**
         * rule description
         */
        private String description;

        /**
         * rule priority
         */
        private Integer priority;

        /**
         * rule actioner
         */
        private RuleActor ruleActor = NopRuleActor.INSTANCE;

        /**
         * rule listenner
         */
        private RuleListenner ruleListenner = DefaultRuleListenner.INSTANCE;

        /**
         * compare operator
         */
        private BinaryOperator<T,T,Boolean> operator;

        /**
         * right hand side value
         */
        private T rhsValue;

        /**
         * left hand side value key
         */
        private String lhsKey;

        private Boolean positiveBreak=true;

        private Boolean negativeBreak=false;

        public CompareRuleNodeBuilder<T> name(String name) {
            this.name = name;
            return this;
        }

        public CompareRuleNodeBuilder<T> description(String description) {
            this.description = description;
            return this;
        }

        public CompareRuleNodeBuilder<T> priority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public CompareRuleNodeBuilder<T> ruleActioner(RuleActor ruleActor) {
            this.ruleActor = ruleActor;
            return this;
        }

        public CompareRuleNodeBuilder<T> ruleListenner(RuleListenner ruleListenner) {
            this.ruleListenner = ruleListenner;
            return this;
        }

        public CompareRuleNodeBuilder<T> operator(BinaryOperator<T,T,Boolean> operator) {
            this.operator = operator;
            return this;
        }

        public CompareRuleNodeBuilder<T> rhsValue(T rhsValue) {
            this.rhsValue = rhsValue;
            return this;
        }

        public CompareRuleNodeBuilder<T> lhsKey(String lhsKey) {
            this.lhsKey = lhsKey;
            return this;
        }

        public CompareRuleNodeBuilder<T> positiveBreak(Boolean positiveBreak) {
            this.positiveBreak = positiveBreak;
            return this;
        }

        public CompareRuleNodeBuilder<T> negativeBreak(Boolean negativeBreak) {
            this.negativeBreak = negativeBreak;
            return this;
        }

        public static <K extends Comparable<K>> CompareRuleNodeBuilder create() {
            return new CompareRuleNodeBuilder<K>();
        }

        public CompareRuleNode<T> build() {
            CompareRuleNode<T> ruleNode = new CompareRuleNode<>();
            ruleNode.setName(name);
            ruleNode.setDescription(description);
            ruleNode.setPriority(priority);
            ruleNode.setRuleActor(ruleActor);
            ruleNode.setRuleListenner(ruleListenner);
            ruleNode.setLhsKey(lhsKey);
            ruleNode.setRhsValue(rhsValue);
            ruleNode.setOperator(operator);
            ruleNode.setPositiveBreak(positiveBreak);
            ruleNode.setNegativeBreak(negativeBreak);
            return ruleNode;
        }
    }
}
