import java.util.ArrayList;

public interface Csv {
    void readCSV(String path);

    void writeCSV(String path, ArrayList<Product> products);
}
