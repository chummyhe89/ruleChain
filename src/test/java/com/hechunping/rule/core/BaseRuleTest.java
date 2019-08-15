package com.hechunping.rule.core;

import static org.mockito.Mockito.*;
import org.testng.annotations.BeforeTest;
import com.hechunping.rule.core.expression.operator.compare.EQ;

/**
 * @author hechunping
 * date: 2019/8/12 14:48
 * contact: hechunping@corp.netease.com
 * description:
 */
public class BaseRuleTest {

    protected RuleContext ruleContext = spy(RuleContext.class);
    protected AbstractRuleNode matchedContinueFst;
    protected AbstractRuleNode matchedContinueScd;
    protected AbstractRuleNode mismatchedContinue;
    protected AbstractRuleNode matchedBreak;
    protected AbstractRuleNode mismatchedBreak;
    @BeforeTest
    public void setUp() {
        doReturn(1).when(ruleContext).getValue(anyString());
        matchedContinueFst = spy(CompareRuleNode.CompareRuleNodeBuilder.create().name("matchedContinueFst").rhsValue(1).positiveBreak(false).operator(EQ.INSTANCE).priority(1).build());
        matchedContinueScd = spy(CompareRuleNode.CompareRuleNodeBuilder.create().name("matchedContinueScd").rhsValue(1).positiveBreak(false).operator(EQ.INSTANCE).priority(2).build());
        mismatchedContinue = spy(CompareRuleNode.CompareRuleNodeBuilder.create().name("mismatchedNotBreak").rhsValue(2).negativeBreak(false).operator(EQ.INSTANCE).priority(3).build());
        matchedBreak = spy(CompareRuleNode.CompareRuleNodeBuilder.create().name("matchedBreak").rhsValue(1).positiveBreak(true).operator(EQ.INSTANCE).priority(4).build());
        mismatchedBreak = spy(CompareRuleNode.CompareRuleNodeBuilder.create().name("mismatchedBreak").rhsValue(2).negativeBreak(true).operator(EQ.INSTANCE).priority(5).build());
    }

}
