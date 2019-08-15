package com.hechunping.rule.core;

import java.util.*;

/**
 * @author hechunping
 * date 2019/8/2 15:24
 * contact: hechunping@corp.netease.com
 * description: 组合规则节点
 */
public class CompositeRuleNode  extends AbstractRuleNode {

    public List<AbstractRuleNode> ruleNodes = new ArrayList<>();

    @Override
    public RuleEvalResult evaluate(RuleContext ruleCxt) {
        List<RuleEvalResult> rets = new ArrayList<>();
        AbstractRuleNode last = ruleNodes.get(ruleNodes.size() - 1);
        RuleEvalResult ret = RuleEvalResult.EXEC_AND_CONTINUE;
        for(AbstractRuleNode ruleNode: ruleNodes) {
            ret = ruleNode.evaluate(ruleCxt);
            ruleCxt.putRuleResult(ruleNode,RuleResultCtx.of(ruleNode,ret));
            if(ret.isNeedExec()) {
                ruleNode.execute(ruleCxt);
            }
            if(ret.isNeedBreak() && !ruleNode.equals(last)) {
                return RuleEvalResult.NOT_EXEC_AND_BREAK;
            }
            rets.add(ret);
        }

        boolean allNeedExec = rets.stream().allMatch(r -> r.isNeedExec());

        RuleResultCtx rc = new RuleResultCtx();
        rc.setEvalResult(ret);
        rc.setRule(this);
        rc.setExecSuccess(allNeedExec);
        ruleCxt.putRuleResult(this, rc);

        if(allNeedExec) {
            //最后一个子项Break
            if(ret.isNeedBreak()) {
                return RuleEvalResult.EXEC_AND_BREAK;
            }
            return RuleEvalResult.EXEC_AND_CONTINUE;
        }else{
            return RuleEvalResult.NOT_EXEC_AND_CONTINUE;
        }
    }

    public void addSubRuleNode(AbstractRuleNode ruleNode) {
        ruleNodes.add(ruleNode);
        Collections.sort(ruleNodes);
    }

    public void clearSubRule() {
        ruleNodes.clear();
    }
}
