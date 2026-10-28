package main;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvReader {

    public ArrayList<DetailItem> readCsv() {

        ArrayList<DetailItem> detailItems = new ArrayList<>();

        try(BufferedReader reader =
            new BufferedReader(new FileReader("sample.csv"))) {
                String line;
                reader.readLine();
                while((line = reader.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    DetailItem item = new DetailItem(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        new BigDecimal(values[5])
                    );
                    detailItems.add(item);
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
        return detailItems;
    }
}
