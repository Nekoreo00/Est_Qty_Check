package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader();
        ArrayList<DetailItem> detailItems = csvReader.readCsv();

        System.out.println("読み込み件数：" + detailItems.size());
        
        QuantityAggregator aggregator = new QuantityAggregator();
        HashMap<String,AggregatedItem> aggregatedItems =
            aggregator.aggregate(detailItems);


        for (Map.Entry<String, AggregatedItem> entry : aggregatedItems.entrySet()){
            AggregatedItem result = entry.getValue();
            HashMap<String, BigDecimal> units =
                result.getQuantitiesByUnit();
                System.out.print(entry.getKey());
            
            for(Map.Entry<String, BigDecimal> entry2 : units.entrySet()){
                System.out.println(entry2.getKey() + " " +
                    entry2.getValue());
            }

            if(result.isUnitMismatch()) {
                System.out.println("単位不一致あり");
            }
            System.out.println();
        }
    }          
}

