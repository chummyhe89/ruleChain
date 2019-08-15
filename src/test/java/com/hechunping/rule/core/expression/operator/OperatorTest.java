package com.hechunping.rule.core.expression.operator;

import com.hechunping.rule.core.expression.operator.regex.RegExpFindOperator;
import static org.testng.Assert.*;

import com.hechunping.rule.core.expression.operator.regex.RegExpMatchAllOperator;
import com.hechunping.rule.core.expression.operator.regex.RegExpStartWithOperator;
import org.testng.annotations.Test;
import com.hechunping.rule.core.expression.operator.compare.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author hechunping
 * date: 2019/8/12 10:52
 * contact: hechunping@corp.netease.com
 * description:
 */
public class OperatorTest {

    private Pattern pattern = Pattern.compile("\\d+");
    private List<Integer> list = Arrays.asList(1,2,3,4);

    @Test
    public void testCompareOperator() {
        testEQ();
        testGT();
        testGTE();
        testLT();
        testLTE();
    }

    private void testEQ() {
        assertTrue(EQ.INSTANCE.apply(1,1));
        assertFalse(EQ.INSTANCE.apply(1,2));
    }

    private void testGT() {
        assertTrue(GT.INSTANCE.apply(2,1));
        assertFalse(GT.INSTANCE.apply(1,1));
        assertFalse(GT.INSTANCE.apply(1,2));
    }

    private void testGTE() {
        assertTrue(GTE.INSTANCE.apply(2,1));
        assertTrue(GTE.INSTANCE.apply(1,1));
        assertFalse(GTE.INSTANCE.apply(1,2));
    }

    private void testLT() {
        assertTrue(LT.INSTANCE.apply(1,2));
        assertFalse(LT.INSTANCE.apply(1,1));
        assertFalse(LT.INSTANCE.apply(2,1));
    }

    private void testLTE() {
        assertTrue(LTE.INSTANCE.apply(1,2));
        assertTrue(LTE.INSTANCE.apply(1,1));
        assertFalse(LTE.INSTANCE.apply(2,1));
    }

    @Test
    public void testRegexOperator() {
        testFind();
        testStartWith();
        testMatchAll();
    }

    private void testFind() {
        assertTrue(RegExpFindOperator.INSTANCE.apply("1a2",pattern));
        assertTrue(RegExpFindOperator.INSTANCE.apply("a12",pattern));
        assertFalse(RegExpFindOperator.INSTANCE.apply("ab",pattern));
    }

    private void testStartWith() {
        assertTrue(RegExpStartWithOperator.INSTANCE.apply("1a2",pattern));
        assertFalse(RegExpStartWithOperator.INSTANCE.apply("a12",pattern));
    }

    private void testMatchAll() {
        assertTrue(RegExpMatchAllOperator.INSTANCE.apply("12",pattern));
        assertFalse(RegExpMatchAllOperator.INSTANCE.apply("1a2",pattern));
        assertFalse(RegExpMatchAllOperator.INSTANCE.apply("a12",pattern));
        assertFalse(RegExpMatchAllOperator.INSTANCE.apply("12a",pattern));
    }

    @Test
    public void testContainOperator() {
        assertTrue(ContainOperator.INSTANCE.apply(list,1));
        assertFalse(ContainOperator.INSTANCE.apply(list,10));
    }

    @Test
    public void testNotOperator() {
        assertTrue(NotOperator.INSTANCE.apply(false));
        assertFalse(NotOperator.INSTANCE.apply(true));
    }
}
