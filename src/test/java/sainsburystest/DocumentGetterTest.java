package sainsburystest;

import static org.junit.Assert.assertEquals;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

public class DocumentGetterTest {
	DocumentGetter test;

	@Before
	public void setup() {
		String html = "<h1>Heading 1</h1>";
		Document doc = Jsoup.parse(html);
		Connection.Response response = new JSoupResponseTestStub(html);
		response.header("ResponseHeader1", "123");
		test = new DocumentGetter(doc, response);
	}

	@Test
	public void getDocument() {
		Elements elems = test.getDocument().select("h1");
		String text = elems.first().text();
		assertEquals("Heading 1", text);
	}

	@Test
	public void getResponseSize() {
		int responseSize = test.getContentLength();
		assertEquals(36, responseSize);
	}

}
