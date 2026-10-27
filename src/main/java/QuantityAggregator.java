import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class QuantityAggregator {

    public HashMap<String, AggregatedItem> aggregate(
        ArrayList<DetailItem> detailItems
    ){
        //空のHashMapを作成
        HashMap<String,AggregatedItem> quantitesByUnit = new HashMap<>();

    for (DetailItem item : detailItems) {
            String key = item.getTypeOfWork() + "・"
            + item.getWorkCategory() + "・"
            + item.getDetailedItem() + "・"
            + item.getSpecification();
            BigDecimal quantity = item.getQuantity();
            String unit = item.getUnit();
            if (quantitesByUnit.containsKey(key)) {
                quantitesByUnit.get(key).addQuantity(quantity, unit);
            } else {
                AggregatedItem aggregatedItem =
                new AggregatedItem(quantity,unit);

                quantitesByUnit.put(key, aggregatedItem);
            }
        }

        //作成したHashMapを返す
        return quantitesByUnit;
    }
}