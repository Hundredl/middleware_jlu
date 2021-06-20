
package bookIsbnVerify;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bookIsbnVerify package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsbnVerify_QNAME = new QName("http://book/", "isbnVerify");
    private final static QName _IsbnVerifyResponse_QNAME = new QName("http://book/", "isbnVerifyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bookIsbnVerify
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsbnVerifyResponse }
     * 
     */
    public IsbnVerifyResponse createIsbnVerifyResponse() {
        return new IsbnVerifyResponse();
    }

    /**
     * Create an instance of {@link IsbnVerify_Type }
     * 
     */
    public IsbnVerify_Type createIsbnVerify_Type() {
        return new IsbnVerify_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsbnVerify_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://book/", name = "isbnVerify")
    public JAXBElement<IsbnVerify_Type> createIsbnVerify(IsbnVerify_Type value) {
        return new JAXBElement<IsbnVerify_Type>(_IsbnVerify_QNAME, IsbnVerify_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsbnVerifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://book/", name = "isbnVerifyResponse")
    public JAXBElement<IsbnVerifyResponse> createIsbnVerifyResponse(IsbnVerifyResponse value) {
        return new JAXBElement<IsbnVerifyResponse>(_IsbnVerifyResponse_QNAME, IsbnVerifyResponse.class, null, value);
    }

}
