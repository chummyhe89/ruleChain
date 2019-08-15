package com.hechunping.rule.core;

import lombok.Data;
import com.hechunping.rule.core.actor.NopRuleActor;
import com.hechunping.rule.core.actor.RuleActor;
import com.hechunping.rule.core.listener.DefaultRuleListenner;
import com.hechunping.rule.core.listener.RuleListenner;

/**
 * @author hechunping
 * date 2019/8/2 10:19
 * contact: hechunping@corp.netease.com
 * description:
 */
@Data
public abstract class AbstractRuleNode implements Rule{
    /**
     * rule name
     */
    protected String name;

    /**
     * rule description
     */
    protected String description;

    /**
     * rule priority
     */
    protected Integer priority;

    /**
     * 匹配后是否需要跳出规则链
     */
    protected Boolean positiveBreak=true;

    /**
     * 不匹配后是否需要跳出规则链
     */
    protected Boolean negativeBreak=false;

    /**
     * rule actioner
     */
    protected RuleActor ruleActor = NopRuleActor.INSTANCE;

    /**
     * rule listenner
     */
    protected RuleListenner ruleListenner = DefaultRuleListenner.INSTANCE;


    public AbstractRuleNode() {

    }

    public AbstractRuleNode(String name,String description,Integer priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String getRuleName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute(RuleContext ruleCxt) {
        if(ruleActor != null) {
            fireBeforeExecute(ruleCxt);
            try {
                ruleActor.action(this,ruleCxt);
                fireOnSuccess(ruleCxt);
            }catch (Exception e) {
                fireOnFailure(ruleCxt,e);
            }
        }
    }

    private void fireBeforeExecute(RuleContext ruleCxt){
        if(ruleListenner != null) {
            ruleListenner.beforeExecute(this,ruleCxt);
        }
    }

    private void fireOnSuccess(RuleContext ruleCxt) {
        if(ruleListenner != null) {
            ruleListenner.onSuccess(this,ruleCxt);
        }
    }

    private void fireOnFailure(RuleContext ruleCxt,Throwable e) {
        if(ruleListenner != null) {
            ruleListenner.onFailure(this,ruleCxt,e);
        }
    }

    @Override
    public int getPriority() {
        if(priority == null) {
            return Integer.MAX_VALUE;
        }else {
            return priority;
        }
    }

    @Override
    public int compareTo(Rule o) {
        return this.getPriority() - o.getPriority();
    }
}
