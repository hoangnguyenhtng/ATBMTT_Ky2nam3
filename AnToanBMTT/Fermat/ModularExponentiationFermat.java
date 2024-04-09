package Fermat;

import java.io.*;
import java.util.*;

public class ModularExponentiationFermat {
    public static long modularExponentiationFermat(long a, long m, long n) {
        if (m == 0) {
            return 1;
        }
        long temp = modularExponentiationFermat(a, m / 2, n);
        temp = (temp * temp) % n;
        if (m % 2 == 1) {
            temp = (temp * a) % n;
        }
        return temp;
    }

    public static void main(String[] args) {
        try {
            // Đọc dữ liệu đầu vào từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\Fermat\\input.txt"));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            long a = Long.parseLong(parts[0].split(" = ")[1]);
            long m = Long.parseLong(parts[1].split(" = ")[1]);
            long n = Long.parseLong(parts[2].split(" = ")[1]);

            // Tính lũy thừa modulo
            long b = modularExponentiationFermat(a, m, n);

            // Ghi kết quả ra file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\Fermat\\output.txt"));
            writer.write("Output: b = " + b);
            writer.close();

            System.out.println("Kết quả đã được ghi vào file output.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}