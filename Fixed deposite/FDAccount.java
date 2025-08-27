public class FDAccount {
    long accNo;
    String holderName;
    double principal;
    int term;
    double interestRate;
    boolean isActive;

    FDAccount(long accNo, String holderName, double principal, int term, double interestRate) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.principal = principal;
        this.term = term;
        this.interestRate = interestRate;
        this.isActive = true;
    }

    double maturityAmount() {
        return principal * Math.pow((1 + interestRate / 100), term);
    }

    public String toString() {
        return "FD Account No: " + accNo + ", Name: " + holderName + ", Principal: ₹" + principal +
               ", Term: " + term + " years, Rate: " + interestRate + "%, Active: " + isActive;
    }
}
