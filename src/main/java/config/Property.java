package config;

public class Property {
    private String name;
    private String defaultValue;
    private boolean mandatory;
    private boolean conditional;
    private boolean optional;

    public Property(String name, String defaultValue, boolean mandatory, boolean conditional, boolean optional) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.mandatory = mandatory;
        this.conditional = conditional;
        this.optional = optional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public boolean isConditional() {
        return conditional;
    }

    public void setConditional(boolean conditional) {
        this.conditional = conditional;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
