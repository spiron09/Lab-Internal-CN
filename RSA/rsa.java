package RSA;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class rsa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(128,r);
        BigInteger q = BigInteger.probablePrime(128,r);
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
        BigInteger e;

        do {
            e = BigInteger.probablePrime(128/2, r);
        } while (!e.gcd(phi).equals(BigInteger.ONE));

        BigInteger d = e.modInverse(phi);
        System.out.println("p:" + p  + "\n");
        System.out.println("q: " + q + "\n");
        System.out.println("n: " + n + "\n");
        System.out.println("phi: " + phi + "\n");
        System.out.println("e: " + e + "\n");
        System.out.println("d: " + d + "\n");
        String message, en_message, d_message;
        System.out.println("Enter the message to be encrypted: ");
        message = sc.nextLine();
        en_message = encrypt(message, e,n);
        System.out.println("Encrypted Message: " + en_message);
        
        d_message = decrypt(en_message, d, n);
        System.out.println("Decrypted Message: " + d_message);

    }

    private static String decrypt(String en_message, BigInteger d, BigInteger n) {
        BigInteger bi = new BigInteger(en_message).modPow(d, n);
        return new String(bi.toByteArray());
    }

    private static String encrypt(String message, BigInteger e, BigInteger n) {
        return new BigInteger(message.getBytes()).modPow(e,n).toString(0);
    }
}
