package io.onedecision.engine.decisions.api;

import static org.junit.Assert.assertEquals;
import io.onedecision.engine.Application;
import io.onedecision.engine.decisions.examples.ExamplesConstants;
import io.onedecision.engine.decisions.model.ui.DecisionModel;
import io.onedecision.engine.decisions.model.ui.examples.ApplicationRiskRatingModel;
import io.onedecision.engine.decisions.web.DecisionUIModelController;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Tests decision ui model lifecycle (upload/create, list, view, update,
 * delete).
 * 
 * @author Tim Stephenson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UiModelLifecycleTest implements ExamplesConstants {

    @Autowired
    protected DecisionUIModelController svc;

    @Test
    public void testLifecycle() {
        DecisionModel model = new ApplicationRiskRatingModel().getModel();

        // Create
        DecisionModel model2 = svc.createModelForTenant(TENANT_ID, model);

        // Retrieve
        List<DecisionModel> models = svc.listForTenant(TENANT_ID);
        assertEquals(1, models.size());
        assertEquals(model2.getId(), models.get(0).getId());
        // assertEquals(model2, models.get(0));

        // Update
        // models.get(0).setName(models.get(0).getName() + " updated");
        svc.updateModelForTenant(TENANT_ID, model.getId(), models.get(0));
        DecisionModel model3 = svc.getModelForTenant(TENANT_ID, model.getId());
        model3.setLastUpdated(null);
        assertEquals(model2.getId(), model3.getId());

        // Delete
        svc.deleteModelForTenant(TENANT_ID, model.getId());
    }
}