package br.edu.qi.enums;

import br.edu.qi.model.Automovel;

/**
 * Enumerador que respresenta as possíveis cores de {@link Automovel}.
 * 
 * @author Marcelo Zilio Correa
 * @since 24/11/2017 - 01:30
 */
public enum CoresEnum {
    
    BRANCO("Branco"),
    PRETO("Preto"),
    PRATA("Prata"),
    VERMELHO("Vermelho"),
    AZUL("Azul"),
    VERDE("Verde"),
    AMARELO("Amarelo");
    
    private String value;

    private CoresEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
        
    
}
