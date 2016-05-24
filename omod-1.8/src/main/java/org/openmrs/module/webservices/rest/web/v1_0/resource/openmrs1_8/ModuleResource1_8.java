package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8;

import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.openmrs.module.webservices.rest.web.v1_0.wrapper.openmrs1_8.Module1_8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.05.16.
 */
@Resource(name = RestConstants.VERSION_1 + "/module", supportedClass = Module1_8.class, supportedOpenmrsVersions = {"1.8.*", "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*"})
public class ModuleResource1_8 extends MetadataDelegatingCrudResource<Module1_8> {
    @Override
    public Module1_8 getByUniqueId(String uniqueId) {
        return new Module1_8(ModuleFactory.getModuleById(uniqueId));
    }

    @Override
    public Module1_8 newDelegate() {
        return null;
    }

    @Override
    public Module1_8 save(Module1_8 delegate) {
        return null;
    }

    @Override
    public void purge(Module1_8 delegate, RequestContext context) throws ResponseException {

    }



    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        DelegatingResourceDescription description = new DelegatingResourceDescription();
        description.addProperty("uuid");
        description.addProperty("properties");
        description.addSelfLink();
        return description;
    }

    /**
     * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource#doGetAll(org.openmrs.module.webservices.rest.web.RequestContext)
     */
    @Override
    protected NeedsPaging<Module1_8> doGetAll(RequestContext context) throws ResponseException {
        List<Module> moduleList = new ArrayList<Module>(ModuleFactory.getLoadedModules());
        List<Module1_8> modList = new ArrayList<Module1_8>(moduleList.size());
        for (Module module:moduleList) {
            modList.add(new Module1_8(module));
        }
        return new NeedsPaging<Module1_8>(modList, context);
    }

    @PropertyGetter("properties")
    public static Object getName(Module1_8 instance){
        SimpleObject properties = new SimpleObject();
        properties.put("name", instance.getModule().getName());
        properties.put("description", instance.getModule().getDescription());
        properties.put("id", instance.getModule().getModuleId());
        return properties;
    }

    @PropertyGetter("uuid")
    public static String getUuid(Module1_8 instance){
        return instance.getModule().getModuleId();
    }


}
