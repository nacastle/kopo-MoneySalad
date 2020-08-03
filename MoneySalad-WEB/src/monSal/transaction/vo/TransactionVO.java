package monSal.transaction.vo;

public class TransactionVO {
	
    private String transactionDate;
    private String accountNumber;
    private String counterAccountNumber;
    private String transactionType;
    private long transactionAmount;
    
    
	public TransactionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransactionVO(String transactionDate, String accountNumber, String counterAccountNumber,
			String transactionType, long transactionAmount) {
		super();
		this.transactionDate = transactionDate;
		this.accountNumber = accountNumber;
		this.counterAccountNumber = counterAccountNumber;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
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
