package com.powerup.java.immutable.extension.web.model.translator;

import com.powerup.java.immutable.jaxb.JaxbModelObject;
import com.powerup.java.immutable.model.FakeModelObjectBuilder;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ModelObjectTranslatorTest {

    @Test
    public void testToXml() {
        UUID id = UUID.randomUUID();
        FakeModelObjectBuilder fakeModelObjectBuilder = new FakeModelObjectBuilder();
        fakeModelObjectBuilder.setId(id);
        JaxbModelObject jaxbModelObject = new FakeJaxbModelObject();

        ModelObjectTranslator.toXml(fakeModelObjectBuilder.build(), jaxbModelObject);

        assertEquals(id.toString(), jaxbModelObject.getId());
    }

    @Test
    public void testFromXml_NominalCase() {
        UUID id = UUID.randomUUID();
        FakeModelObjectBuilder fakeModelObjectBuilder = new FakeModelObjectBuilder();
        JaxbModelObject jaxbModelObject = new FakeJaxbModelObject();
        jaxbModelObject.setId(id.toString());

        ModelObjectTranslator.fromXml(jaxbModelObject, fakeModelObjectBuilder);

        assertEquals(id, fakeModelObjectBuilder.getId());
    }

    @Test
    public void testFromXml_NullValue() {
        FakeModelObjectBuilder fakeModelObjectBuilder = new FakeModelObjectBuilder();
        JaxbModelObject jaxbModelObject = new FakeJaxbModelObject();

        ModelObjectTranslator.fromXml(jaxbModelObject, fakeModelObjectBuilder);

        assertNull(fakeModelObjectBuilder.getId());
    }
}