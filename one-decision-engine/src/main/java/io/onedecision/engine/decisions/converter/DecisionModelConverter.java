package io.onedecision.engine.decisions.converter;

import io.onedecision.engine.decisions.model.dmn.BusinessKnowledgeModel;
import io.onedecision.engine.decisions.model.dmn.Clause;
import io.onedecision.engine.decisions.model.dmn.Decision;
import io.onedecision.engine.decisions.model.dmn.DecisionRule;
import io.onedecision.engine.decisions.model.dmn.DecisionTable;
import io.onedecision.engine.decisions.model.dmn.DecisionTableOrientation;
import io.onedecision.engine.decisions.model.dmn.Definitions;
import io.onedecision.engine.decisions.model.dmn.Expression;
import io.onedecision.engine.decisions.model.dmn.HitPolicy;
import io.onedecision.engine.decisions.model.dmn.InformationItem;
import io.onedecision.engine.decisions.model.dmn.ItemDefinition;
import io.onedecision.engine.decisions.model.dmn.LiteralExpression;
import io.onedecision.engine.decisions.model.dmn.ObjectFactory;
import io.onedecision.engine.decisions.model.dmn.Text;
import io.onedecision.engine.decisions.model.ui.DecisionExpression;
import io.onedecision.engine.decisions.model.ui.DecisionModel;
import io.onedecision.engine.domain.api.DomainModelFactory;
import io.onedecision.engine.domain.model.DomainEntity;
import io.onedecision.engine.domain.model.DomainModel;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.springframework.core.convert.converter.Converter;

/**
 * Converts between the UI model and DMN serialisation.
 * 
 * @author Tim Stephenson
 */
