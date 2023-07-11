import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExactPrime {
    public static void main(String[] args) {
        // Kiểm tra đối số đầu vào
        if (args.length < 2) {
            System.out.println("Usage: java ExactPrime <input_file> <output_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            // Mở tệp đầu vào và tạo bộ đệm đọc
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Mở tệp đầu ra và tạo bộ đệm ghi
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);

                if (isPrime(number)) {
                    writer.write(Integer.toString(number));
                    writer.newLine();
                }
            }

            // Đóng tệp đầu vào và đầu ra
            reader.close();
            writer.close();

            System.out.println("Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức kiểm tra số nguyên tố
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}