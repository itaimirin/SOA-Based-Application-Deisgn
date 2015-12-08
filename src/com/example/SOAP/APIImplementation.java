package com.example.SOAP;
/**
 * @author Itai
 *
 */
import java.net.URL;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.example.SOAPServer.ServerInterface;

/**
 * @author Itai
 *
 */
@WebService(endpointInterface = "com.example.SOAP.APIInterface")
public class APIImplementation implements APIInterface{
	//Initializing Variables
	String result;
	String Log;
	int ACounter = 0;
	int BCounter = 0;
	int Total;
	
	Boolean roundRobin = new Boolean(true);	//Round Robin Variable for LoadBalancing
	@Override
	public String getServiceRequest(String name) throws Exception {
		//Roundrobin Variable for LoadBalancing between the 2 servers of each Service
		if(roundRobin){
			if(name.equalsIgnoreCase("A")){
				ACounter += 1; 	//Counter for Service A 
				//Making a connection to server 1 or 2 (primary)
				URL Serverurl = new URL("http://localhost:1501/serverA/hello?wsdl");
				QName qname = new QName("http://SOAPServer.example.com/", "ServerImplementationService");
		        Service service = Service.create(Serverurl, qname);
		        ServerInterface hello = (ServerInterface) service.getPort(ServerInterface.class);
		        System.out.println("\n[API]: Server 1 has been Requested...");
		        result = hello.getHelloA();	//Retrieving hello from server 1 for the client
		        roundRobin = false; //Set roundrobin to false for the next 
			}else if(name.equalsIgnoreCase("b")){
				BCounter += 1; 	//Counter for Service B
				//Making a connection to the first server of Service B
				URL Serverurl = new URL("http://localhost:1503/serverB/hello?wsdl");
				QName qname = new QName("http://SOAPServer.example.com/", "ServerImplementationService");
		        Service service = Service.create(Serverurl, qname);
		        ServerInterface hello = (ServerInterface) service.getPort(ServerInterface.class);
		        System.out.println("\n[API]: Server 2 has been Requested...");
		        result = hello.getHelloB();
		        roundRobin = false;
			}//END OF ELSE
		}//END OF ROUNDROBIN
		else if(!roundRobin){
			if(name.equalsIgnoreCase("A")){
				ACounter +=1;
				//Making a connection to server 3 or 4 (Secondary)
				URL Serverurl = new URL("http://localhost:1502/serverA/hello?wsdl");
				QName qname = new QName("http://SOAPServer.example.com/", "ServerImplementationService");
		        Service service = Service.create(Serverurl, qname);
		        ServerInterface hello = (ServerInterface) service.getPort(ServerInterface.class);
		        System.out.println("\n[API]: Server 1 has been Requested...");
		        result = hello.getHelloA();
		        roundRobin = true;
			}else if(name.equalsIgnoreCase("b")){
				BCounter += 1;
				URL Serverurl = new URL("http://localhost:1504/serverB/hello?wsdl");
				QName qname = new QName("http://SOAPServer.example.com/", "ServerImplementationService");
		        Service service = Service.create(Serverurl, qname);
		        ServerInterface hello = (ServerInterface) service.getPort(ServerInterface.class);
		        System.out.println("\n[API]: Server 2 has been Requested...");
		        result = hello.getHelloB();
		        roundRobin = true;
			}
		}
		Total = (ACounter + BCounter);
		System.out.println("Server A Requests: " + ACounter);
		System.out.println("Server B Requests: " + BCounter);
		System.out.println("[+]: Total Requests: " + Total);
		return result;
	}//END OF MAIN
}//END OF CLASS