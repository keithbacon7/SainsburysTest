package sainsburystest;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

/**
 * A stub for unit testing. We could be using Spring and be injecting mocks.
 */
public class JSoupResponseTestStub implements Connection.Response {
	private Map<String, String> headers = new HashMap<>();
	private String body;

	public JSoupResponseTestStub(String body) {
		this.body = body;
	}

	@Override
	public URL url() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.jsoup.Connection.Response url(URL url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Method method() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.jsoup.Connection.Response method(Method method) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String header(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.jsoup.Connection.Response header(String name, String value) {
		headers.put(name, value);
		return this;
	}

	@Override
	public boolean hasHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasHeaderWithValue(String name, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public org.jsoup.Connection.Response removeHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> headers() {
		return headers;
	}

	@Override
	public String cookie(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.jsoup.Connection.Response cookie(String name, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCookie(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public org.jsoup.Connection.Response removeCookie(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> cookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int statusCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String statusMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String charset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String contentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document parse() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String body() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] bodyAsBytes() {
		return body.getBytes();
	}
}
