package com.hechunping.rule.core;

import static org.mockito.Mockito.*;
import static com.hechunping.rule.core.RuleEvalResult.*;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author hechunping
 * date: 2019/8/12 12:37
 * contact: hechunping@corp.netease.com
 * description:
 */
public class CompositeRuleNodeTest extends BaseRuleTest {

    private CompositeRuleNode compositeRuleNode = spy(new CompositeRuleNode());

    @Test
    public void mismatchedAndBreak() {
        compositeRuleNode.clearSubRule();
        reset(mismatchedBreak);
        doReturn(1).when(mismatchedBreak).getPriority();
        compositeRuleNode.addSubRuleNode(mismatchedBreak);
        RuleEvalResult ret  = compositeRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,NOT_EXEC_AND_BREAK);
        verify(mismatchedBreak,never()).execute(anyObject());
    }

    @Test
    public void mismatchedAndContinue() {
        compositeRuleNode.clearSubRule();
        reset(mismatchedContinue);
        reset(matchedContinueFst);
        doReturn(1).when(matchedContinueFst).getPriority();
        doReturn(2).when(mismatchedContinue).getPriority();
        compositeRuleNode.addSubRuleNode(matchedContinueFst);
        compositeRuleNode.addSubRuleNode(mismatchedContinue);
        RuleEvalResult ret  = compositeRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,NOT_EXEC_AND_CONTINUE);
        verify(matchedContinueFst,times(1)).execute(anyObject());
        verify(mismatchedContinue,never()).execute(anyObject());
    }

    @Test
    public void allMatchedAndContinue() {
        compositeRuleNode.clearSubRule();
        reset(matchedContinueFst);
        reset(matchedContinueScd);
        doReturn(1).when(matchedContinueFst).getPriority();
        doReturn(2).when(matchedContinueScd).getPriority();
        compositeRuleNode.addSubRuleNode(matchedContinueFst);
        compositeRuleNode.addSubRuleNode(matchedContinueScd);
        RuleEvalResult ret  = compositeRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,EXEC_AND_CONTINUE);
        verify(matchedContinueFst,times(1)).execute(anyObject());
        verify(matchedContinueScd,times(1)).execute(anyObject());
    }

    @Test
    public void allMatchedAndLastBreak() {
        compositeRuleNode.clearSubRule();
        reset(matchedContinueFst);
        reset(matchedContinueScd);
        reset(matchedBreak);
        doReturn(1).when(matchedContinueFst).getPriority();
        doReturn(2).when(matchedContinueScd).getPriority();
        doReturn(3).when(matchedContinueScd).getPriority();
        compositeRuleNode.addSubRuleNode(matchedContinueFst);
        compositeRuleNode.addSubRuleNode(matchedContinueScd);
        compositeRuleNode.addSubRuleNode(matchedBreak);
        RuleEvalResult ret  = compositeRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,EXEC_AND_BREAK);
        verify(matchedContinueFst,times(1)).execute(anyObject());
        verify(matchedContinueScd,times(1)).execute(anyObject());
        verify(matchedBreak,times(1)).execute(anyObject());
    }


}
