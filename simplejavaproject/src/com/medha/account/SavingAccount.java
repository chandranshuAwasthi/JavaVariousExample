package com.medha.account;

import com.chan.account.Account;

public class SavingAccount extends Account {
    @Override
    protected boolean close() {
        return false;
    }
}
