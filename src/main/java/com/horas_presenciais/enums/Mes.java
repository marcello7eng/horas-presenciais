package com.horas_presenciais.enums;

public enum Mes {
    JANEIRO("01"),
    FEVEREIRO("02"),
    MARCO("03"),
    ABRIL("04"),
    MAIO("05"),
    JUNHO("06"),
    JULHO("07"),
    AGOSTO("08"),
    SETEMBRO("09"),
    OUTUBRO("10"),
    NOVEMBRO("11"),
    DEZEMBRO("12");

    private final String numero;

    Mes(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        // Retorna "Janeiro" em vez de "JANEIRO"
        String s = name().toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}