package sainsburystest;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Uses Jsoup to fetch data from a URL.
 * <li>The data is returned as a Jsoup Document.
 * <li>The data size of the fetched web page is made available.
 * 
 * @author xxx
 *
 */
public class DocumentGetter {
	Document document;
	Connection.Response response;

	/**
	 * Allows unit testing
	 * 
	 * @param document
	 * @param response
	 */
	public DocumentGetter(Document document, Connection.Response response) {
		this.document = document;
		this.response = response;
	}

	/**
	 * Normal usage. Fetches data from passed URL.
	 * 
	 * @param url
	 */
	public DocumentGetter(String url) {
		try {
			logIt("getDoc: url: " + url);
			Connection c = Jsoup.connect(url);
			document = c.get();
			response = c.response();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Document getDocument() {
		return document;
	}

	/**
	 * This has not been investigated fully so result may be unreliable.
	 * <li>Use Content-Length from response header.
	 * <li>If not use the length of the response body.
	 * 
	 * @return Number of bytes in the response body.
	 */
	public int getContentLength() {
		int bodySize = response.bodyAsBytes().length;

		String s = response.headers().get("Content-Length");
		int headerContentlLength = Utils.stringToInt(s);

		// logIt("getResponseSize: headerContentlLength: " +
		// headerContentlLength + " bodySize: " + bodySize);
		int responseSize = 0;
		if (headerContentlLength > 0) {
			responseSize = headerContentlLength;
		} else {
			responseSize = bodySize;
		}
		return responseSize;
	}

	private static void logIt(String line) {
		System.out.println("DocumentGetter: " + line);
	}

}