public class DecisionModelConverter implements
        Converter<DecisionModel, Definitions> {

    private static final String URI_JSON = "http://www.ecma-international.org/ecma-404/";
    private static final String URI_JAVASCRIPT_5 = "http://www.ecma-international.org/ecma-262/5.1/";

    protected DomainModelFactory domainFact;

    protected ObjectFactory objFact = new ObjectFactory();

    public Definitions convert(DecisionModel source) {
        // Definitions target = new Definitions(source.getId().toString()
        // + "Model", source.getName() + " Model");
        Definitions target = objFact.createTDefinitions();
        target.setId(source.getId() + "Model");
        target.setName(source.getName() + " Model");
        target.setExpressionLanguage(URI_JAVASCRIPT_5);
		target.setNamespace("http://onedecision.io/" + source.getTenantId());
        // target.setNamespace(Definitions.DMN_1_0);
        target.setTypeLanguage(URI_JSON);

        BusinessKnowledgeModel bkm = objFact.createTBusinessKnowledgeModel();
        target.getDrgElement().add(objFact.createBusinessKnowledgeModel(bkm));

        List<InformationItem> informationItems = new ArrayList<InformationItem>();
        for (DomainEntity type : getDomainModel(source.getDomainModelUri())
                .getEntities()) {
            // ItemDefinition itemDef = new ItemDefinition(type.getName(),
            // type.getDescription());
            ItemDefinition itemDef = objFact.createTItemDefinition();
            itemDef.setId(createTypeDef(type));
            itemDef.setName(type.getName() + " Definition");
            itemDef.setDescription(type.getDescription());

            // TODO Consider using this for inline definitions
            // TypeDefinition typeDef = objFact
            // .createTItemDefinitionTypeDefinition();
            // typeDef.getContent().add(createTypeDef(type));
            // itemDef.setTypeDefinition(typeDef);
            target.getItemDefinition().add(itemDef);

            // More indirection - yay!!
            // InformationItem informationItem = new InformationItem(
            // toCamelCase(type.getName()), type.getName() + "Def");
            InformationItem informationItem = objFact.createTInformationItem();
            informationItem.setId(toCamelCase(type.getName()));
            // TODO these should have own namespace (corresponding to domain)
            informationItem.setItemDefinition(new QName(itemDef.getId()));
            informationItems.add(informationItem);
            bkm.getInformationItem().add(informationItem);
        }

        // Decision decision = new Decision(
        // source.getId().toString() + "Decision", source.getName()
        // + " Decision");
        Decision decision = objFact.createTDecision();
        decision.setId(source.getId().toString() + "Decision");
        decision.setName(source.getName() + " Decision");
        target.getDrgElement().add(objFact.createDecision(decision));

        // DecisionTable dt = new DecisionTable(source.getId().toString(),
        // source.getName());
        DecisionTable dt = objFact.createTDecisionTable();
        dt.setId(source.getId().toString());
        dt.setName(source.getName());
        dt.setHitPolicy(HitPolicy.valueOf(source.getHitPolicy()));
        dt.setPreferedOrientation(DecisionTableOrientation.RULE_AS_COLUMN);
        decision.setExpression(objFact.createDecisionTable(dt));

        for (DecisionExpression condition : source.getConditions()) {
            JAXBElement<Object> inputVar = objFact
                    .createTExpressionInputVariable(inferVarName(condition
                            .getName()));

            List<Expression> entries = new ArrayList<Expression>();
            for (String expr : condition.getExpressions()) {
                // entries.add(new LiteralExpression(createId(dt, source,
                // source.getConditions(), condition, expr), expr, inputVar));
                LiteralExpression le = objFact.createTLiteralExpression();
                le.setId(createId(dt, source, source.getConditions(),
                        condition, expr));
                le.getInputVariable().add(inputVar);
                Text txt = objFact.createTLiteralExpressionText();
                txt.getContent().add(expr);
                le.setText(txt);
                entries.add(le);
            }
            Clause clause = objFact.createTClause();
            clause.getInputEntry().addAll(entries);

            Expression inExpr = objFact.createTLiteralExpression();
            clause.setInputExpression(inExpr);
            inExpr.setId(createId(dt, source, condition));
            inExpr.setName(condition.getName());
            inExpr.setDescription(condition.getLabel());

            // inExpr.setItemDefinition(new QName(""));

            try {
                StringWriter writer = new StringWriter();
                writeAsXml(inExpr, writer);
                System.err.println(writer.toString());
                writeAsXml(clause.getInputExpression(), writer);
                System.err.println(writer.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                StringWriter writer = new StringWriter();
                writeAsXml(clause, writer);
                System.err.println(writer.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // new InputClause(inExpr, entries);
            // dt.getClause().add(clause);
        }

        for (DecisionExpression conclusion : source.getConclusions()) {
            // LiteralExpression outExpr = objFact.createTLiteralExpression();
            // outExpr.setItemDefinition(value)
            // bkm.getExpression().add(objFact.createLiteralExpression(outExpr));

            Clause clause = objFact.createTClause();
            // TODO customer namespace?
            clause.setOutputDefinition(new QName(conclusion.getName()));

            for (String expr : conclusion.getExpressions()) {
                // entries.add(new LiteralExpression(createId(dt, source,
                // source.getConditions(), condition, expr), expr, inputVar));
                LiteralExpression le = objFact.createTLiteralExpression();
                // le.setId(createId(dt, source, source.getConclusions(),
                // conclusion, expr));
                le.setId(expr);
                Text txt = objFact.createTLiteralExpressionText();
                txt.getContent().add(expr);
                le.setText(txt);
                clause.getOutputEntry().add(le);
            }

            // new InputClause(inExpr, entries);
            dt.getClause().add(clause);

        }

        // if (source.getInputs().size() > 0) {
        // for (String condition : source.getInputs()) {
        // Expression inExpr = new Expression(condition, condition);
        // List<Expression> entries = new ArrayList<Expression>();
        // // for (String expr : condition.getExpressions()) {
        // // entries.add(new LiteralExpression(expr));
        // // }
        // dt.getClause().add(new InputClause(inExpr));
        // }
        // }
        //
        // if (source.getOutputs().size() > 0) {
        // for (String conclusion : source.getOutputs()) {
        // // List<Expression> entries = new ArrayList<Expression>();
        // // for (String expr : conclusion.getExpressions()) {
        // // entries.add(new LiteralExpression(expr));
        // // }
        // dt.getClause().add(new OutputClause(conclusion));
        // }
        // }

        for (DecisionExpression rule : source.getRules()) {
            DecisionRule dmRule = objFact.createTDecisionRule();
            List<Object> l = new ArrayList<Object>();
            for (int i = 0; i < rule.getExpressions().length; i++) {
                l.clear();
                l.add(rule.getExpressions()[i]);
                if (i < source.getConditions().size()) {
//                    JAXBElement<List<Object>> cond = objFact
//                            .createTDecisionRuleCondition(l);
//                    if (rule.getExpressions()[i] == null
//                            || "".equals(rule.getExpressions()[i])
//                            || "-".equals(rule.getExpressions()[i])) {
//                        cond.setNil(true);
//                    }
//                    dmRule.getCondition().add(cond);
                } else {
                    JAXBElement<List<Object>> conc = objFact
                            .createTDecisionRuleConclusion(l);
                    System.err.println("*******" + conc.getValue());
                    if (rule.getExpressions()[i] == null
                            || "".equals(rule.getExpressions()[i])
                            || "-".equals(rule.getExpressions()[i])) {
                        conc.setNil(true);
                    }
                    dmRule.getConclusion().add(conc);
                }
            }
            dt.getRule().add(dmRule);
        }

        return target;
    }

    private String createTypeDef(DomainEntity type) {
        return type.getName() + "Def";
    }

    private String createId(DecisionTable dt, DecisionModel source,
            DecisionExpression condition) {
        return dt.getId() + "_c" + source.getConditions().indexOf(condition);
    }

    private String createId(DecisionTable dt, DecisionModel source,
            List<DecisionExpression> conditions, DecisionExpression condition,
            String expr) {
        List<String> exprs = Arrays.asList(condition.getExpressions());
        return dt.getId() + "_c" + conditions.indexOf(condition) + "_e"
                + exprs.indexOf(expr);
    }

    private String toCamelCase(String name) {
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    private String inferVarName(String expr) {
        if (expr.indexOf('.') == -1) {
            return expr;
        }
        return expr.substring(0, expr.indexOf('.'));
    }

    public void setDomainModelFactory(DomainModelFactory fact) {
        domainFact = fact;
    }

    public DomainModel getDomainModel(String domainModelUri) {
        if (domainFact == null) {
            throw new IllegalStateException(
                    "No domain factory, set one with setDomainFactory()");
        }
        return domainFact.fetchDomain(domainModelUri);
    }

    private void writeAsXml(Object o, Writer writer) throws IOException {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(o.getClass());
            Marshaller m = context.createMarshaller();
            m.marshal(o, writer);
        } catch (JAXBException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

}