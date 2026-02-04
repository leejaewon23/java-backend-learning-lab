package org.example.banking;

public class SendMachine implements IMachine {
    @Override
	public boolean isActive() throws MachineNotWorkingException {
		if ( Math.random() >= 0.3 ) {
			return true;
		} else {
			throw new MachineNotWorkingException("Machine broken !!");
		}
	}
}
