package model.entities;

import java.io.Serializable;

public class BankSystem implements Serializable {
    static final long serialVersionUID = 43L;
    public MainBank[] banks;

    public BankSystem() {
        banks = new MainBank[3];
        MainBank bank1 = new Bank1(30f, 14f, 84f, 44, 90);
        MainBank bank2 = new Bank2(31f, 15f, 85f, 45, 91);
        MainBank bank3 = new Bank3(32f, 16f, 86f, 46, 92);
        banks[0] = bank1;
        banks[1] = bank2;
        banks[2] = bank3;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BankSystem)) {
            return false;
        }

        BankSystem bankSystem = (BankSystem) o;

        return bankSystem.banks == ((BankSystem) o).banks;

    }
}
