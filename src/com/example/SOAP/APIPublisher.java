package com.example.SOAP;
/**
 * @author Itai
 *
 */
import javax.xml.ws.Endpoint;

import com.example.SOAP.APIImplementation;

public class APIPublisher{
	
	public static void main(String[] args) {
		/**
		 * Publishing my SOAP API Gateway
		 */
	   Endpoint.publish("http://localhost:1500/API/hello", new APIImplementation());
	   System.out.println("[API]: Listening on 1500");
    }//END OF MAIN
}//END OF APIPublisher