import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bf.readLine();
        BufferedReader bfFromFile = new BufferedReader(new FileReader(filePath));
        ArrayList<String> strings = new ArrayList<>();
        while (bfFromFile.ready()) {
            strings.add(bfFromFile.readLine());
        }
        bfFromFile.close();
        // считали путь к файлу, затем считали файл построчно в strings

        if (args.length != 0) {
            switch (args[0]) {
                case "-u": {
                    // в считанном файле обновляем данные
                    for (String string : strings) {
                        String subString = string.substring(0, 8).trim();
                        if (subString.equals(args[1])) {
                            int position = strings.indexOf(string);
                            string = String.format("%-8s%-30.30s%-8.8s%-4.4s", args[1], args[2], args[3], args[4]);
                            strings.set(position, string);
                            break;
                        }
                    }
                    // обновлённые данные записываем обратно в файл
                    BufferedWriter bfToFile = new BufferedWriter(new FileWriter(filePath));
                    for (String string : strings) {
                        bfToFile.write(string + "\n");
                    }
                    bfToFile.close();
                    break;
                }
                case "-d": {
                    // физически удаляем данные
                    for (String string : strings) {
                        if(string.substring(0,8).trim().equals(args[1])){
                            strings.remove(string);
                            break;
                        }
                    }
                    BufferedWriter bfToFile = new BufferedWriter(new FileWriter(filePath));
                    for (String string : strings) {
                        bfToFile.write(string + "\n");
                    }
                    bfToFile.close();
                    break;
                }
            }
        }
        bf.close();
    }
}