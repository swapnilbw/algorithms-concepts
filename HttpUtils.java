package com.example;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;

/**
 * Http utility class to make REST calls to 3rd party services like Elastic, Big
 * Data
 * 
 * @author ssuryawa
 *
 */
public class HttpUtils {

	/** LOGGER */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(HttpUtils.class);

	/**
	 * Invoke a HTTP GET call
	 * 
	 * @param url
	 * @return httpResponse
	 * @throws Exception
	 */
	public static CloseableHttpResponse httpGet(String url) throws Exception {
		LOGGER.info("--------HttpUtils.httpGet invoked--------");
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpResponse = httpClient.execute(httpGet);
		LOGGER.info("--------HttpUtils.httpGet finished----------");
		return httpResponse;
	}

	/**
	 * Calls HTTP POST to 3rd party service & converts HTTP response to standard
	 * ServiceResponse
	 * 
	 * @param url
	 * @param jsonBody
	 * @return serviceResponse
	 * @throws Exception
	 */
	public static ServiceResponse httpPostServiceResponse(String url,
			StringEntity jsonBody) throws Exception {

		LOGGER.info("--------HttpUtils.httpPostServiceResponse invoked--------");
		ServiceResponse response = new ServiceResponse();
		response.setScore(new Double(0));
		response.setTotalScore(new Double(0));

		try {
			CloseableHttpResponse httpResponse = httpPostJson(url, jsonBody);
			if (isValideHttpResponse(httpResponse)) {
				LOGGER.info("HttpUtils.httpPostServiceResponse >>> Response   >>> "
						+ httpResponse);
				// Headers
				org.apache.http.Header[] headers = httpResponse.getAllHeaders();
				if (null != headers) {
					for (org.apache.http.Header header : headers) {
						LOGGER.info("HttpUtils.httpPostServiceResponse >>> Headers >>> "
								+ header.toString());
					}
				}
				InputStream inputStream = httpResponse.getEntity().getContent();
				String stream = IOUtils.toString(inputStream, "UTF-8");
				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject) parser.parse(stream);
				if (null != jsonObject) {
					JSONObject hits = (JSONObject) jsonObject.get("hits");
					if (null != hits && hits.size() > 0) {
						long total = (long) hits.get("total");
						JSONArray child_hits = (JSONArray) hits.get("hits");
						Iterator<?> itr = child_hits.iterator();
						JSONObject childObj = null;
						if (itr.hasNext())
							childObj = (JSONObject) itr.next();

						if (0 != total) {
							Double max_score = (Double) hits.get("max_score");
							Double score = (Double) childObj.get("_score");
							response.setTotalScore(max_score);
							response.setScore(score);
						}
					} else {
						System.out.println("No Document found");
					}
				} else {
					System.out.println("Error occured");
				}
			} else {
				LOGGER.info("HttpUtils.httpPostServiceResponse >>> Null or invalid HTTP Response   >>> "
						+ httpResponse);
			}
		} catch (Exception e) {
			LOGGER.error(
					"HttpUtils.httpPostServiceResponse >>> Exception >>> ", e);
		}
		LOGGER.info("--------HttpUtils.httpPostServiceResponse finished--------");
		return response;
	}

	/**
	 * HTTP post call to 3rd party services
	 * 
	 * @param url
	 * @param jsonBody
	 * @return httpResponse
	 */
	public static CloseableHttpResponse httpPostJson(String url,
			StringEntity jsonBody) throws Exception {
		LOGGER.info("--------HttpUtils.httpPostJson invoked----------");
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setEntity(jsonBody);
		httpResponse = httpClient.execute(httpPost);
		LOGGER.info("--------HttpUtils.httpPostJson finished----------");
		return httpResponse;
	}

	/**
	 * Method to validate HTTP response
	 * 
	 * @param httpResponse
	 * @return true/false
	 */
	private static boolean isValideHttpResponse(
			CloseableHttpResponse httpResponse) {
		LOGGER.info("--------HttpUtils.validateHttpResponse invoked----------");
		boolean httpOk = false;
		if (null != httpResponse && null != httpResponse.getStatusLine()) {
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			String status = httpResponse.getStatusLine().getReasonPhrase();

			if ("OK".equalsIgnoreCase(status) && statusCode == 200) {
				LOGGER.info("HTTP method completed successfully, status : "
						+ status + " & statusCode : " + statusCode);
				httpOk = true;
			} else {
				LOGGER.error("HTTP method failed, status : " + status
						+ " & statusCode : " + statusCode);
				httpOk = false;
			}
		} else {
			httpOk = false;
			LOGGER.error("Call to REST Service failed.");
			LOGGER.info("--------HttpUtils.validateHttpResponse completed----------");
		}
		return httpOk;
	}
}
