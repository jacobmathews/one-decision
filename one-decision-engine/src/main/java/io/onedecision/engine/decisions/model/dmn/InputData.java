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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for tInputData complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="tInputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tDRGElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="variable" type="{http://www.omg.org/spec/DMN/20151101/dmn.xsd}tInformationItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInputData", propOrder = {
    "variable"
})
public class InputData extends DrgElement implements
        InformationRequirementReference, Serializable {

    private static final long serialVersionUID = -2525173660296319790L;
    protected InformationItem variable;

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link InformationItem }
     *     
     */
    public InformationItem getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationItem }
     *     
     */
    public void setVariable(InformationItem value) {
        this.variable = value;
    }

    public InputData withVariable(InformationItem value) {
        setVariable(value);
        return this;
    }

    @Override
    public InputData withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public InputData withDescription(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public InputData withExtensionElements(io.onedecision.engine.decisions.model.dmn.DmnElement.ExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public InputData withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public InputData withLabel(String value) {
        setLabel(value);
        return this;
    }

}
