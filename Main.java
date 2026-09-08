import java.security.MessageDigest;
import java.util.ArrayList;

class Block {
    int index;
    String transaction;
    String previousHash;
    String hash;

    Block(int index, String transaction, String previousHash) {
        this.index = index;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    String calculateHash() {
        try {
            String data = index + transaction + previousHash;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(data.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : bytes)
                hex.append(String.format("%02x", b));

            return hex.toString();
        } catch (Exception e) {
            return "";
        }
    }
}

class Blockchain {
    ArrayList<Block> chain = new ArrayList<>();

    Blockchain() {
        chain.add(new Block(0, "Genesis Block", "0"));
    }

    void addBlock(String transaction) {
        Block previous = chain.get(chain.size() - 1);
        chain.add(new Block(chain.size(), transaction, previous.hash));
    }

    boolean isValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            if (!current.hash.equals(current.calculateHash()))
                return false;

            if (!current.previousHash.equals(previous.hash))
                return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("Alice -> Bob : 100");
        blockchain.addBlock("Bob -> Charlie : 50");
        blockchain.addBlock("Charlie -> David : 25");

        System.out.println("========== MINI BLOCKCHAIN ==========");

        for (Block b : blockchain.chain) {
            System.out.println("\nBlock " + b.index);
            System.out.println("Transaction  : " + b.transaction);
            System.out.println("Previous Hash: " + b.previousHash);
            System.out.println("Hash         : " + b.hash);
        }

        System.out.println("\nBlockchain Valid: " + blockchain.isValid());
    }
}