
package org.datacontract.schemas._2004._07.creditsafe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.creditsafe package. 
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

    private final static QName _ArrayOfCountryCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Creditsafe.GlobalData", "ArrayOfCountryCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.creditsafe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfCountryCode }
     * 
     */
    public ArrayOfCountryCode createArrayOfCountryCode() {
        return new ArrayOfCountryCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCountryCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Creditsafe.GlobalData", name = "ArrayOfCountryCode")
    public JAXBElement<ArrayOfCountryCode> createArrayOfCountryCode(ArrayOfCountryCode value) {
        return new JAXBElement<ArrayOfCountryCode>(_ArrayOfCountryCode_QNAME, ArrayOfCountryCode.class, null, value);
    }

}
