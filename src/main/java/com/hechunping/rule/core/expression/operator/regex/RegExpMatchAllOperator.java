package com.hechunping.rule.core.expression.operator.regex;

import com.hechunping.rule.core.expression.operator.BinaryOperator;

import java.util.regex.Pattern;

/**
 * @author hechunping
 * date 2019/8/6 9:58
 * contact: hechunping@corp.netease.com
 * description:
 */
public class RegExpMatchAllOperator  extends BinaryOperator<String, Pattern,Boolean> {
    public static final String SYMBOL = "matchAll";
    public static final RegExpMatchAllOperator INSTANCE = new RegExpMatchAllOperator();

    @Override
    public Boolean apply(String s, Pattern pattern) {
        return pattern.matcher(s).matches();
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
