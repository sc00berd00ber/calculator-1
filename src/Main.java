import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Calculator 1: A mortgage calculator - it is used to calculate out
//        how much a monthly payment for a loan would be (minus any
//        insurance or taxes), as well as how much interest you would pay
//        over the life of the loan.

//        a. It would accept the principal, interest rate, and loan length
//        from the user

        //ACCEPT USER INPUT
        Scanner s = new Scanner(System.in);

        System.out.print("Principal Amount (no commas) e.g. 53000: ");
        double principalAmount = s.nextDouble();

        System.out.print("Number of Years e.g. 15: ");
        int years = s.nextInt();

        System.out.print("Yearly Interest Rate e.g. 7.625: ");
        double rawRate = s.nextDouble(); //0-100 with fraction

        int MONTHS_IN_A_YEAR = 12;
        // MATHEMATICAL INPUTS
        double yearlyInterestRate = rawRate / 100;
        double monthlyInterestRate = yearlyInterestRate / MONTHS_IN_A_YEAR;
        long numberOfPayments = years * MONTHS_IN_A_YEAR; // years time months
        //output
        double expectedMonthlyPaymentAmount = 0;


        //CALCULATE
        //        double result = Math.pow(base, exponent);
        expectedMonthlyPaymentAmount = principalAmount * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments) / (Math.pow( (1+monthlyInterestRate), numberOfPayments) - 1)));

//        This calculator would use a compounded interest formula.
//        M=P×(i*(1+i)^n / ((1+i)^n)-1)
//                - Monthly Payment (M)
//                - Principal (P): This is the total amount of the loan.
//        - Annual Interest Rate (r): The nominal annual interest rate in
//        decimal form (e.g., 7.625% = 0.07625).
//        - Loan Term in Years (y) How many years the loan lasts.
//        - Number of Monthly Payments (n): This is 12×y (Because
//                there are 12 monthly payments per year.)
//                - Monthly Interest Rate (i): This is the annual interest rate
//        divided by 12, i.e. r/12
//                - Total Interest =(M×n)−P

//        b. It would display the expected monthly payment and total
//        interest paid

        // DISPLAY OUTPUT
        double totalInterestPaid = (numberOfPayments * expectedMonthlyPaymentAmount) - principalAmount;

        System.out.printf("Expected Monthly Payment Amount: %.2f \n", expectedMonthlyPaymentAmount );
        System.out.printf("Total Interest Paid: %.2f", totalInterestPaid);
//        Example: A $53,000 loan at 7.625% interest for 15 years would
//        have a $495.09/mo payment with a total interest of $36,115.99
    }
}