package com.hechunping.rule.core.actor;

import com.hechunping.rule.core.RuleContext;
import com.hechunping.rule.core.AbstractRuleNode;

/**
 * @author hechunping
 * date 2019/8/2 19:21
 * contact: hechunping@corp.netease.com
 * description:
 */

public class NopRuleActor implements RuleActor {
    public static final NopRuleActor INSTANCE = new NopRuleActor();
    @Override
    public void action(AbstractRuleNode ruleNode, RuleContext ruleCxt) throws Exception {

    }
}
