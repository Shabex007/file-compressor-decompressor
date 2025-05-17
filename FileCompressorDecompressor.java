import java.io.*;
import java.util.Scanner;
import java.util.zip.*;

public class FileCompressorDecompressor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------ File Compressor/Decompressor ------");
        System.out.println("1. Compress a file");
        System.out.println("2. Decompress a file");
        System.out.print("Choose an option (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1 -> compressFile(scanner);
            case 2 -> decompressFile(scanner);
            default -> System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static void compressFile(Scanner scanner) {
        System.out.print("Enter the file path to compress: ");
        String inputPath = scanner.nextLine().trim();

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: File does not exist at the given path.");
            return;
        }

        if (inputFile.isDirectory()) {
            System.out.println("Error: You selected a folder. This tool only compresses individual files.");
            return;
        }

        String compressedFileName = inputPath + ".gz";

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(compressedFileName);
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {
            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }

            System.out.println("✅ File compressed successfully: " + compressedFileName);
        } catch (IOException e) {
            System.out.println("Error compressing file: " + e.getMessage());
        }
    }

    private static void decompressFile(Scanner scanner) {
        System.out.print("Enter the .gz file path to decompress: ");
        String compressedPath = scanner.nextLine().trim();

        File compressedFile = new File(compressedPath);

        if (!compressedFile.exists()) {
            System.out.println("Error: Compressed file does not exist.");
            return;
        }

        if (compressedFile.isDirectory()) {
            System.out.println("Error: You selected a folder. This tool only decompresses individual .gz files.");
            return;
        }

        if (!compressedPath.endsWith(".gz")) {
            System.out.println("Error: Only .gz files can be decompressed with this tool.");
            return;
        }

        String outputPath = compressedPath.replaceFirst("\\.gz$", "");

        try (
                FileInputStream fis = new FileInputStream(compressedFile);
                GZIPInputStream gzipIS = new GZIPInputStream(fis);
                FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int len;

            while ((len = gzipIS.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("✅ File decompressed successfully: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error decompressing file: " + e.getMessage());
        }
    }
}
