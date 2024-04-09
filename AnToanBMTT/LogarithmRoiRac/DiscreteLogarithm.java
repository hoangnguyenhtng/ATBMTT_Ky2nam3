package LogarithmRoiRac;

import java.io.*;
import java.util.*;

public class DiscreteLogarithm {
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

    public static long discreteLogarithm(long a, long b, long n) {
        long m = (long) Math.ceil(Math.sqrt(n));
        long[] baby_steps = new long[(int) m];
        long[] giant_steps = new long[(int) m];

        // Tính các bước nhỏ (baby steps)
        baby_steps[0] = 1;
        for (int i = 1; i < m; i++) {
            baby_steps[i] = (baby_steps[i - 1] * a) % n;
        }

        // Tính các bước lớn (giant steps)
        long ainv = modularExponentiation(a, n - 2, n); // Tính nghịch đảo a mod n
        long tmp = b;
        for (int i = 0; i < m; i++) {
            giant_steps[i] = tmp;
            tmp = (tmp * ainv) % n;
        }

        // Tìm cặp phù hợp trong các bước nhỏ và bước lớn
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (baby_steps[i] == giant_steps[j]) {
                    return i + j * m;
                }
            }
        }

        return -1; // Không tìm thấy kết quả
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\LogarithmRoiRac\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long b = Long.parseLong(parts[1].split(" = ")[1]);
            long n = Long.parseLong(parts[2].split(" = ")[1]);

            // Tìm logarithm rời rạc
            long k = discreteLogarithm(a, b, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\LogarithmRoiRac\\output.txt"));
            if (k == -1) {
                writer.write("Output: Không tìm thấy logarithm rời rạc");
            } else {
                writer.write("Output: k = " + k);
            }
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}