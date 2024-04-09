package EuLerModulo;

import java.io.*;
import java.util.*;

public class ModularExponentiationEuler {
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

    public static long modularExponentiationEuler(long a, long m, long n) {
        long phi = eulertotient(n);
        m = m % phi;
        if (m == 0) {
            return 1;
        }
        long temp = modularExponentiationEuler(a, m / 2, n);
        temp = (temp * temp) % n;
        if (m % 2 == 1) {
            temp = (temp * a) % n;
        }
        return temp;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\EuLerModulo\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long m = Long.parseLong(parts[1].split(" = ")[1]);
            long n = Long.parseLong(parts[2].split(" = ")[1]);

            // Tính lũy thừa modulo
            long b = modularExponentiationEuler(a, m, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\EuLerModulo\\output.txt"));
            writer.write("Output: b = " + b);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}