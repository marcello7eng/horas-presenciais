package com.horas_presenciais.util;

public class HorasUtil {

    public static String formatarDiasRestantes(double horasTotais, double horasCumpridas) {
        double horasFaltam = horasTotais - horasCumpridas;
        if (horasFaltam <= 0) return "0 dia(s) e 0 hora(s)";

        int dias = (int) (horasFaltam / 8);          // dias completos
        double horasRestantes = horasFaltam - (dias * 8); // horas restantes
        int horasInteiras = (int) horasRestantes;        // parte inteira das horas
        int minutos = (int) Math.round((horasRestantes - horasInteiras) * 60); // converter decimal em minutos

        return dias + " dia(s), " + horasInteiras + " hora(s) e " + minutos + " minuto(s)";
    }
}