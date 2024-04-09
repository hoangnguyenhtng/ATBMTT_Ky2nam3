package DSASignature;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class DSAExampleWithFileIO {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\DSASignature\\input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\AnToanBMTT\\DSASignature\\output.txt"))) {

            // Đọc các giá trị từ file input.txt
            BigInteger p = new BigInteger(br.readLine());
            BigInteger q = new BigInteger(br.readLine());
            BigInteger h = new BigInteger(br.readLine());
            BigInteger xA = new BigInteger(br.readLine());
            BigInteger k = new BigInteger(br.readLine());
            BigInteger H_M = new BigInteger(br.readLine());

            // Tính yA
            BigInteger yA = h.modPow(xA, p);

            // Tính r
            BigInteger r = h.modPow(k, p).mod(q);

            // Tính s
            BigInteger kInv = k.modInverse(q);
            BigInteger s = kInv.multiply(H_M.add(xA.multiply(r))).mod(q);

            // Ghi kết quả vào file output.txt
            bw.write("Khóa công khai của An (yA): " + yA + "\n");
            bw.write("Chữ ký số của An cho bản tin M (r, s): (" + r + ", " + s + ")\n");

            // Xác minh chữ ký số
            BigInteger w = s.modInverse(q);
            BigInteger u1 = H_M.multiply(w).mod(q);
            BigInteger u2 = r.multiply(w).mod(q);
            BigInteger v = h.modPow(u1, p).multiply(yA.modPow(u2, p)).mod(p).mod(q);

            // Kiểm tra với r
            if (v.equals(r)) {
                bw.write("Chữ ký số được xác minh thành công!\n");
            } else {
                bw.write("Chữ ký số không hợp lệ!\n");
            }

            System.out.println("Kết quả đã được ghi vào file output.txt");

        } catch (IOException e) {
            System.err.println("Lỗi đọc ghi file: " + e.getMessage());
        }
    }
}
