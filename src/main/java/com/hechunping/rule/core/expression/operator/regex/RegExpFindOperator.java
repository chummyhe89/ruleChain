package com.hechunping.rule.core.expression.operator.regex;


import com.hechunping.rule.core.expression.operator.BinaryOperator;
import java.util.regex.Pattern;

/**
 * @author hechunping
 * date 2019/8/6 9:46
 * contact: hechunping@corp.netease.com
 * description:
 */
public class RegExpFindOperator extends BinaryOperator<String, Pattern,Boolean> {
    public static final String SYMBOL = "find";
    public static final RegExpFindOperator INSTANCE = new RegExpFindOperator();

    @Override
    public Boolean apply(String s, Pattern pattern) {
        return pattern.matcher(s).find();
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
