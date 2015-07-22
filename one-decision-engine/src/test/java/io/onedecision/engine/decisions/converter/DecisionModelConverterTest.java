package io.onedecision.engine.decisions.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import io.onedecision.engine.decisions.api.DecisionModelFactory;
import io.onedecision.engine.decisions.api.DecisionException;
import io.onedecision.engine.decisions.examples.ExamplesConstants;
import io.onedecision.engine.decisions.model.dmn.Definitions;
import io.onedecision.engine.decisions.model.ui.DecisionModel;
import io.onedecision.engine.domain.api.MockDomainModelFactory;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DecisionModelConverterTest implements ExamplesConstants {

    protected static ObjectMapper mapper;
    protected static DecisionModelConverter converter;

    @BeforeClass
    public static void setUpOnce() {
        mapper = new ObjectMapper();
        new File("target/decisions").mkdirs();

        converter = new DecisionModelConverter();
    }

    @Test
	@Ignore
    public void testConvertSingleDecisionTable() throws JsonParseException,
            JsonMappingException, IOException, DecisionException {
        DecisionModel jsonModel = getJsonModel(ARR_JSON_RESOURCE);
        converter.setDomainModelFactory(new MockDomainModelFactory(
				"http://onedecision.io/health", "/domains/health.json"));

        Definitions dmnModel = converter.convert(jsonModel);

        File dmnFile = new File("target", ARR_DEFINITION_ID + ".dmn");
        new DecisionModelFactory().write("application/xml", dmnModel, dmnFile);
        assertTrue(dmnFile.exists());

        // TODO validate the result using all registered validators
        // http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html

        // SchemaValidator schemaValidator = new SchemaValidator();
        // DmnErrors errors = new DmnErrors();
        // schemaValidator.validate(new FileInputStream(dmnFile), errors);
        // assertEquals(0, errors.getErrorCount());
    }

    private DecisionModel getJsonModel(String resource)
            throws JsonParseException, JsonMappingException, IOException {
        DecisionModel jsonModel = mapper.readValue(getClass()
                .getResourceAsStream(resource), DecisionModel.class);
        assertNotNull(jsonModel);
        return jsonModel;
    }
}