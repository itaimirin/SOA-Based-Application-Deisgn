package com.example.SOAPServer;
/**
 * 
 * @author Itai
 *
 */
import java.net.URL;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
//Server Implementation for Remote Methods
@WebService(endpointInterface = "com.example.SOAPServer.ServerInterface")
public class ServerImplementation implements ServerInterface{
	/** 
	 * Method invokable remotely by API Gateway for ServerB's response
	 */
	@Override
	public String getHelloA() {
		return "[Service A]: Service A Requested!";
	}//END OF getHelloA
	/** 
	 * Method invokable remotely by API Gateway for ServerB's response
	 */
	@Override
	public String getHelloB() throws Exception {
		// TODO Auto-generated method stub
		return "[Service B]: Service B Requested!";
	}//getHelloB

}//END OF ServerImplementation