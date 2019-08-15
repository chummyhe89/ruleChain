package com.hechunping.rule.core.expression.operator;

import com.hechunping.rule.core.expression.operator.compare.*;
import com.hechunping.rule.core.expression.operator.regex.RegExpFindOperator;
import com.hechunping.rule.core.expression.operator.regex.RegExpMatchAllOperator;
import com.hechunping.rule.core.expression.operator.regex.RegExpStartWithOperator;

/**
 * @author hechunping
 * date 2019/8/5 15:59
 * contact: hechunping@corp.netease.com
 * description:
 */
public class OperatorFactory {

    public static Operator getOperator(String name) {
        Operator ret = null;
        switch (name.toLowerCase()) {
            case GT.SYMBOL:
                ret = GT.INSTANCE;
                break;
            case GTE.SYMBOL :
                ret = GTE.INSTANCE;
                break;
            case LT.SYMBOL:
                ret = LT.INSTANCE;
                break;
            case LTE.SYMBOL:
                ret = LTE.INSTANCE;
                break;
            case EQ.SYMBOL:
                ret = EQ.INSTANCE;
                break;
            case ContainOperator.SYMBOL:
                ret = ContainOperator.INSTANCE;
                break;
            case RegExpFindOperator.SYMBOL:
                ret = RegExpFindOperator.INSTANCE;
                break;
            case RegExpMatchAllOperator.SYMBOL:
                ret = RegExpMatchAllOperator.INSTANCE;
                break;
            case RegExpStartWithOperator.SYMBOL:
                ret = RegExpStartWithOperator.INSTANCE;
                break;
            case NotOperator.SYMBOL:
                ret = NotOperator.INSTANCE;
                break;
            case IdentityOperator.SYMBOL:
                ret = IdentityOperator.INSTANCE;
                break;
            default:
                break;
        }
        return ret;
    }
}
