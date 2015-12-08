package com.example.SOAPServer;
/**
 * @author Itai
 *
 */
import javax.xml.ws.Endpoint;

import com.example.SOAP.APIImplementation;

//EndPoint Publisher (Server) publisher
public class ServerPublisher{
	
	public static void main(String[] args) {
		/** 
		 * Publishing Service A's Server 1 on multiple ports for load-balancing
		 */
	   Endpoint.publish("http://localhost:1501/serverA/hello", new ServerImplementation());
	   System.out.println("[Server A]: Listening on 1500");
	   
	   Endpoint.publish("http://localhost:1502/serverA/hello", new ServerImplementation());
	   System.out.println("[Server A]: Listening on 1501");
	   
	   System.out.println("");
	   /** 
		 * Publishing Service B's Server 2 on multiple ports for load-balancing
		 */
	   Endpoint.publish("http://localhost:1503/serverB/hello", new ServerImplementation());
	   System.out.println("[Server B]: Listening on 1503");
	   
	   Endpoint.publish("http://localhost:1504/serverB/hello", new ServerImplementation());
	   System.out.println("[Server B]: Listening on 1504");
	   
    }//END OF MAIN
}//END OF SERVERPublisher