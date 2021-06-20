/**
 * IsbnVerifyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package book;

public class IsbnVerifyServiceLocator extends org.apache.axis.client.Service implements IsbnVerifyService {

    public IsbnVerifyServiceLocator() {
    }


    public IsbnVerifyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IsbnVerifyServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IsbnVerifyPort
    private String IsbnVerifyPort_address = "http://localhost:8444/IsbnVerify";

    public String getIsbnVerifyPortAddress() {
        return IsbnVerifyPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String IsbnVerifyPortWSDDServiceName = "IsbnVerifyPort";

    public String getIsbnVerifyPortWSDDServiceName() {
        return IsbnVerifyPortWSDDServiceName;
    }

    public void setIsbnVerifyPortWSDDServiceName(String name) {
        IsbnVerifyPortWSDDServiceName = name;
    }

    public IsbnVerify getIsbnVerifyPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IsbnVerifyPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIsbnVerifyPort(endpoint);
    }

    public IsbnVerify getIsbnVerifyPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            IsbnVerifyPortBindingStub _stub = new IsbnVerifyPortBindingStub(portAddress, this);
            _stub.setPortName(getIsbnVerifyPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIsbnVerifyPortEndpointAddress(String address) {
        IsbnVerifyPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IsbnVerify.class.isAssignableFrom(serviceEndpointInterface)) {
                IsbnVerifyPortBindingStub _stub = new IsbnVerifyPortBindingStub(new java.net.URL(IsbnVerifyPort_address), this);
                _stub.setPortName(getIsbnVerifyPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("IsbnVerifyPort".equals(inputPortName)) {
            return getIsbnVerifyPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://book/", "IsbnVerifyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://book/", "IsbnVerifyPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("IsbnVerifyPort".equals(portName)) {
            setIsbnVerifyPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
