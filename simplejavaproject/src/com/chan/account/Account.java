package com.chan.account;

public abstract class Account {

    protected int balance;

    protected int period;

    protected Account() {

    }

    public Account(int balance, int period) {
        this.balance = balance;
        this.period = period;
    }

    protected abstract boolean close();
}
