package com.indepay.consumerapp.MoneyTransactions.cashDeposit;



public class CashDepositBean {




    public String bankName;
    public String accNumber;
    public String branchAddress;

    public CashDepositBean(String bankName, String accNumber,String branchAddress) {
        this.bankName = bankName;
        this.accNumber = accNumber;
        this.branchAddress = branchAddress;
    }

    //Set

    public String getBankName() {return bankName;}
    public String getAccNumber() {return accNumber;}
    public String getBranchAddress() {return branchAddress;}


    //Set

    public void setBankName(String bankName) {this.bankName = bankName;}
    public void setAccNumber(String accNumber) {this.accNumber = accNumber;}
    public void setBranchAddress(String branchAddress) {this.branchAddress = branchAddress;}


}





