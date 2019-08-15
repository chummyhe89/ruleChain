package com.hechunping.rule.core.actor;

import com.hechunping.rule.core.RuleContext;
import com.hechunping.rule.core.AbstractRuleNode;

/**
 * @author hechunping
 * date 2019/8/2 10:35
 * contact: hechunping@corp.netease.com
 * description:
 */
public interface RuleActor {
    /**
     *
     * @throws Exception
     */
    void action(AbstractRuleNode ruleNode, RuleContext ruleCxt) throws Exception;
}
