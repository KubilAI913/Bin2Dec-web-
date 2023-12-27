import java.util.Scanner;

public class Bin2DecConverter {

    public static int binToDec(String binaryStr) {
        int decimalValue = 0;
        int binaryLength = binaryStr.length();

        for (int i = 0; i < binaryLength; i++) {
            // 2'nin üssünü kullanarak ondalık eşdeğeri hesapla
            decimalValue += Character.getNumericValue(binaryStr.charAt(i)) * Math.pow(2, (binaryLength - 1 - i));
        }

        return decimalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Kullanıcıdan ikilik giriş al
            System.out.print("Bir ikilik sayı girin (en fazla 8 basamak): ");
            String binaryInput = scanner.next();

            // Girişin geçerli bir ikilik sayı olup olmadığını kontrol et
            if (!binaryInput.matches("[01]+") || binaryInput.length() > 8) {
                throw new IllegalArgumentException("Geçersiz ikilik girişi. Lütfen geçerli bir ikilik sayı girin.");
            }

            // İkilikten ondalığa dönüştür ve sonucu göster
            int decimalResult = binToDec(binaryInput);
            System.out.println(binaryInput + " sayısının ondalık eşdeğeri: " + decimalResult);

        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}