package com.powerup.java.immutable.extension.web.model.translator;

import com.powerup.java.immutable.jaxb.JaxbModelObject;
import com.powerup.java.immutable.model.ModelObjectAbs;
import java.util.UUID;

/**
 * The <code>ModelObjectTranslator</code> class is a translator that will convert model objects between the domain model and web model
 * representations. extension
 *
 * @author Chris Picard
 */
public final class ModelObjectTranslator {
    /**
     * Constructor made private for utility classes.
     */
    private ModelObjectTranslator() {
    }

    /**
     * Translates the fields from the web model object representation to the domain object representation.
     *
     * @param jaxbModelObject Web model object representation to be translated.
     * @param builder Builder for the domain object representation to be populated.
     */
    public static void fromXml(final JaxbModelObject jaxbModelObject, final ModelObjectAbs.Builder<?> builder) {
        if (jaxbModelObject.getId() != null) {
            builder.setId(UUID.fromString(jaxbModelObject.getId()));
        }
    }

    /**
     * Translates the fields from the domain model representation to the web model object representation.
     *
     * @param modelObject Domain model object representation to be translated.
     * @param jaxbModelObject Web object representation to be populated.
     */
    public static void toXml(final ModelObjectAbs modelObject, final JaxbModelObject jaxbModelObject) {
        jaxbModelObject.setId(modelObject.getId().toString());
    }
}