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
        
        HashMap<String, AggregatedItem> aggregatedItems = new HashMap<>();

        for (DetailItem item : detailItems) {
            String key = item.getTypeOfWork() + "・"
            + item.getWorkCategory() + "・"
            + item.getDetailedItem() + "・"
            + item.getSpecification();
            BigDecimal quantity = item.getQuantity();
            String unit = item.getUnit();
            if (aggregatedItems.containsKey(key)) {
                aggregatedItems.get(key).addQuantity(quantity, unit);
            } else {
                AggregatedItem aggregatedItem =
                new AggregatedItem(quantity,unit);

                aggregatedItems.put(key, aggregatedItem);
            }
        }
        for (Map.Entry<String, AggregatedItem> entry : aggregatedItems.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue()
        );
        }          
    }
}
