package ElGamal;

import java.io.*;
import java.math.BigInteger;

public class ElGamalEncryption {
    public static void main(String[] args) {
        try {
            // Đọc dữ liệu từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\ElGamal\\input.txt"));
            int q = Integer.parseInt(reader.readLine());
            int a = Integer.parseInt(reader.readLine());
            int xA = Integer.parseInt(reader.readLine());
            int k = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());
            reader.close();

            // a) Khóa công khai của An
            BigInteger YA = BigInteger.valueOf(a).modPow(BigInteger.valueOf(xA), BigInteger.valueOf(q));

            // b) Mã hóa bản tin M = 428 bởi Ba
            BigInteger C1 = BigInteger.valueOf(a).modPow(BigInteger.valueOf(k), BigInteger.valueOf(q));
            BigInteger C2 = (BigInteger.valueOf(M).multiply(YA.modPow(BigInteger.valueOf(k), BigInteger.valueOf(q)))).mod(BigInteger.valueOf(q));

            // c) Giải mã bản mã (C1, C2) bởi An
            BigInteger decryptedM = (C2.multiply(C1.modPow(BigInteger.valueOf(q - 1 - xA), BigInteger.valueOf(q)))).mod(BigInteger.valueOf(q));

            // Ghi kết quả vào file output.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\ElGamal\\output.txt"));
            writer.write("a) Khóa công khai của An: PU = {" + q + ", " + a + ", " + YA + "}\n");
            writer.write("b) Bản mã (C1, C2) = (" + C1 + ", " + C2 + ")\n");
            writer.write("c) Thông điệp giải mã M = " + decryptedM + "\n");
            writer.close();

            System.out.println("Tính toán hoàn tất. Kết quả đã được ghi vào file output.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}
