package com.chan.account;

public class CurrentTimedAccount extends Account {

    private int defaultperiod;

    @Override
    protected boolean close() {
        if (period > defaultperiod && balance > 0) {
            return true;
        }
        return false;
    }
}
