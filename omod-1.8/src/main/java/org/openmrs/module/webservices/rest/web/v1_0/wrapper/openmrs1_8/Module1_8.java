package org.openmrs.module.webservices.rest.web.v1_0.wrapper.openmrs1_8;

import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.module.Module;

import java.io.Serializable;

/**
 * Created by user on 22.05.16.
 */
public class Module1_8 extends BaseOpenmrsMetadata implements Serializable {

    public static final long serialVersionUID = 444L;

    private Module module;

    public Module1_8(){}

    public Module1_8(Module module){this.module = module;}

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
