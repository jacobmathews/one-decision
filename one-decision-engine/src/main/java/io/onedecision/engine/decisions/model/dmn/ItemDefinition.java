//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.30 at 01:30:38 PM GMT 
//


package io.onedecision.engine.decisions.model.dmn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tItemDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tItemDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tNamedElement"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="typeRef" type="{http://www.w3.org/2001/XMLSchema}QName"/&gt;
 *           &lt;element name="allowedValues" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tUnaryTests" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="itemComponent" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tItemDefinition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="typeLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="isCollection" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tItemDefinition", propOrder = {
    "typeRef",
    "allowedValues",
    "itemComponent"
})
public class ItemDefinition extends NamedElement implements Serializable {

    private static final long serialVersionUID = 2928103107027172138L;
    protected QName typeRef;
    protected UnaryTests allowedValues;
    protected List<ItemDefinition> itemComponent;
    @XmlAttribute(name = "typeLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String typeLanguage;
    @XmlAttribute(name = "isCollection")
    protected Boolean isCollection;

    /**
     * Gets the value of the typeRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getTypeRef() {
        return typeRef;
    }

    /**
     * Sets the value of the typeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setTypeRef(QName value) {
        this.typeRef = value;
    }

    /**
     * Gets the value of the allowedValues property.
     * 
     * @return
     *     possible object is
     *     {@link UnaryTests }
     *     
     */
    public UnaryTests getAllowedValues() {
        return allowedValues;
    }

    /**
     * Sets the value of the allowedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnaryTests }
     *     
     */
    public void setAllowedValues(UnaryTests value) {
        this.allowedValues = value;
    }

    /**
     * Gets the value of the itemComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemDefinition }
     * 
     * 
     */
    public List<ItemDefinition> getItemComponents() {
        if (itemComponent == null) {
            itemComponent = new ArrayList<ItemDefinition>();
        }
        return this.itemComponent;
    }

    public DmnElement getItemComponent(String id) {
        for (ItemDefinition itemDefinition : itemComponent) {
            if (itemDefinition.getId().equals(id)) {
                return itemDefinition;
            }
        }
        return null;
    }

    public DmnElement getItemComponentByName(String name) {
        for (ItemDefinition itemDefinition : itemComponent) {
            if (itemDefinition.getName().equals(name)) {
                return itemDefinition;
            }
        }
        return null;
    }

    /**
     * Gets the value of the typeLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLanguage() {
        return typeLanguage;
    }

    /**
     * Sets the value of the typeLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLanguage(String value) {
        this.typeLanguage = value;
    }

    /**
     * Gets the value of the isCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsCollection() {
        if (isCollection == null) {
            return false;
        } else {
            return isCollection;
        }
    }

    /**
     * Sets the value of the isCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

    public ItemDefinition withTypeRef(QName value) {
        setTypeRef(value);
        return this;
    }

    public ItemDefinition withAllowedValues(UnaryTests value) {
        setAllowedValues(value);
        return this;
    }

    public ItemDefinition withItemComponent(ItemDefinition... values) {
        if (values!= null) {
            for (ItemDefinition value: values) {
                getItemComponents().add(value);
            }
        }
        return this;
    }

    public ItemDefinition withItemComponent(Collection<ItemDefinition> values) {
        if (values!= null) {
            getItemComponents().addAll(values);
        }
        return this;
    }

    public ItemDefinition withTypeLanguage(String value) {
        setTypeLanguage(value);
        return this;
    }

    public ItemDefinition withIsCollection(Boolean value) {
        setIsCollection(value);
        return this;
    }

    @Override
    public ItemDefinition withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public ItemDefinition withDescription(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ItemDefinition withExtensionElements(io.onedecision.engine.decisions.model.dmn.DmnElement.ExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public ItemDefinition withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ItemDefinition withLabel(String value) {
        setLabel(value);
        return this;
    }
}
