package com.hechunping.rule.core;

import static org.mockito.Mockito.*;
import static com.hechunping.rule.core.RuleEvalResult.*;

import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.hechunping.rule.core.expression.operator.compare.EQ;

/**
 * @author hechunping
 * date: 2019/8/12 9:58
 * contact: hechunping@corp.netease.com
 * description:
 */
public class CompareRuleNodeTest {

    @Spy
    private CompareRuleNode ruleNode;
    private RuleContext ruleContext;

    @BeforeTest
    public void setUp() {
        ruleContext = mock(RuleContext.class);
        when(ruleContext.getValue(anyString())).thenReturn(1);
        ruleNode = CompareRuleNode.CompareRuleNodeBuilder.create().name("ruleNodeTest").build();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testLhsKeyNotExist() {
        ruleNode.evaluate(ruleContext);
    }

    @Test
    public void testRuleMatched() {
        ruleNode.setOperator(EQ.INSTANCE);
        ruleNode.setRhsValue(1);
        ruleNode.setPositiveBreak(true);
        RuleEvalResult ret = ruleNode.evaluate(ruleContext);
        Assert.assertEquals(EXEC_AND_BREAK,ret);
        ruleNode.setPositiveBreak(false);
        ret = ruleNode.evaluate(ruleContext);
        Assert.assertEquals(EXEC_AND_CONTINUE,ret);
    }

    @Test
    public void testRuleMisMatched() {
        ruleNode.setOperator(EQ.INSTANCE);
        ruleNode.setRhsValue(2);
        ruleNode.setNegativeBreak(true);
        RuleEvalResult ret = ruleNode.evaluate(ruleContext);
        Assert.assertEquals(NOT_EXEC_AND_BREAK,ret);
        ruleNode.setNegativeBreak(false);
        ret = ruleNode.evaluate(ruleContext);
        Assert.assertEquals(NOT_EXEC_AND_CONTINUE,ret);
    }

}
