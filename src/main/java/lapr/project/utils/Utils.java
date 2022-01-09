package lapr.project.utils;

import lapr.project.model.Place;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public Utils() {
    }

    public static int lengthOfANum(double num) {
        int length = 0;
        return lengthOfANum(num, length);
    }

    public static int lengthOfANum(double num, int length) {
        if (num == 0) {
            return 1;
        }
        if (num > 1) {
            num = num / 10;
            length++;
            return lengthOfANum(num, length);
        }
        return length;
    }

    //método para obter um número com X casas decimais
    public static double round(double valor, int casasDecimais) {
        BigDecimal aux = BigDecimal.valueOf(valor);
        aux = aux.setScale(casasDecimais, RoundingMode.HALF_UP);
        return aux.doubleValue();
    }

    //método para verificar se uma string contém um número
    public static boolean containsNum(String s) {

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;

                }
            }
        }

        return false;
    }

    //método para verificar se uma string contém uma letra
    public static boolean containsLetter(String s) {

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    return true;

                }
            }
        }

        return false;
    }

    public static List<String> loadCsv(String nomeFich) {
        if (nomeFich == null || nomeFich.isEmpty()) {
            return null;
        }
        try {
            List<String> list = Files.lines(Paths.get(nomeFich)).collect(Collectors.toList());
            while (list.get(0).contains("#")) {
                list.remove(0);
            }
            list.remove(0);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Files.lines(Paths.get(nomeFich)).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Place getPlaceFromCoordenates(double latitude, double longitude, ArrayList<Place> places) {
        for (Place place : places) {
            if (place.getLatitude() == latitude && place.getLongitude() == longitude) {
                return place;
            }
        }
        return null;
    }

    public static boolean writeFile(String stringToWrite, String nameFile) throws IOException {
        BufferedWriter writer = null;
        if (stringToWrite != null && nameFile != null && !stringToWrite.isEmpty() && !nameFile.isEmpty()) {
            writer = new BufferedWriter(new FileWriter(nameFile));
            writer.write(stringToWrite);
            writer.close();
            return true;
        }
        return false;
    }

}
