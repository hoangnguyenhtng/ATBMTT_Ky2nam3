package Euclid_Extra;

import java.io.*;
import java.util.*;

public class InverseModulo {
    public static long extendedEuclidean(long a, long b, long[] x, long[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        long gcd = extendedEuclidean(b, a % b, y, x);
        long q = a / b;
        y[0] = y[0] - q * x[0];
        return gcd;
    }

    public static long inverseModulo(long a, long n) {
        long[] x = new long[1];
        long[] y = new long[1];
        long gcd = extendedEuclidean(a, n, x, y);
        if (gcd != 1) {
            throw new IllegalArgumentException("Không tồn tại nghịch đảo modulo");
        }
        return (x[0] + n) % n;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\Euclid_Extra\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long n = Long.parseLong(parts[1].split(" = ")[1]);

            // Tính nghịch đảo
            long x = inverseModulo(a, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\Euclid_Extra\\output.txt"));
            writer.write("Output: x = " + x);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}