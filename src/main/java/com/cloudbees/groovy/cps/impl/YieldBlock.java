package com.cloudbees.groovy.cps.impl;

import com.cloudbees.groovy.cps.Block;
import com.cloudbees.groovy.cps.Continuable;
import com.cloudbees.groovy.cps.Continuation;
import com.cloudbees.groovy.cps.Env;
import com.cloudbees.groovy.cps.Next;

/**
 * Yield a value and suspend the execution of the program.
 *
 * @author Kohsuke Kawaguchi
 * @see Continuable#suspend(Object)
 */
public class YieldBlock implements Block {
    private final Object v;

    public YieldBlock(Object v) {
        this.v = v;
    }

    public Next eval(Env e, Continuation k) {
        Next next = new Next(NOOP, null, k);
        next.yield(v);
        return next;
    }

    private static final long serialVersionUID = 1L;
}
