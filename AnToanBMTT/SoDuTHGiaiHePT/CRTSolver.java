package SoDuTHGiaiHePT;

import java.io.*;
import java.util.*;

public class CRTSolver {
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

    public static long crt(long[] m, long[] a) {
        long M = 1;
        for (long mod : m) {
            M *= mod;
        }

        long x = 0;
        for (int i = 0; i < m.length; i++) {
            long Mi = M / m[i];
            long[] y = new long[1];
            long inv = extendedEuclidean(Mi, m[i], new long[1], y) % m[i];
            x = (x + a[i] * Mi * inv) % M;
        }

        return x;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\SoDuTHGiaiHePT\\input.txt"));
            String line1 = reader.readLine();
            String line2 = reader.readLine();

            if (line1 == null || line2 == null) {
                System.out.println("Không đủ dữ liệu trong file input.txt");
                return;
            }

            String[] parts1 = line1.split(", ");
            String[] parts2 = line2.split(", ");

            // Tiếp tục xử lý dữ liệu
            long m1 = Long.parseLong(parts1[0].split(" = ")[1]);
            long m2 = Long.parseLong(parts1[1].split(" = ")[1]);
            long m3 = Long.parseLong(parts1[2].split(" = ")[1]);

            long a1 = Long.parseLong(parts2[0].split(" = ")[1]);
            long a2 = Long.parseLong(parts2[1].split(" = ")[1]);
            long a3 = Long.parseLong(parts2[2].split(" = ")[1]);

            // Giải hệ phương trình modulo
            long[] m = {m1, m2, m3};
            long[] a = {a1, a2, a3};
            long x = crt(m, a);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\SoDuTHGiaiHePT\\output.txt"));
            writer.write("Output: x = " + x);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}