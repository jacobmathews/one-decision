//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.30 at 01:30:38 PM GMT 
//


package io.onedecision.engine.decisions.model.dmn;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tBuiltinAggregator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tBuiltinAggregator"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUM"/&gt;
 *     &lt;enumeration value="COUNT"/&gt;
 *     &lt;enumeration value="MIN"/&gt;
 *     &lt;enumeration value="MAX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tBuiltinAggregator")
@XmlEnum
public enum BuiltInAggregator {

    SUM,
    COUNT,
    MIN,
    MAX;

    public String value() {
        return name();
    }

    public static BuiltInAggregator fromValue(String v) {
        return valueOf(v);
    }

}
