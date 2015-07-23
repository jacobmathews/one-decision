/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 12:08:24 PM GMT 
//


package io.onedecision.engine.decisions.model.dmn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tInformationRequirement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tInformationRequirement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/DMN/20130901}InformationItem"/>
 *         &lt;choice>
 *           &lt;element name="requiredDecision" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *           &lt;element name="requiredInput" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tInformationRequirement", propOrder = {
    "informationItem",
    "requiredDecision",
    "requiredInput"
})
public class InformationRequirement {

    @XmlElement(name = "InformationItem", required = true)
    protected InformationItem informationItem;
    protected QName requiredDecision;
    protected QName requiredInput;

    /**
     * Gets the value of the informationItem property.
     * 
     * @return
     *     possible object is
     *     {@link InformationItem }
     *     
     */
    public InformationItem getInformationItem() {
        return informationItem;
    }

    /**
     * Sets the value of the informationItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformationItem }
     *     
     */
    public void setInformationItem(InformationItem value) {
        this.informationItem = value;
    }

    /**
     * Gets the value of the requiredDecision property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRequiredDecision() {
        return requiredDecision;
    }

    /**
     * Sets the value of the requiredDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRequiredDecision(QName value) {
        this.requiredDecision = value;
    }

    /**
     * Gets the value of the requiredInput property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getRequiredInput() {
        return requiredInput;
    }

    /**
     * Sets the value of the requiredInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setRequiredInput(QName value) {
        this.requiredInput = value;
    }

}
