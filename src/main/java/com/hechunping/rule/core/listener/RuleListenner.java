package com.hechunping.rule.core.listener;

import com.hechunping.rule.core.RuleContext;
import com.hechunping.rule.core.AbstractRuleNode;

/**
 * @author hechunping
 * date 2019/8/2 11:52
 * contact: hechunping@corp.netease.com
 * description:
 */
public interface RuleListenner {
    /**
     * 规则执行前做的准备工作
     * @param ruleNode 规则节点
     * @param ruleCxt 规则上下文信息
     */
    void beforeExecute(AbstractRuleNode ruleNode, RuleContext ruleCxt);

    /**
     * 规则执行成功后需要进行的操作
     * @param ruleNode 规则节点
     * @param ruleCxt 规则上下文信息
     */
    void onSuccess(AbstractRuleNode ruleNode, RuleContext ruleCxt);

    /**
     * 规则执行失败
     * @param ruleNode 规则节点
     * @param ruleCxt 规则上下文信息
     */
    void onFailure(AbstractRuleNode ruleNode, RuleContext ruleCxt, Throwable e);
}
