package DiffleHellman;

import java.io.*;
import java.math.BigInteger;

public class DiffieHellmanKeyExchange {
    public static void main(String[] args) {
        try {
            // Đọc dữ liệu từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\DiffleHellman\\input.txt"));
            int q = Integer.parseInt(reader.readLine());
            int a = Integer.parseInt(reader.readLine());
            int xA = Integer.parseInt(reader.readLine());
            int xB = Integer.parseInt(reader.readLine());
            reader.close();

            // Tính khóa công khai và khóa phiên
            BigInteger yA = calculatePublicKey(a, xA, q);
            BigInteger K = calculateSharedKey(a, xA, xB, q);

            // Tính khóa công khai và khóa phiên
            BigInteger yB = calculatePublicKey(a, xB, q);
            BigInteger K2 = calculateSharedKey(a, xB, xA, q);

            // Ghi kết quả vào file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\DiffleHellman\\output.txt"));
            writer.write("a) Cách An tính ra khóa công khai yA và khóa phiên K:\n");
            writer.write("yA = " + yA + "\n");
            writer.write("K = " + K + "\n");
            writer.write("b) Cách Ba tính ra khóa công khai yB và khóa phiên K:\n");
            writer.write("yB = " + yB + "\n");
            writer.write("K = " + K2 + "\n");
            writer.close();

            System.out.println("Tính toán hoàn tất. Kết quả đã được ghi vào file output.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }

    private static BigInteger calculatePublicKey(int a, int x, int q) {
        return BigInteger.valueOf(a).modPow(BigInteger.valueOf(x), BigInteger.valueOf(q));
    }

    private static BigInteger calculateSharedKey(int a, int xA, int xB, int q) {
        BigInteger publicKeyA = calculatePublicKey(a, xA, q);
        return publicKeyA.modPow(BigInteger.valueOf(xB), BigInteger.valueOf(q));
    }
}