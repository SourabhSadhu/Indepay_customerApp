package com.indepay.consumerapp.MyAgents;

/**
 * Created by Vinod Sharma on 5/1/2017.
 */


public class MyAgentsBean {

    public String agentName;
    public String agentAddress;
    public String agentMobileNo;



    public MyAgentsBean(String agentName,String agentAddress,String agentMobileNo)
    {
        this.agentName = agentName;
        this.agentAddress = agentAddress;
        this.agentMobileNo = agentMobileNo;

    }

    //Get

    public String getAgentName() {return agentName;}
    public String getAgentAddress() {return agentAddress;}
    public String getAgentMobileNo() {return agentMobileNo;}





    //Set

    public void setAgentName(String agentName) {this.agentName = agentName;}
    public void setAgentAddress(String agentAddress) {this.agentAddress = agentAddress;}
    public void setAgentMobileNo(String agentMobileNo) {this.agentMobileNo = agentMobileNo;}

}







