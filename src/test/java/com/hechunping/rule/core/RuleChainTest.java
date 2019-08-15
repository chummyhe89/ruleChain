package com.hechunping.rule.core;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * @author hechunping
 * date: 2019/8/12 12:36
 * contact: hechunping@corp.netease.com
 * description:
 */
public class RuleChainTest extends BaseRuleTest {
    private RuleChain ruleChain = spy(new RuleChain());


    @Test
    public void allMatchedAndContinue() {
        ruleChain.clear();
        reset(matchedContinueFst);
        reset(matchedContinueScd);
        doReturn(1).when(matchedContinueFst).getPriority();
        doReturn(2).when(matchedContinueScd).getPriority();
        ruleChain.addRule(matchedContinueFst);
        ruleChain.addRule(matchedContinueScd);
        ruleChain.applyRule(ruleContext);
        Assert.assertEquals(ruleContext.getRuleResultMap().size(),2);
        verify(matchedContinueFst,times(1)).execute(ruleContext);
        verify(matchedContinueScd,times(1)).execute(ruleContext);
    }

    @Test
    public void oneMismatchedAndBreak() {
        ruleChain.clear();
        reset(matchedContinueFst);
        reset(mismatchedBreak);
        reset(matchedContinueScd);
        doReturn(1).when(matchedContinueFst).getPriority();
        doReturn(2).when(mismatchedBreak).getPriority();
        doReturn(3).when(matchedContinueScd).getPriority();
        ruleChain.addRule(matchedContinueFst);
        ruleChain.addRule(mismatchedBreak);
        ruleChain.addRule(matchedContinueScd);
        ruleChain.applyRule(ruleContext);
        Assert.assertEquals(ruleContext.getRuleResultMap().size(),2);
        verify(matchedContinueFst,times(1)).execute(ruleContext);
        verify(mismatchedBreak,never()).execute(ruleContext);
        verify(matchedContinueScd,never()).execute(ruleContext);
    }
}
