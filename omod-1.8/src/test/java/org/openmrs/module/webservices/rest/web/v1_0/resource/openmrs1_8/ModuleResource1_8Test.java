package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8;

import org.openmrs.module.Module;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

/**
 * Created by user on 25.05.16.
 */
public class ModuleResource1_8Test extends BaseDelegatingResourceTest<ModuleResource1_8, Module> {

    @Override
    public Module newObject() {
        return null;
    }

    @Override
    public String getDisplayProperty() {
        return null;
    }

    @Override
    public String getUuidProperty() {
        return null;
    }
}
