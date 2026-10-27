import java.math.BigDecimal;

public class AggregatedItem {

    private BigDecimal totalQuantity;
    private String unit;
    private boolean unitMismatch;

    //コンストラクタ
    public AggregatedItem(
        BigDecimal totalQuantity,
        String unit
    ){
        this.totalQuantity = totalQuantity;
        this.unit = unit;
        this.unitMismatch = false;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public boolean isUnitMismatch() {
        return unitMismatch;
    }

    public void addQuantity(BigDecimal quantity, String unit) {
        if (this.unit.equals(unit)) {
            this.totalQuantity = this.totalQuantity.add(quantity);
        } else {
            this.unitMismatch = true;
        }
    }
}
    
