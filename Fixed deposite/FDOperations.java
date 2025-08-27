public interface FDOperations {
    void openFD(long accNo, String name, double amount, int term) throws InvalidAmountException;
    void viewFD(long accNo) throws AccountNotFoundException;
    void withdrawFD(long accNo, int yearsPassed) throws AccountNotFoundException, PrematureWithdrawalException;
    void viewAllFDs();
}
