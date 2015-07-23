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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for tDecisionRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecisionRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}IDREFS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="conclusion" type="{http://www.w3.org/2001/XMLSchema}IDREFS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "DecisionRule")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDecisionRule", propOrder = {
    "condition",
    "conclusion"
})
public class DecisionRule {

    @XmlElementRef(name = "condition", namespace = "http://www.omg.org/spec/DMN/20130901", type = JAXBElement.class, required = false)
    protected List<JAXBElement<List<Expression>>> condition;
    @XmlElementRef(name = "conclusion", namespace = "http://www.omg.org/spec/DMN/20130901", type = JAXBElement.class, required = false)
    protected List<JAXBElement<List<Expression>>> conclusion;

    /**
     * Gets the value of the condition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the condition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Object }{@code >}{@code >}
     * 
     * 
     */
    public List<JAXBElement<List<Expression>>> getCondition() {
        if (condition == null) {
            condition = new ArrayList<JAXBElement<List<Expression>>>();
        }
        return this.condition;
    }

    public List<Expression> getConditions() {
        List<Expression> conditions = new ArrayList<Expression>();
        for (JAXBElement<List<Expression>> o : getCondition()) {
            if (o.getValue() instanceof JAXBElement) {
                conditions.add((Expression) ((JAXBElement) o.getValue())
                        .getValue());
            } else {
                conditions.addAll(adapt((List<Expression>) o.getValue()));
            }
        }
        return conditions;
    }

    private List<Expression> adapt(List<Expression> value) {
		if (value == null) {
			return Collections.emptyList();
		}
        List<Expression> list = new ArrayList<Expression>();
        for (Object object : value) {
            list.add((Expression) object);
        }
        return list;
    }

    /**
     * Gets the value of the conclusion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the conclusion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getConclusion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link Object }{@code >}
     * {@code >}
     * 
     * 
     */
    public List<JAXBElement<List<Expression>>> getConclusion() {
        if (conclusion == null) {
            conclusion = new ArrayList<JAXBElement<List<Expression>>>();
        }
        return this.conclusion;
    }

    public List<Expression> getConclusions() {
        List<Expression> conclusions = new ArrayList<Expression>();
        for (JAXBElement<List<Expression>> o : getConclusion()) {
            if (o.getValue() instanceof JAXBElement) {
                conclusions.add((Expression) ((JAXBElement) o.getValue())
                        .getValue());
            } else {
                conclusions.addAll(adapt(o.getValue()));
            }
        }
        return conclusions;
    }

}
