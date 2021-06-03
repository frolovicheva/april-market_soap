package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.april.market.services.WSProductService;
import ru.geekbrains.april.market.wsproducts.GetAllWSProductsRequest;
import ru.geekbrains.april.market.wsproducts.GetAllWSProductsResponse;
import ru.geekbrains.april.market.wsproducts.GetWSProductByIDRequest;
import ru.geekbrains.april.market.wsproducts.GetWSProductByIDResponse;

@Endpoint
@RequiredArgsConstructor
public class WSProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/wsproducts";
    private final WSProductService wsProductService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWSProductByIDRequest")
    @ResponsePayload
    public GetWSProductByIDResponse getStudentByName(@RequestPayload GetWSProductByIDRequest request) {
        GetWSProductByIDResponse response = new GetWSProductByIDResponse();
        response.setWsproduct (wsProductService.getById (request.getId ()));
        return response;
    }
    /* Request (by Postman)
    POST http://localhost:8189/market/ws
     <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander.com/spring/ws/wsproducts">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getWSProductByIDRequest>
                   <f:id>2</f:id>
                </f:getWSProductByIDRequest>
            </soapenv:Body>
        </soapenv:Envelope>

         Response (by Postman)
         <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getWSProductByIDResponse xmlns:ns2="http://www.flamexander.com/spring/ws/wsproducts">
            <ns2:wsproduct>
                <ns2:id>2</ns2:id>
                <ns2:title>Banana</ns2:title>
                <ns2:price>30.00</ns2:price>
            </ns2:wsproduct>
        </ns2:getWSProductByIDResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
     */



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllWSProductsRequest")
    @ResponsePayload
    public GetAllWSProductsResponse getAllStudents(@RequestPayload GetAllWSProductsRequest request) {
        GetAllWSProductsResponse response = new GetAllWSProductsResponse();
        wsProductService.getAllWSProducts ().forEach(response.getWsproduct ()::add);
        return response;
    }
    /* Request (by Postman)
    POST http://localhost:8189/market/ws
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander.com/spring/ws/wsproducts">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllWSProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>

        Response (by Postman)
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getAllWSProductsResponse xmlns:ns2="http://www.flamexander.com/spring/ws/wsproducts">
            <ns2:wsproduct>
                <ns2:id>1</ns2:id>
                <ns2:title>Apple</ns2:title>
                <ns2:price>50.00</ns2:price>
            </ns2:wsproduct>
            <ns2:wsproduct>
                <ns2:id>2</ns2:id>
                <ns2:title>Banana</ns2:title>
                <ns2:price>30.00</ns2:price>
            </ns2:wsproduct>
            <ns2:wsproduct>
                <ns2:id>3</ns2:id>
                <ns2:title>Cherry</ns2:title>
                <ns2:price>60.00</ns2:price>
            </ns2:wsproduct>
        </ns2:getAllWSProductsResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
     */
}
