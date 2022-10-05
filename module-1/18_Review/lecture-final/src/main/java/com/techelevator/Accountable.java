package com.techelevator;

import java.math.BigDecimal;

public interface Accountable {
    BigDecimal withdraw(BigDecimal amountToWithdraw);
    BigDecimal deposit(BigDecimal amountToDeposit);
}
