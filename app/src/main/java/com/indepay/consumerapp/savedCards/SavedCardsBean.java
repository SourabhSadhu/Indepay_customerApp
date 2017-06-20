package com.indepay.consumerapp.savedCards;




public class SavedCardsBean {

    public String cardName;
    public String cardNo;
    public String msgDetail;





    public SavedCardsBean(String cardName,String cardNo)
    {
        this.cardName = cardName;
        this.cardNo = cardNo;

    }

    //Get

    public String getCardName() {return cardName;}
    public String getCardNo() {return cardNo;}




    //Set

    public void setCardName(String cardName) {this.cardName = cardName;}
    public void setCardNo(String cardNo) {this.cardNo = cardNo;}




}







