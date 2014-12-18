//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 12:08:24 PM GMT 
//


package link.omny.decisions.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import link.omny.decisions.model.adapters.ExpressionAdapter;


/**
 * <p>Java class for tClause complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tClause">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="inputExpression" type="{http://www.omg.org/spec/DMN/20130901}tExpression" minOccurs="0"/>
 *             &lt;element name="inputEntry" type="{http://www.omg.org/spec/DMN/20130901}tExpression" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="outputDefinition" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *             &lt;element name="outputEntry" type="{http://www.omg.org/spec/DMN/20130901}tExpression" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isOrdered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tClause", propOrder = {
    "inputExpression",
    "inputEntry",
    "outputDefinition",
    "outputEntry"
})
public class Clause {

    protected Expression inputExpression;
    @XmlJavaTypeAdapter(ExpressionAdapter.class)
    protected List<Expression> inputEntry;
    protected QName outputDefinition;
    protected List<Expression> outputEntry;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "isOrdered")
    protected Boolean isOrdered;

    /**
     * Gets the value of the inputExpression property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getInputExpression() {
        return inputExpression;
    }

    /**
     * Sets the value of the inputExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setInputExpression(Expression value) {
        this.inputExpression = value;
    }

    /**
     * Gets the value of the inputEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Expression }
     * 
     * 
     */
    public List<Expression> getInputEntry() {
        if (inputEntry == null) {
            inputEntry = new ArrayList<Expression>();
        }
        return this.inputEntry;
    }

    public List<InformationItem> getInputVariables() {
        ArrayList<InformationItem> list = new ArrayList<InformationItem>();
        for (Expression el : getInputEntry()) {
            // System.out.println("EL: " + el);
            for (JAXBElement<Object> o : el.getInputVariable()) {
                list.add((InformationItem) o.getValue());
            }

        }
        System.out.println("list: " + list);
        return list;
    }

    /**
     * Gets the value of the outputDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getOutputDefinition() {
        return outputDefinition;
    }

    /**
     * Sets the value of the outputDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setOutputDefinition(QName value) {
        this.outputDefinition = value;
    }

    /**
     * Gets the value of the outputEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Expression }
     * 
     * 
     */
    public List<Expression> getOutputEntry() {
        if (outputEntry == null) {
            outputEntry = new ArrayList<Expression>();
        }
        return this.outputEntry;
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

    /**
     * Gets the value of the isOrdered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsOrdered() {
        if (isOrdered == null) {
            return false;
        } else {
            return isOrdered;
        }
    }

    /**
     * Sets the value of the isOrdered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOrdered(Boolean value) {
        this.isOrdered = value;
    }

    public Clause addInputEntry(Expression expr) {
        getInputEntry().add(expr);
        return this;
    }

    public Clause addOutputEntry(Expression expr) {
        getOutputEntry().add(expr);
        return this;
    }

}
