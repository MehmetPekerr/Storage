package com.mycompany.ag5;

import java.util.ArrayList;
import java.util.List;

public class PersonnelUtils {
    private static List<Personnel> personnelList = new ArrayList<>();

    public static void addPersonnel(Personnel personnel) {
        personnelList.add(personnel);
    }

    public static List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public static int getTotalPersonnel() {
        return personnelList.size();
    }

    public static double getTotalSalary() {
        double totalSalary = 0;
        for (Personnel personnel : personnelList) {
            totalSalary += personnel.getSalary();
        }
        return totalSalary;
    }
}
