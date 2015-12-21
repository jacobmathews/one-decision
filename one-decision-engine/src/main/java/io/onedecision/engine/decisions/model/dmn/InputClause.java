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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for tInputClause complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="tInputClause"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDMNElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inputExpression" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tLiteralExpression"/&gt;
 *         &lt;element name="inputValues" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tUnaryTests" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputClause", propOrder = {
    "inputExpression",
    "inputValues"
})
public class InputClause extends DmnElement implements Serializable {

    private static final long serialVersionUID = -3616898282041555513L;
    private static ObjectFactory objFact = new ObjectFactory();
    @XmlElement(required = true)
    protected LiteralExpression inputExpression;
    protected UnaryTests inputValues;

    /**
     * Gets the value of the inputExpression property.
     * 
     * @return
     *     possible object is
     *     {@link LiteralExpression }
     *     
     */
    public LiteralExpression getInputExpression() {
        return inputExpression;
    }

    /**
     * Sets the value of the inputExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiteralExpression }
     *     
     */
    public void setInputExpression(LiteralExpression value) {
        this.inputExpression = value;
    }

    /**
     * Gets the value of the inputValues property.
     * 
     * @return
     *     possible object is
     *     {@link UnaryTests }
     *     
     */
    public UnaryTests getInputValues() {
        return inputValues;
    }

    /**
     * Sets the value of the inputValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnaryTests }
     *     
     */
    public void setInputValues(UnaryTests value) {
        this.inputValues = value;
    }

    public InputClause withInputExpression(LiteralExpression value) {
        setInputExpression(value);
        return this;
    }

    public InputClause withInputExpression(String value) {
        setInputExpression(objFact.createLiteralExpression().withText(value));
        return this;
    }

    public InputClause withInputValues(UnaryTests value) {
        setInputValues(value);
        return this;
    }

    public InputClause withInputValues(String... unaryTests) {
        setInputValues(objFact.createUnaryTests().withUnaryTests("Business",
                "Private"));
        return this;
    }

    @Override
    public InputClause withDescription(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public InputClause withExtensionElements(DmnElement.ExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public InputClause withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public InputClause withLabel(String value) {
        setLabel(value);
        return this;
    }


}
