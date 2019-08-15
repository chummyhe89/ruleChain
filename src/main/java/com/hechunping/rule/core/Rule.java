package com.hechunping.rule.core;

/**
 * @author hechunping
 * date 2019/8/2 9:57
 * contact: hechunping@corp.netease.com
 * description:
 */
public interface Rule extends Comparable<Rule>{
    /**
     * 规则名称
     * @return
     */
    String getRuleName();

    /**
     * 规则描述
     * @return
     */
    String getDescription();

    /**
     * 规则优先级,越小优先级越高
     * @return
     */
    int getPriority();

    /**
     * 触发条件评估
     * @return
     */
    RuleEvalResult evaluate(RuleContext ruleCxt);

    /**
     * 执行决策
     */
    void execute(RuleContext ruleCxt);
}
