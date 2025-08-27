/*Minimum FD amount raised from ₹5000 to ₹10000.
Interest rate made dynamic:
	₹10,000 to ₹50,000 - 6.5%
	₹50,001 to ₹2,00,000 - 7.0%
	Above ₹2,00,000 - 7.5%
	error messages (FD opened, maturity shown, withdrawal blocked if premature).
	Improved withdrawFD blocks premature withdrawal, closes account on maturity.
	Improved viewAllFDs shows “No active FD accounts available” if none exist.
*/
// 1. Custom Exceptions
// 1. Custom Exceptions
// 1. Custom Exceptions
class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}

