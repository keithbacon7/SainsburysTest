package sainsburystest;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * A list of Product Data to be serialized by Gson conversion to JSON.
 * 
 * @author user
 *
 */

public class ProductListDTO {
	// Included in JSON string
	private ArrayList<ProductDTO> results = new ArrayList<>();
	private String total = "0";
	// Not included in JSON string
	transient private BigDecimal numericTotal = BigDecimal.ZERO;

	public void add(ProductDTO p) {
		numericTotal = numericTotal.add(p.getNumericUnitPrice());
		total = Utils.formatMoneyForJsonData(numericTotal);
		results.add(p);
	}

	public ArrayList<ProductDTO> getResults() {
		return results;
	}

	public void setResults(ArrayList<ProductDTO> results) {
		this.results = results;
	}

	public String getTotal() {
		return total;
	}

	// public void setTotal(BigDecimal total) {
	// this.total = total;
	// }

	// public Map<String, String> getResults() {
	// return results;
	// }
	//
	// public void setResults(Map<String, String> results) {
	// this.results = results;
	// }
}
