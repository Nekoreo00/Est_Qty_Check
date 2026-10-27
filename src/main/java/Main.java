import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ArrayList<DetailItem> detailItems = new ArrayList<>();
        detailItems.add(new DetailItem("道路土工", "掘削工", "掘削", "土砂", "m3", new BigDecimal("3045.6")));
        detailItems.add(new DetailItem("道路土工", "掘削工", "掘削", "土砂", "m3", new BigDecimal("200.0")));
        detailItems.add(new DetailItem("道路土工", "掘削工", "掘削", "土砂", "m2", new BigDecimal("200.0")));
        detailItems.add(new DetailItem("道路土工", "掘削工", "掘削", "軟岩", "m3", new BigDecimal("846.1")));
        detailItems.add(new DetailItem("道路土工", "掘削工", "盛土", "", "m3", new BigDecimal("1226.4")));

        QuantityAggregator aggregator = new QuantityAggregator();
        HashMap<String,AggregatedItem> aggregatedItems =
            aggregator.aggregate(detailItems);


        for (Map.Entry<String, AggregatedItem> entry : aggregatedItems.entrySet()){
            AggregatedItem result = entry.getValue();
            HashMap<String, BigDecimal> units =
                result.getQuantitiesByUnit();
                System.out.println(entry.getKey());
            
            for(Map.Entry<String, BigDecimal> entry2 : units.entrySet()){
                System.out.println(entry2.getKey() + " " +
                    entry2.getValue());
            }

            if(result.isUnitMismatch()) {
                System.out.println("単位不一致あり");
            }
        }
    }          
}

