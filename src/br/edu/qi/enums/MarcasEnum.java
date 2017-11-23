package br.edu.qi.enums;

import java.util.Arrays;

/**
 * Enumerador que representa as marcas.
 *
 * @author Marcelo Zilio Correa
 * @since 23/11/2017 - 10:52
 */
public enum MarcasEnum {

    TOYOTA("Toyota"),
    VOLKSWAGEM("Volkswagem"),
    FORD("Ford"),
    NISSAN("Nissan"),
    HYUNDAI("Hyundai"),
    HONDA("Honda"),
    CHEVROLET("Chevrolet"),
    KIA("Kia"),
    RENAULT("Renault");

    private String value;

    private MarcasEnum(String value) {
        this.value = value;
    }

    public MarcasEnum getValue(String value) {
        return Arrays.stream(values()).filter(e -> e.value.equals(value)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("O valor " + value + " não existe em MarcasEnum."));
    }

}
