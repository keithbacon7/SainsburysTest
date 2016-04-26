package sainsburystest;

import java.math.BigDecimal;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Scraper {
	private static final String TOP_LEVEL_URL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

	public String sainsburiesProductListAsJSON() {

		DocumentGetter getter = new DocumentGetter(TOP_LEVEL_URL);
		Document topLevelDoc = getter.getDocument();

		ProductListDTO productList = new ProductListDTO();

		Elements products = topLevelDoc.select(".productLister li .product");
		for (Element elem : products) {
			productList.add(productElementToData(elem));

		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String result = gson.toJson(productList);
		out("result:\n" + result);
		return result;
	}

	/**
	 * Extracts data from the html element for a single product and returns it
	 * in a Product Data Object.
	 * 
	 * @param elem
	 * @return
	 */
	private ProductDTO productElementToData(Element elem) {
		Elements unitPriceElements = elem.select(".pricing");

		Element unitPriceElement = unitPriceElements.first();
		String unitPrice = "0.0";
		for (Element e : unitPriceElement.getAllElements()) {
			String s = e.ownText();
			if (s.indexOf("&pound") >= 0) {
				unitPrice = s.replace("&pound", "");
			}
		}

		Elements productLinks = elem.select(".productInfo a");
		Element productLink = productLinks.first();

		String linkUrl = productLink.attr("href");
		String title = productLink.text();

		DocumentGetter productPageGetter = new DocumentGetter(linkUrl);
		Document productDocument = productPageGetter.getDocument();

		Element productTextElement = productDocument.select(".productText").first();
		String productText = productTextElement.text();

		ProductDTO pdata = new ProductDTO();
		pdata.setTitle(title);
		pdata.setNumericSize(productPageGetter.getContentLength());
		pdata.setNumericUnitPrice(new BigDecimal(unitPrice));
		pdata.setDescription(productText);
		return pdata;
	}

	private static void out(String line) {
		System.out.println("Scraper: " + line);
	}

}
