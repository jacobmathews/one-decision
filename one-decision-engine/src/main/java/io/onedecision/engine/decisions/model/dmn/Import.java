//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.30 at 01:30:38 PM GMT 
//


package io.onedecision.engine.decisions.model.dmn;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tImport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tImport"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="namespace" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="locationURI" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="importType" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImport")
@XmlSeeAlso({
    ImportedValues.class
})
public class Import implements Serializable {

    private static final long serialVersionUID = 274360653727026547L;

    @XmlAttribute(name = "namespace", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String namespace;
    @XmlAttribute(name = "locationURI")
    @XmlSchemaType(name = "anyURI")
    protected String locationURI;
    @XmlAttribute(name = "importType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String importType;

    /**
     * Gets the value of the namespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the locationURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationURI() {
        return locationURI;
    }

    /**
     * Sets the value of the locationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationURI(String value) {
        this.locationURI = value;
    }

    /**
     * Gets the value of the importType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportType() {
        return importType;
    }

    /**
     * Sets the value of the importType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportType(String value) {
        this.importType = value;
    }

    public Import withNamespace(String value) {
        setNamespace(value);
        return this;
    }

    public Import withLocationURI(String value) {
        setLocationURI(value);
        return this;
    }

    public Import withImportType(String value) {
        setImportType(value);
        return this;
    }

}