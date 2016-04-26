package sainsburystest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

/**
 * Integration test for the Scraper class. Converts Scrapers output JSON data
 * into java class and checks for expected values in it.
 * 
 * @author user
 *
 */
public class ScraperTestInt {
	Scraper test;
	String jsonData;
	ProductListDTO list;

	@Before
	public void setup() {
		test = new Scraper();
		jsonData = test.sainsburiesProductListAsJSON();
		Gson gson = new Gson();
		list = gson.fromJson(jsonData, ProductListDTO.class);
	}

	// TODO only checks first product so far.
	@Test
	public void product1_description() {
		ProductDTO firstProduct = list.getResults().get(0);
		assertEquals("Apricots", firstProduct.getDescription());
	}

	@Test
	public void product1_size() {
		ProductDTO firstProduct = list.getResults().get(0);
		assertEquals("40.0kb", firstProduct.getSize());
	}

	/**
	 * This is always zero as it it is not serailized in the JSON.
	 */
	@Test
	public void product1_numericSize() {
		ProductDTO firstProduct = list.getResults().get(0);
		assertEquals(0, firstProduct.getNumericSize());
	}

	@Test
	public void product1_title() {
		ProductDTO firstProduct = list.getResults().get(0);
		assertEquals("Sainsbury's Apricot Ripe & Ready x5", firstProduct.getTitle());

	}

}
