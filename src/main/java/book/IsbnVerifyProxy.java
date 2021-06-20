package book;

public class IsbnVerifyProxy implements IsbnVerify {
  private String _endpoint = null;
  private IsbnVerify isbnVerify = null;
  
  public IsbnVerifyProxy() {
    _initIsbnVerifyProxy();
  }
  
  public IsbnVerifyProxy(String endpoint) {
    _endpoint = endpoint;
    _initIsbnVerifyProxy();
  }
  
  private void _initIsbnVerifyProxy() {
    try {
      isbnVerify = (new IsbnVerifyServiceLocator()).getIsbnVerifyPort();
      if (isbnVerify != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)isbnVerify)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)isbnVerify)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (isbnVerify != null)
      ((javax.xml.rpc.Stub)isbnVerify)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IsbnVerify getIsbnVerify() {
    if (isbnVerify == null)
      _initIsbnVerifyProxy();
    return isbnVerify;
  }
  
  public String isbnVerify(String arg0) throws java.rmi.RemoteException{
    if (isbnVerify == null)
      _initIsbnVerifyProxy();
    return isbnVerify.isbnVerify(arg0);
  }
  
  
}