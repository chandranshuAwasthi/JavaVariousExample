package com.chan.account;

public class CurrentAccount extends Account {

    public CurrentAccount() {
    }

    public CurrentAccount(int balance, int period) {
        super(balance, period);
    }

    @Override
    public boolean close() {
        return false;
    }
}
