package com.hechunping.rule.core;


import lombok.Getter;
import lombok.Setter;

/**
 * @author hechunping
 * date 2019/8/5 19:24
 * contact: hechunping@corp.netease.com
 * description: 规则结果信息
 */
@Getter
@Setter
public class RuleResultCtx {
    private Rule rule;
    private RuleEvalResult evalResult;
    private Boolean execSuccess;
    private Throwable error;

    public RuleResultCtx() {

    }


    public RuleResultCtx(Rule rule,RuleEvalResult evalResult) {
        this.rule = rule;
        this.evalResult = evalResult;
    }

    public static RuleResultCtx of(Rule rule,RuleEvalResult evalResult) {
        return new RuleResultCtx(rule,evalResult);
    }
}
