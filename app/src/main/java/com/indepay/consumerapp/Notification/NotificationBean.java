package com.indepay.consumerapp.Notification;


public class NotificationBean {

    public String type;
    public String recievedOn;
    public String msgDetail;
    public int dbId;





    public NotificationBean(String type,String recievedOn,String msgDetail)
    {
        this.type = type;
        this.recievedOn = recievedOn;
        this.msgDetail = msgDetail;
        this.dbId = dbId;

    }

    //Get

    public String getType() {return type;}
    public String getRecievedOn() {return recievedOn;}
    public String getMsgDetail() {return msgDetail;}




    //Set

    public void setType(String type) {this.type = type;}
    public void setRecievedOn(String recievedOn) {this.recievedOn = recievedOn;}
    public void setMsgDetail(String msgDetail) {this.msgDetail = msgDetail;}




}







