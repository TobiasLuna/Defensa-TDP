package com.model.player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private int maxRecords;
    private BufferedReader BR;
    private List<RankingEntrada> register;

    public Ranking(String file, int maxRecords) {
        this.maxRecords = maxRecords;
        this.register = new ArrayList<>();
        cargarArchivo(file);
    }

    private void cargarArchivo(String file) {
        try (BufferedReader BR = new BufferedReader(new FileReader(file))) {
            String line;
            int counter = 0;
            while ((line = BR.readLine()) != null && counter < maxRecords) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    register.add(new RankingEntrada(data[0], Integer.parseInt(data[1]), data[2]));
                }
                counter++;
            }
            System.out.println("Archivo de rankings cargado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public List<RankingEntrada> getRegister() {
        return register;
    }
}