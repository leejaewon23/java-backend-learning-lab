package org.example.banking;

public interface IMachine {
    boolean isActive() throws MachineNotWorkingException;
}
