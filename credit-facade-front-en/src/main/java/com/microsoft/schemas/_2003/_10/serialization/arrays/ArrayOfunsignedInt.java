
package com.microsoft.schemas._2003._10.serialization.arrays;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>ArrayOfunsignedInt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ArrayOfunsignedInt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="unsignedInt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfunsignedInt", propOrder = {
    "unsignedInt"
})
public class ArrayOfunsignedInt {

    @XmlElement(type = Long.class)
    @XmlSchemaType(name = "unsignedInt")
    protected List<Long> unsignedInt;

    /**
     * Gets the value of the unsignedInt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unsignedInt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnsignedInt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getUnsignedInt() {
        if (unsignedInt == null) {
            unsignedInt = new ArrayList<Long>();
        }
        return this.unsignedInt;
    }

}
