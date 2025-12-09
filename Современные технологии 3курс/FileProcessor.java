import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileProcessor {
    public static void removeDuplicates(String inputFile, String outputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        Set<String> uniqueLines = new LinkedHashSet<>(lines);
        int duplicatesCount = lines.size() - uniqueLines.size();

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
            for (String line : uniqueLines) {
                writer.write(line);
                writer.newLine();
            }
            writer.write("Количество удаленных дубликатов: " + duplicatesCount);
        }
    }

    public static void restoreFile(String compressedFile, String restoredFile) throws IOException {
        Files.copy(Paths.get(compressedFile), Paths.get(restoredFile), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String restoredFile = "restored.txt";

        try {
            removeDuplicates(inputFile, outputFile);
            System.out.println("Дубликаты удалены. Результат записан в " + outputFile);

            restoreFile(outputFile, restoredFile);
            System.out.println("Файл восстановлен и сохранён как " + restoredFile);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
