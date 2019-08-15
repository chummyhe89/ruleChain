package com.hechunping.rule.core.listener;


import com.hechunping.rule.core.RuleContext;
import com.hechunping.rule.core.AbstractRuleNode;

/**
 * @author hechunping
 * date 2019/8/5 20:08
 * contact: hechunping@corp.netease.com
 * description:
 */
public class DefaultRuleListenner implements RuleListenner {
    public static final DefaultRuleListenner INSTANCE = new DefaultRuleListenner();
    @Override
    public void beforeExecute(AbstractRuleNode ruleNode, RuleContext ruleCxt) {

    }

    @Override
    public void onSuccess(AbstractRuleNode ruleNode, RuleContext ruleCxt) {
        ruleCxt.updateResultCtx(ruleNode,true,null);
    }

    @Override
    public void onFailure(AbstractRuleNode ruleNode, RuleContext ruleCxt, Throwable e) {
        ruleCxt.updateResultCtx(ruleNode,false,e);
    }
}
