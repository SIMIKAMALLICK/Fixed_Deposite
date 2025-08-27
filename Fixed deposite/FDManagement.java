public class FDManagement implements FDOperations {
    FDAccount[] accounts;
    int count;

    FDManagement(int size) {
        accounts = new FDAccount[size];
        count = 0;
    }

    private FDAccount findAccount(long accNo) throws AccountNotFoundException {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accNo == accNo && accounts[i].isActive) {
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("FD Account " + accNo + " not found!");
    }

    @Override
    public void openFD(long accNo, String name, double amount, int term) throws InvalidAmountException {
        if (amount < 10000) throw new InvalidAmountException("Minimum FD amount is ₹10000!");
        accounts[count++] = new FDAccount(accNo, name, amount, term, 6.5);
        System.out.println("FD opened successfully for " + name + " with Account No: " + accNo);
    }

    @Override
    public void viewFD(long accNo) throws AccountNotFoundException {
        FDAccount acc = findAccount(accNo);
        System.out.println(acc);
        System.out.println("Maturity Amount: ₹" + acc.maturityAmount());
    }

    @Override
    public void withdrawFD(long accNo, int yearsPassed) throws AccountNotFoundException, PrematureWithdrawalException {
        FDAccount acc = findAccount(accNo);
        if (yearsPassed < acc.term) throw new PrematureWithdrawalException("FD cannot be withdrawn before " + acc.term + " years!");
        System.out.println("FD closed for " + acc.holderName + ". Paid ₹" + acc.maturityAmount());
        acc.isActive = false;
    }

    @Override
    public void viewAllFDs() {
        System.out.println("\n--- All FD Accounts ---");
        for (int i = 0; i < count; i++) {
            if (accounts[i].isActive) System.out.println(accounts[i]);
        }
    }
}
