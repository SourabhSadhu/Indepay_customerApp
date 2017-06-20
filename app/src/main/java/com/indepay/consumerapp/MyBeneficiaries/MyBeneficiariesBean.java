package com.indepay.consumerapp.MyBeneficiaries;


public class MyBeneficiariesBean {

    public String name;
    public String bankName;
    public String ifscCode;



    public MyBeneficiariesBean(String name,String bankName,String ifscCode)
    {
        this.name = name;
        this.bankName = bankName;
        this.ifscCode = ifscCode;

    }

    //Get

    public String getName() {return name;}
    public String getBankName() {return bankName;}
    public String getIfscCode() {return ifscCode;}





    //Set

    public void setName(String name) {this.name = name;}
    public void setBankName(String bankName) {this.bankName = bankName;}
    public void setIfscCode(String ifscCode) {this.ifscCode = ifscCode;}

}







