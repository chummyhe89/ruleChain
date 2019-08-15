package com.hechunping.rule.core;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hechunping
 * date 2019/8/2 10:52
 * contact: hechunping@corp.netease.com
 * description:
 */
public class RuleChain {

    private List<Rule> rules = new ArrayList<>();

    public void applyRule(RuleContext ruleCxt) {
        for(Rule rule : rules) {
           RuleEvalResult ret =  rule.evaluate(ruleCxt);
           ruleCxt.putRuleResult(rule,RuleResultCtx.of(rule,ret));
           if(ret.isNeedExec()) {
               rule.execute(ruleCxt);
           }
           if(ret.isNeedBreak()) {
               break;
           }
        }
    }

    public void addRule(Rule rule){
        rules.add(rule);
        Collections.sort(rules);
    }

    public void clear() {
        rules.clear();
    }
}
