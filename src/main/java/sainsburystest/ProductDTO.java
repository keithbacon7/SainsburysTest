package sainsburystest;

import java.math.BigDecimal;

/**
 * Product Data to be serialized by Gson conversion to JSON.
 * 
 * @author user
 *
 */
public class ProductDTO {
	// Included in JSON string
	private String title;
	private String size;
	private String unit_price;
	private String description;
	// Not included in JSON string
	transient private int numericSize;
	transient private BigDecimal numericUnitPrice;

	public ProductDTO() {

	}

	// Standard get/set.
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSize() {
		return size;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumericSize() {
		return numericSize;
	}

	public void setNumericSize(int numericSize) {
		this.numericSize = numericSize;
		size = Utils.formatSizeForJsonData(numericSize);
	}

	public BigDecimal getNumericUnitPrice() {
		return numericUnitPrice;
	}

	public void setNumericUnitPrice(BigDecimal numericUnitPrice) {
		this.numericUnitPrice = numericUnitPrice;
		unit_price = Utils.formatMoneyForJsonData(numericUnitPrice);
	}
}
