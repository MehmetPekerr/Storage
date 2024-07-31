package sinif;
import java.io.*;
import java.util.*;
public class ClassToStruct {
    static class ClassInfo {
        String name;
        String parent;
        List<String> publicAttributes = new ArrayList<>();
        List<String> privateAttributes = new ArrayList<>();
        ClassInfo(String name, String parent) {
            this.name = name;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen sınıf tanım dosyasının ismini giriniz: ");
        String filename = scanner.nextLine();
        Map<String, ClassInfo> classes = new LinkedHashMap<>();  
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            ClassInfo currentClass = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("class")) {
                    String[] parts = line.split("\\s+");
                    String className = parts[1];
                    String parentClass = parts.length > 3 ? parts[3] : null;
                    currentClass = new ClassInfo(className, parentClass);
                    classes.put(className, currentClass);
                } else if (line.endsWith("}")) {
                    currentClass = null;
                } else if (currentClass != null && (line.contains("public") || line.contains("private"))) {
                    String[] parts = line.split("\\s+");
                    String attribute = parts[1] + " " + parts[2].replace(";", "");
                    if (line.contains("public")) {
                        currentClass.publicAttributes.add(attribute);
                    } else if (line.contains("private")) {
                        currentClass.privateAttributes.add(attribute);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
        printStructs(classes);
    }
    private static void printStructs(Map<String, ClassInfo> classes) {
        Set<String> printedStructs = new HashSet<>();        
        for (ClassInfo classInfo : classes.values()) {
            if (!printedStructs.contains(classInfo.name)) {
                if (classInfo.parent == null) {                    
                    printStruct(classInfo, null, true);
                    printedStructs.add(classInfo.name);
                } else {                    
                    printStruct(classInfo, classes.get(classInfo.parent), false);
                    printedStructs.add(classInfo.name);
                }
            }
        }
    }
    private static void printStruct(ClassInfo classInfo, ClassInfo parentClassInfo, boolean includePrivate) {
        System.out.println("struct " + classInfo.name + " {");
        if (parentClassInfo != null) {
            for (String attribute : parentClassInfo.publicAttributes) {
                System.out.println("    " + attribute + ";");
            }
        }
        for (String attribute : classInfo.publicAttributes) {
            System.out.println("    " + attribute + ";");
        }
        if (includePrivate) {
            for (String attribute : classInfo.privateAttributes) {
                System.out.println("    " + attribute + ";");
            }
        }
        System.out.println("};\n");
    }
}