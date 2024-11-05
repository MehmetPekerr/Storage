package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public static void main(String[] args) {
        String dosyaYolu = "parser.txt"; 
        String[] gecerliKomutlar = new String[100]; 
        String[] lexicalHatalar = new String[100]; 
        String[] syntaxHatalar = new String[100]; 
        int gecerliSayisi = 0, lexicalSayisi = 0, syntaxSayisi = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                satir = satir.trim(); 

                if (isValidCommand(satir)) {
                    gecerliKomutlar[gecerliSayisi++] = satir;
                } else if (isLexicalError(satir)) {
                    lexicalHatalar[lexicalSayisi++] = satir;
                } else {
                    syntaxHatalar[syntaxSayisi++] = satir;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Geçerli Komutlar:");
        for (int i = 0; i < gecerliSayisi; i++) {
            System.out.println(gecerliKomutlar[i]);
        }

        System.out.println("\nLexical Hataları:");
        for (int i = 0; i < lexicalSayisi; i++) {
            System.out.println(lexicalHatalar[i]);
        }

        System.out.println("\nSyntax Hataları:");
        for (int i = 0; i < syntaxSayisi; i++) {
            System.out.println(syntaxHatalar[i]);
        }
    }

    private static boolean isValidCommand(String komut) {
        String regex = "^(TOP|CIK|BOL|CARP) \\d{1,2},\\d{1,2}$";
        return komut.matches(regex);
    }

    private static boolean isLexicalError(String komut) {
        if (komut.contains(".")) {
            return true; 
        }

        if (!komut.matches("^(TOP|CIK|BOL|CARP) \\d{1,2},\\d{1,2}$")) {
            String[] parcalar = komut.split(" ");
            if (parcalar.length > 1) {
                if (parcalar[0].matches("TOP|CIK|BOL|CARP") && !parcalar[1].contains(",")) {
                    return true; 
                }
            }
        }

        String[] parcalar = komut.split(" ");
        if (parcalar.length == 2) {
            String[] sayilar = parcalar[1].split(",");
            if (sayilar.length == 2) {
                try {
                    Integer.parseInt(sayilar[0].trim());
                    Integer.parseInt(sayilar[1].trim());
                } catch (NumberFormatException e) {
                    return true; 
                }
            }
        }

        String[] gecersizKomutlar = {"TOF", "CIĞ", "BEL", "MARP"};
        for (String gecersiz : gecersizKomutlar) {
            if (komut.startsWith(gecersiz)) {
                return true;
            }
        }

        if (komut.matches("^(TOP|CIK|BOL|CARP)\\d{1,2},\\d{1,2}$")) {
            return true; 
        }

        if (komut.matches("^\\d{1,2},\\d{1,2}(TOP|CIK|BOL|CARP)$")) {
            return true; 
        }

        return false; 
    }

    private static boolean isSyntaxError(String komut) {
        return komut.matches(".*\\d+,\\d+\\s+[A-Z]+.*|.*\\s+[A-Z]+\\s*\\d+,\\d+.*") ||
               komut.endsWith(",") || komut.contains("  ");
    }
}
