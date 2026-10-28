package main;

import java.math.BigDecimal;
import java.util.HashMap;

public class AggregatedItem {

    private HashMap<String,BigDecimal> quantitiesByUnit;

    //コンストラクタ
    public AggregatedItem(
        BigDecimal totalQuantity,
        String unit
    ){  
        this.quantitiesByUnit = new HashMap<>();
        this.quantitiesByUnit.put(unit,totalQuantity);
    }

    public HashMap<String,BigDecimal> getQuantitiesByUnit() {
        return quantitiesByUnit;
    }

    public void addQuantity(BigDecimal quantity, String unit) {
        if (this.quantitiesByUnit.containsKey(unit)) {
            quantitiesByUnit.put(
                unit,
                quantitiesByUnit.get(unit).add(quantity));
        } else {
            quantitiesByUnit.put(unit,quantity);
        }
    }

    public boolean isUnitMismatch() {
        return quantitiesByUnit.size() > 1;
    }
}
