package CanNguyenThuy;

import java.io.*;
import java.util.*;

public class PrimitiveRoot {
    public static long eulertotient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

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

    public static boolean isPrimitiveRoot(long a, long n) {
        long phi = eulertotient(n);
        long[] x = new long[1];
        long gcd = extendedEuclidean(a, n, x, new long[1]);
        if (gcd != 1) {
            return false;
        }

        for (long i = 1; i < phi; i++) {
            if (modularExponentiation(a, i, n) == 1) {
                return i == phi;
            }
        }
        return true;
    }

    public static long modularExponentiation(long a, long m, long n) {
        long result = 1;
        a = a % n;
        while (m > 0) {
            if (m % 2 == 1) {
                result = (result * a) % n;
            }
            a = (a * a) % n;
            m = m / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\CanNguyenThuy\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long n = Long.parseLong(parts[1].split(" = ")[1]);

            // Kiểm tra a có phải là căn nguyên thủy của n
            boolean isPrimitive = isPrimitiveRoot(a, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\CanNguyenThuy\\output.txt"));
            if (isPrimitive) {
                writer.write("Output: a = " + a + " là căn nguyên thủy của n = " + n);
            } else {
                writer.write("Output: a = " + a + " không phải là căn nguyên thủy của n = " + n);
            }
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}