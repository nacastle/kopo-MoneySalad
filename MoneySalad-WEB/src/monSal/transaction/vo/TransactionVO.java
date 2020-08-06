package monSal.transaction.vo;

public class TransactionVO {
	
    private String transactionDate;
    private String accountNumber;
    private String counterAccountNumber;
    private String transactionType;
    private long transactionAmount;
    private long balance;
    
    
	public TransactionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public TransactionVO(String transactionDate, String accountNumber, String counterAccountNumber,
			String transactionType, long transactionAmount, long balance) {
		super();
		this.transactionDate = transactionDate;
		this.accountNumber = accountNumber;
		this.counterAccountNumber = counterAccountNumber;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.balance = balance;
	}

	
	

	public long getBalance() {
		return balance;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}



	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCounterAccountNumber() {
		return counterAccountNumber;
	}
	public void setCounterAccountNumber(String counterAccountNumber) {
		this.counterAccountNumber = counterAccountNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
    

    
    

  
}
