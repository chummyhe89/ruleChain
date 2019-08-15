package com.hechunping.rule.core;


import lombok.Getter;

/**
 * @author hechunping
 * date 2019/8/2 10:27
 * contact: hechunping@corp.netease.com
 * description:
 */
@Getter
public enum RuleEvalResult {
    EXEC_AND_BREAK(true,true),
    NOT_EXEC_AND_BREAK(true,false),
    EXEC_AND_CONTINUE(false,true),
    NOT_EXEC_AND_CONTINUE(false,false);

    private boolean needBreak;
    private boolean needExec;

    RuleEvalResult(boolean needBreak,boolean needExec) {
        this.needBreak = needBreak;
        this.needExec = needExec;
    }
}
