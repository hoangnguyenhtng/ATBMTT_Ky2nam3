package HaBacLuyThua;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HaBacLuyThua {
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
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\HaBacLuyThua\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long m = Long.parseLong(parts[1].split(" = ")[1]);
            long n = Long.parseLong(parts[2].split(" = ")[1]);

            // Tính toán kết quả
            long b = modularExponentiation(a, m, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\HaBacLuyThua\\output.txt"));
            writer.write("Output: b = " + b);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}
