package com.example.SOAP;
/**
 * @author Itai
 *
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface APIInterface{
 
	@WebMethod String getServiceRequest(String name) throws Exception;
	
}//END OF INTERFACE