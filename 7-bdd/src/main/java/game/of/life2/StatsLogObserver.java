package game.of.life2;

public class StatsLogObserver implements Observer{
    private Tablero tablero;
    private Celda[][] tableroMatriz;
    private Step step;

    // --- Nuevas variables para acumular estadísticas ---
    private int totalNacimientos = 0;
    private int totalMuertes = 0;
    private int totalSupervivencias = 0;
    private int pasos = 0; 
    // -------------------------------------------------

    public StatsLogObserver(Tablero tablero) {
        this.tablero = tablero;
        this.step = tablero.getStep();
    }

    @Override
    public void update() {
        System.out.println("El tablero dio un step!");
        pasos++;
        tableroMatriz = tablero.getTablero();

        System.out.println("\nIteración #" + pasos + " completada:");
        System.out.println("Nacimientos este paso: " + step.getNacimientosTotales());
        System.out.println("Muertes este paso: " + step.getMuertesTotales());
        System.out.println("Supervivencias este paso: " + step.getSupervivenciasTotales());

        // Acumular totales
        totalNacimientos += step.getNacimientosTotales();
        totalMuertes += step.getMuertesTotales();
        totalSupervivencias += step.getSupervivenciasTotales();

        // Mostrar tablero (opcional)
        print();

        // Cada 5 pasos (por ejemplo), mostrar porcentajes acumulados
        if (pasos % 5 == 0) {
            reportarPorcentajes();
        }

        // Reiniciar contadores del Step para el siguiente paso
        step.resetCounters();
    }

    // Método para imprimir el tablero visualmente
    public void print() {
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz[0].length; j++) {
                // Usamos el método getColor() que ya tenías
                System.out.print(tableroMatriz[i][j].getColor() + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public void reportarPromedio() {
        if (pasos == 0) {
            System.out.println("No se ha ejecutado ninguna iteración.");
            return;
        }

        // Hacemos un casting a double para obtener un promedio con decimales
        double promedioVivas = (double) totalSupervivencias / pasos;
        double promedioMuertas = (double) totalMuertes / pasos;
        
        System.out.println("\n========= REPORTE FINAL =========");
        System.out.println("Total de iteraciones: " + pasos);
        System.out.printf("Promedio de células vivas: %.2f\n", promedioVivas);
        System.out.printf("Promedio de células muertas: %.2f\n", promedioMuertas);
        System.out.println("=================================");
    }

    private void reportarPorcentajes() {
        long totalEventos = totalNacimientos + totalMuertes + totalSupervivencias;
        if (totalEventos == 0) return;

        double pNac = (100.0 * totalNacimientos) / totalEventos;
        double pMue = (100.0 * totalMuertes) / totalEventos;
        double pSup = (100.0 * totalSupervivencias) / totalEventos;

        System.out.println("\n===== REPORTE ACUMULADO =====");
        System.out.printf("Nacimientos: %.1f%%\n", pNac);
        System.out.printf("Muertes: %.1f%%\n", pMue);
        System.out.printf("Supervivencias: %.1f%%\n", pSup);
        System.out.println("=============================");
    }
}
