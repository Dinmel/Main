package com.company;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int i = -1;
        i = str.indexOf('+');
        if (i < 0)
            i = str.indexOf('-');
        if (i < 0)
            i = str.indexOf('*');
        if (i < 0)
            i = str.indexOf('/');
        if (i < 0) {
            System.err.println("Неправильный ввод!");
            System.exit(1);
        }
        String str1 = str.substring(0, i);
        String str2 = str.substring(i + 1, str.length());
        char Chr = str.charAt(i);
        int Rez1 = RimToAr(str1);
        int Rez2 = RimToAr(str2);
        boolean kl = false;
        if ((Rez1 < 0) && (Rez2 < 0)) {
            try {
                Rez1 = Integer.valueOf(str1);
                Rez2 = Integer.valueOf(str2);
            } catch (NumberFormatException e) {
                System.err.println("Неправильный ввод!");
                System.exit(1);
            }
        } else if ((Rez1 < 0) || (Rez2 < 0)) {
            System.err.println("Неправильный ввод!");
            System.exit(1);
        } else kl = true;
        if ((Rez1 > 10) || (Rez2 > 10)) {
            System.err.println("Неправильный ввод!");
            System.exit(1);
        }
        int Rez = 0;
        switch (Chr) {
            case '+':
                Rez = Rez1 + Rez2;
                break;
            case '-':
                Rez = Rez1 - Rez2;
                break;
            case '*':
                Rez = Rez1 * Rez2;
                break;
            case '/':
                Rez = Rez1 / Rez2;
                break;
            default:
                System.err.println("Неправильный ввод!");
                System.exit(1);
        }
        System.out.println(Rez1);
        System.out.println(Chr);
        System.out.println(Rez2);
        if (kl)
            System.out.println(ArToRim(Rez));
        else
        System.out.println(Rez);
    }

    public static int RimToAr(String St) {
        St = St.toLowerCase();
        String[] Str = new String[11];
        Str[0] = "n";
        Str[1] = "i";
        Str[2] = "ii";
        Str[3] = "iii";
        Str[4] = "iv";
        Str[5] = "v";
        Str[6] = "vi";
        Str[7] = "vii";
        Str[9] = "ix";
        Str[10] = "x";
        int rez = -1;
        for (int i = 1; i < 11; i++)
            if (St.equals(Str[i]))
                rez = i;
        return rez;
    }

    public static String ArToRim(int Int) {
        String[] Str = new String[11];
        Str[0] = "N";
        Str[1] = "I";
        Str[2] = "II";
        Str[3] = "III";
        Str[4] = "IV";
        Str[5] = "V";
        Str[6] = "VI";
        Str[7] = "VII";
        Str[9] = "IX";
        Str[10] = "X";
        String rez = "";
        int n = Int / 100;
        Int = Int % 100;
        for (int i = 0; i < n; i++)
            rez += "C";
        n = Int / 50;
        Int = Int % 50;
        for (int i = 0; i < n; i++)
            rez += "L";
        n = Int / 10;
        Int = Int % 10;
        for (int i = 0; i < n; i++)
            rez += "X";
        if (Int>0)
            rez+=Str[Int];
        return rez;
    }
}
