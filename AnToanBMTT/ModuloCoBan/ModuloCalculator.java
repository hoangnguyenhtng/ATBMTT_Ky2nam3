package ModuloCoBan;

import java.io.*;
import java.math.BigInteger;

public class ModuloCalculator {
    public static void main(String[] args) {
        try {
            // Đọc dữ liệu từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\ModuloCoBan\\input.txt"));
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int x = Integer.parseInt(reader.readLine());
            int y = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            reader.close();

            // Tính các biểu thức modulo
            BigInteger A1 = BigInteger.valueOf(a).pow(x).add(BigInteger.valueOf(b).pow(y)).mod(BigInteger.valueOf(n));
            BigInteger A2 = BigInteger.valueOf(a).pow(x).subtract(BigInteger.valueOf(b).pow(y)).mod(BigInteger.valueOf(n));
            BigInteger A3 = BigInteger.valueOf(a).pow(x).multiply(BigInteger.valueOf(b).pow(y)).mod(BigInteger.valueOf(n));
            BigInteger A4 = BigInteger.valueOf(b).pow(y).modInverse(BigInteger.valueOf(n));
            BigInteger A5 = BigInteger.valueOf(a).pow(x).divide(BigInteger.valueOf(b).pow(y)).mod(BigInteger.valueOf(n));

            // Ghi kết quả vào file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\ModuloCoBan\\output.txt"));
            writer.write("A1 = " + A1 + "\n");
            writer.write("A2 = " + A2 + "\n");
            writer.write("A3 = " + A3 + "\n");
            writer.write("A4 = " + A4 + "\n");
            writer.write("A5 = " + A5 + "\n");
            writer.close();

            System.out.println("Tính toán hoàn tất. Kết quả đã được ghi vào file output.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}