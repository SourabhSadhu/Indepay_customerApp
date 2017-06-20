package com.indepay.consumerapp.MyTransactions;





public class MyTransactionsBean {

    public String transactionType;
    public String transactionDateAndTime;
    public String transactionAmount;



    public MyTransactionsBean(String transactionType,String transactionDateAndTime,String transactionAmount)
    {
        this.transactionType = transactionType;
        this.transactionDateAndTime = transactionDateAndTime;
        this.transactionAmount = transactionAmount;

    }

    //Get

    public String getTransactionType() {return transactionType;}
    public String getTransactionDateAndTime() {return transactionDateAndTime;}
    public String getTransactionAmount() {return transactionAmount;}





    //Set

    public void setTransactionType(String transactionType) {this.transactionType = transactionType;}
    public void setTransactionDateAndTime(String transactionDateAndTime) {this.transactionDateAndTime = transactionDateAndTime;}
    public void setTransactionAmount(String transactionAmount) {this.transactionAmount = transactionAmount;}

}







