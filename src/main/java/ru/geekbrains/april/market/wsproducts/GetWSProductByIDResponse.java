//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.02 at 03:10:45 PM MSK 
//


package ru.geekbrains.april.market.wsproducts;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="wsproduct" type="{http://www.flamexander.com/spring/ws/wsproducts}wsproduct"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsproduct"
})
@XmlRootElement(name = "getWSProductByIDResponse")
public class GetWSProductByIDResponse {

    @XmlElement(required = true)
    protected Wsproduct wsproduct;

    /**
     * Gets the value of the wsproduct property.
     * 
     * @return
     *     possible object is
     *     {@link Wsproduct }
     *     
     */
    public Wsproduct getWsproduct() {
        return wsproduct;
    }

    /**
     * Sets the value of the wsproduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wsproduct }
     *     
     */
    public void setWsproduct(Wsproduct value) {
        this.wsproduct = value;
    }

}