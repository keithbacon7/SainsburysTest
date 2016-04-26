package sainsburystest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Potentially sharable utility methods
 */
public class Utils {
	/**
	 * Passed money value is formatted in standard way for JSON data. eg 1.23,
	 * 1.50, 1,234.00
	 * 
	 * @param d
	 * @return
	 */
	public static String formatMoneyForJsonData(BigDecimal d) {
		MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
		BigDecimal x = d.round(mc);

		DecimalFormat df = new DecimalFormat("##,##0.00");
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(false);
		String result = df.format(x);
		return result;
	}

	/**
	 * A size in bytes is returned standard format for JSON data eg. 12kb,
	 * 1.2kb, 1,2345,6kb
	 * 
	 * @param sizeInBytes
	 * @return input in standard format for JSON data.
	 */
	public static String formatSizeForJsonData(int sizeInBytes) {
		BigDecimal d = new BigDecimal(sizeInBytes);
		d = d.divide(BigDecimal.valueOf(1000));

		MathContext mc = new MathContext(1, RoundingMode.HALF_UP);
		BigDecimal x = d.round(mc);

		DecimalFormat df = new DecimalFormat("##,##0.#kb");
		df.setMaximumFractionDigits(1);
		df.setMinimumFractionDigits(1);
		df.setGroupingUsed(false);
		String result = df.format(x);
		return result;
	}

	public static int stringToInt(String s) {
		if (s == null) {
			return 0;
		} else {
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return -1;
			}
		}
	}

}
