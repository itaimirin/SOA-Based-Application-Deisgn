package com.example.SOAPClient;
//////////////////////
//By: Itai Marongwe //
//////////////////////
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.example.SOAP.APIInterface;

public class WSClient{
	
	public WSClient(){
		//TODO - mutators 
	}
	
	public static void main(String args[]) throws Exception {
		
		URL APIurl = new URL("http://localhost:1500/API/hello?wsdl");//Defining my SOAP API URL
		Scanner input = new Scanner(System.in);	//Defining User Input
		boolean connected = true;	//Defining Connected While loop
		String serviceRequested;	//UserInput
		//Execute
		while(connected){ // Looping Client - To simulate multiple requests
			System.out.println("[API]: Which Service are you requesting? (A or B)");
			serviceRequested = input.nextLine(); //Captures user input A or B
			if(serviceRequested.equalsIgnoreCase("a") | serviceRequested.equalsIgnoreCase("B")){ //Error Checking for User Input
				try{
					//Establishing a Connection to the API GATEWAY
					QName qname = new QName("http://SOAP.example.com/", "APIImplementationService"); 
			        Service service = Service.create(APIurl, qname);
			        APIInterface hello = (APIInterface) service.getPort(APIInterface.class);
			        System.out.println(hello.getServiceRequest(serviceRequested)+ "\n");
				}catch(Exception e){
					System.err.println("[API] Error:" + e.getMessage());
					break;
				}//END OF CATCH	
			}else{
				System.err.println("[API] (" +  serviceRequested + ") is not a service offered!" ); //Error Checking
			}
		}//END OF WHILE LOOP
    }//END OF MAIN
}//END OF CLASS
