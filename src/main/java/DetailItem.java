import java.math.BigDecimal;

public class DetailItem {

    //保存したい情報
    private String typeOfWork;
    private String workCategory;
    private String detailedItem;
    private String specification;
    private String unit;
    private BigDecimal quantity;

    //コンストラクタ
    public DetailItem(
        String typeOfWork,
        String workCategory,
        String detailedItem,
        String specification,
        String unit,
        BigDecimal quantity
    ){
        this.typeOfWork = typeOfWork;
        this.workCategory = workCategory;
        this.detailedItem = detailedItem;
        this.specification = specification;
        this.unit = unit;
        this.quantity = quantity;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public String getWorkCategory() {
        return workCategory;
    }

    public String getDetailedItem() {
        return detailedItem;
    }

    public String getSpecification() {
        return specification;
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

}
