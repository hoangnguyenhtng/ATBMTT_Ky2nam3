package SoDuTHTinhLuyThua;

import java.io.*;
import java.util.*;

public class ModularExponentiationCRT {
    public static long modularExponentiationCRT(long a, long k, long n) {
        long b = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            a = (a * a) % n;
            k /= 2;
        }
        return b;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\SoDuTHTinhLuyThua\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long k = Long.parseLong(parts[1].split(" = ")[1]);
            long n = Long.parseLong(parts[2].split(" = ")[1]);

            // Tính lũy thừa modulo
            long b = modularExponentiationCRT(a, k, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\SoDuTHTinhLuyThua\\output.txt"));
            writer.write("Output: b = " + b);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}