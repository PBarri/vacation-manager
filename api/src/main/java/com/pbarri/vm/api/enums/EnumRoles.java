package com.pbarri.vm.api.enums;

/**
 * Created by pablo on 13/12/16.
 */
public enum EnumRoles {

    ADMINISTRATOR(1L, "ADMINISTRATOR", "role.administrator"),
    CROSSFIELD(2L, "CROSSFIELD", "role.crossfield");

    EnumRoles(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    // Attributes -------------------------------------------------------------

    private final Long id;

    private final String code;

    private final String description;

    // Getters ----------------------------------------------------------------

    /**
     * @return el atributo id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return el atributo codigo
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescription() {
        return this.description;
    }

}
