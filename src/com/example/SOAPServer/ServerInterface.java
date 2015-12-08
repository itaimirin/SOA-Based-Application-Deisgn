package com.example.SOAPServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface ServerInterface{
 
	@WebMethod String getHelloA() throws Exception;
	@WebMethod String getHelloB() throws Exception;

}//END OF ServerInterface