package com.hechunping.rule.core.expression.operator;

import java.util.Collection;

/**
 * @author hechunping
 * date 2019/8/6 9:32
 * contact: hechunping@corp.netease.com
 * description:
 */
public class ContainOperator<C extends Collection<E>,E> extends BinaryOperator<C,E,Boolean>  {
    public static final ContainOperator INSTANCE = new ContainOperator();
    public static final String SYMBOL = "contain";
    @Override
    public Boolean apply(C c, E e) {
        return c.contains(e);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }
}
