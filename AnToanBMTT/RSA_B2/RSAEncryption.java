package RSA_B2;

import java.io.*;
import java.math.BigInteger;

public class RSAEncryption {
    public static void main(String[] args) {
        try {
            // Đọc dữ liệu từ file input.txt
            BufferedReader reader = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\RSA_B2\\input.txt"));
            int p = Integer.parseInt(reader.readLine());
            int q = Integer.parseInt(reader.readLine());
            int e = Integer.parseInt(reader.readLine());
            int M = Integer.parseInt(reader.readLine());
            reader.close();

            // a) Khóa công khai của An
            int n = p * q;
            BigInteger PU = new BigInteger(Integer.toString(e));

            // b) Khóa riêng của An
            BigInteger phi = BigInteger.valueOf((p - 1) * (q - 1));
            BigInteger d = PU.modInverse(phi);

            // c) Mã hóa thông điệp M = 41 bởi người gửi (Ba)
            BigInteger C = BigInteger.valueOf(M).modPow(PU, BigInteger.valueOf(n));

            // d) Giải mã bản mã C bởi An
            BigInteger decryptedM = C.modPow(d, BigInteger.valueOf(n));

            // e) Mục đích của việc mã hóa
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\RSA_B2\\output.txt"));
            writer.write("a) Khóa công khai của An: PU = {" + e + ", " + n + "}\n");
            writer.write("b) Khóa riêng của An: PR = {" + d + ", " + n + "}\n");
            writer.write("c) Bản mã C = " + C + "\n");
            writer.write("d) Thông điệp giải mã M = " + decryptedM + "\n");
            writer.write("e) Việc mã hóa ở câu c) thực hiện nhiệm vụ bảo mật.\n");
            writer.close();

            System.out.println("Tính toán hoàn tất. Kết quả đã được ghi vào file output.txt.");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
        }
    }
}