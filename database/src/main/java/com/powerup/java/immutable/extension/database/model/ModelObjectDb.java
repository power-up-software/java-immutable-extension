package com.powerup.java.immutable.extension.database.model;

import com.powerup.java.immutable.model.ModelObjectAbs;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

/**
 * The <code>ModelObjectDb</code> class is the database model object for the {@link ModelObjectAbs} class.
 *
 * @author Chris Picard
 */
@Alias("ModelObject")
public abstract class ModelObjectDb {
    /**
     * Globally unique id that identifies the model object on any system.
     */
    private UUID id;

    /**
     * Default constructor.
     */
    public ModelObjectDb() {
    }

    /**
     * Constructor that populates the values based on the domain model object representation.
     *
     * @param modelObjectAbs Model Object this DB object represents.
     */
    public ModelObjectDb(final ModelObjectAbs modelObjectAbs) {
        this.id = modelObjectAbs.getId();
    }

    /**
     * Populates the builder with the values from the database model object representation.
     *
     * @param modelObjectAbsBuilder Builder to be populated with values from the database model object representation.
     */
    protected void populateModelObjectValues(final ModelObjectAbs.Builder<?> modelObjectAbsBuilder) {
        modelObjectAbsBuilder.setId(getId());
    }

    /**
     * Mutator for the value of {@link #id}.
     *
     * @param id New value of {@link #id}.
     */
    public void setId(final UUID id) {
        this.id = id;
    }

    /**
     * Accessor for the value of {@link #id}.
     *
     * @return Value of {@link #id}.
     */
    public UUID getId() {
        return id;
    }

    // BEGIN_GENERATED_CODE

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    // END_GENERATED_CODE
}
