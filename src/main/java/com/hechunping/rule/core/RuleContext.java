package com.hechunping.rule.core;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hechunping
 * date 2019/8/2 12:39
 * contact: hechunping@corp.netease.com
 * description:
 */
@Getter
@Setter
public class RuleContext {

    /**
     * 规则结果信息
     */
    private Map<Rule,RuleResultCtx> ruleResultMap = new HashMap<>();
    /**
     * 规则入参
     */
    private Map<String,Object> inputMap = new HashMap<>();

    public Object getValue(String key) {
        return inputMap.get(key);
    }

    public void putValue(String key,Object value) {
        inputMap.put(key,value);
    }

    public void putRuleResult(Rule rule,RuleResultCtx resultCtx) {
        ruleResultMap.put(rule,resultCtx);
    }

    public void updateResultCtx(AbstractRuleNode ruleNode, Boolean success, Throwable e) {
        RuleResultCtx resultCtx = ruleResultMap.get(ruleNode);
        Preconditions.checkNotNull(resultCtx);
        resultCtx.setExecSuccess(success);
        resultCtx.setError(e);
    }
}
