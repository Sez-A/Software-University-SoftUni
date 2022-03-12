public interface Transaction {
    public int getId() ;

    public void setId(int id) ;
    public TransactionStatus getStatus() ;

    public void setStatus(TransactionStatus status);

    public String getFrom() ;

    public void setFrom(String from) ;

    public String getTo() ;

    public void setTo(String to);

    public double getAmount();


    public void setAmount(double amount);
}
