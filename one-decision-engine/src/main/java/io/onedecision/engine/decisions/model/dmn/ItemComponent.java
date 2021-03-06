//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.06 at 09:06:03 PM BST 
//


package io.onedecision.engine.decisions.model.dmn;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for tItemComponent complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="tItemComponent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemDefinition" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElementReference"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tItemComponent", propOrder = {
    "itemDefinition"
})
public class ItemComponent implements Serializable {

    private static final long serialVersionUID = 9222597099314142456L;
    @XmlElement(required = true)
    protected DmnElementReference itemDefinition;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the itemDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link DmnElementReference }
     *     
     */
    public DmnElementReference getItemDefinition() {
        return itemDefinition;
    }

    /**
     * Sets the value of the itemDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link DmnElementReference }
     *     
     */
    public void setItemDefinition(DmnElementReference value) {
        this.itemDefinition = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public ItemComponent withItemDefinition(DmnElementReference value) {
        setItemDefinition(value);
        return this;
    }

    public ItemComponent withName(String value) {
        setName(value);
        return this;
    }

}
