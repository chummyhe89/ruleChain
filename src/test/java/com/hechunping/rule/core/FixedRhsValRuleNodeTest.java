package com.hechunping.rule.core;

import com.hechunping.rule.core.expression.operator.compare.EQ;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.hechunping.rule.core.RuleEvalResult.EXEC_AND_BREAK;
import static com.hechunping.rule.core.RuleEvalResult.NOT_EXEC_AND_CONTINUE;
import static org.mockito.Mockito.*;

/**
 * @author hechunping
 * date: 2019/8/15 10:55
 * contact: hechunping@corp.netease.com
 * description:
 */
public class FixedRhsValRuleNodeTest {

    private FixedRhsValRuleNode<Long,Long> fixedRhsValRuleNode;
    private RuleContext ruleContext = spy(RuleContext.class);
    private static final String LEFT_KEY = "leftKey";

    @BeforeTest
    public void buildRuleNode() {
        fixedRhsValRuleNode = new FixedRhsValRuleNode("test","",1, EQ.INSTANCE,1L,LEFT_KEY);
    }

    @Test
    public void test() {
        doReturn(1L).when(ruleContext).getValue(LEFT_KEY);
        RuleEvalResult ret =  fixedRhsValRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,EXEC_AND_BREAK);
        doReturn(2L).when(ruleContext).getValue(LEFT_KEY);
        ret =  fixedRhsValRuleNode.evaluate(ruleContext);
        Assert.assertEquals(ret,NOT_EXEC_AND_CONTINUE);
    }
}
