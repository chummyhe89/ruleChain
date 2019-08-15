package com.hechunping.rule.core.expression.operator.regex;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

import java.util.regex.Pattern;

/**
 * @author hechunping
 * date 2019/8/6 10:11
 * contact: hechunping@corp.netease.com
 * description:
 */
public class RegExpStartWithOperator extends BinaryOperator<String, Pattern,Boolean> {
    public static final String SYMBOL = "startWith";
    public static final RegExpStartWithOperator INSTANCE = new RegExpStartWithOperator();

    @Override
    public Boolean apply(String s, Pattern pattern) {
        return pattern.matcher(s).lookingAt();
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
