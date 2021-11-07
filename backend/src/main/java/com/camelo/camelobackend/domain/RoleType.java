package com.camelo.camelobackend.domain;

public enum RoleType {
    ADMIN(1L, "ROLE_ADMIN"),
    CLIENTE(2L, "ROLE_CLIENTE");

    private Long codigo;
    private String name;

    private RoleType(Long codigo, String name) {
        this.codigo = codigo;
        this.name = name;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public static RoleType toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (RoleType role : RoleType.values()) {
            if (codigo.equals(role.getCodigo()))
                return role;
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
