package Designpattern.Encryption;

public class Sha512EncryptionAlgorithm implements EncryptionAlgorithm{
    @Override
    public String encrypt(String plaintext) {
        return DigestUtils.sha512Hex(plaintext);
    }
}

