/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//http://json-lib.sourceforge.net/
import net.sf.json.JSONObject;

public class Page2images {
	private static final long serialVersionUID = 1L;

	/*
	 * simple java to demo Pull mode
	 */
	public String apikey = "a219cad12987f722";
	public String api_url = "http://api.page2images.com/restfullink";

	public static void main(String[] args) {
		// test api
		Page2images p2i = new Page2images();
		// test pull mode
		p2iObject p1 = p2i.call_p2i();
		System.out.println(p1.toString());
		// test push mode
		p2i.call_p2i_with_callback();
	}

	/**
	 * pull mode
	 * 
	 * @return
	 */
	public p2iObject call_p2i() {
		// URL can be those formats: http://www.google.com https://google.com
		// google.com and www.google.com
		String url = "https://www.jotform.com/submissions/60656757780165";
		// 0 - iPhone4, 1 - iPhone5, 2 - Android, 3 - WinPhone, 4 - iPad, 5 -
		// Android Pad, 6 - Desktop
		int device = 6;
		// timeout after 120 seconds
		int timeout = 120;
		// p2i_url={url}&p2i_key={apikey}=&p2i_device={device}
		String para = "p2i_url=" + url + "&p2i_key=" + this.apikey + "&p2i_device=" + device;
		boolean loop_flag = true;
		p2iObject p2i = null;
		long starttime = System.currentTimeMillis();
		while (loop_flag) {
			p2i = new p2iObject();
			// connect page2images server
			JSONObject jsonObject = connP2i(para);
			// parse data from server
			p2i = parseData(jsonObject, p2i);
			if ("processing".equals(p2i.status)) {
				// We need call the API until we get the screenshot or error
				// message
				long endtime = System.currentTimeMillis();
				// timeout
				//System.out.println(endtime-starttime);
				if (endtime - starttime > timeout * 1000) {
					p2i.timeout = true;
					p2i.status = "error";
					p2i.msg = "Time out";
					loop_flag = false;
					break;
				}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				loop_flag = false;
				break;
			}
		}
		return p2i;
	}

	/**
	 * parse data from server
	 * 
	 * @param jsonObject
	 * @param p2i
	 * @return
	 */
	public p2iObject parseData(JSONObject jsonObject, p2iObject p2i) {
		System.out.println(jsonObject);
		if (jsonObject == null) {
			p2i.status = "error";
			p2i.msg = "a null value is returned";
		}
		String status = "";
		if (jsonObject.has("status")) {
			status = jsonObject.get("status") + "";
		}
		if ("".equals(status) || status == null) {
			p2i.status = "error";
			p2i.msg = "a null value is returned";
		} else if ("error".equals(status)) {
			p2i.status = "error";
			if (jsonObject.has("msg")) {
				p2i.msg = jsonObject.get("msg") + "";
			}
			if (jsonObject.has("errno")) {
				p2i.errno = jsonObject.get("errno") + "";
			}
		} else if ("finished".equals(status)) {
			p2i.status = "finished";
			if (jsonObject.has("duration")) {
				p2i.duration = jsonObject.get("duration") + "";
			}
			if (jsonObject.has("left_calls")) {
				p2i.left_calls = jsonObject.get("left_calls") + "";
			}
			if (jsonObject.has("image_url")) {
				p2i.image_url = jsonObject.get("image_url") + "";
			}
		} else if ("processing".equals(status)) {
			p2i.status = "processing";
			if (jsonObject.has("estimated_need_time")) {
				p2i.estimated_need_time = jsonObject.get("estimated_need_time") + "";
			}
		} else {
			p2i.status = "error";
			p2i.msg = "Api error";
		}
		return p2i;
	}

	/**
	 * connect page2images server
	 * 
	 * @param postdata
	 * @return
	 */
	public JSONObject connP2i(String postdata) {
		JSONObject jsonObject = null;
		HttpURLConnection myurlcon = null;
		try {
			// use unirest lib

			java.net.URL url = new URL(this.api_url);
			myurlcon = (HttpURLConnection) url.openConnection();
			myurlcon.setConnectTimeout(30000);
			myurlcon.setReadTimeout(30000);
			myurlcon.setDoOutput(true);
			myurlcon.setRequestMethod("POST");
			String strlength = new Integer(postdata.length()).toString();
			myurlcon.setRequestProperty("Content-length", strlength);
			myurlcon.connect();
			DataOutputStream out = new DataOutputStream(myurlcon.getOutputStream());
			out.writeBytes(postdata);
			out.flush();
			out.close();
			InputStream in = myurlcon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String data = "";
			String s = "";
			while ((s = br.readLine()) != null) {
				data = data + s;
			}
			in.close();
			myurlcon.disconnect();

			jsonObject = JSONObject.fromObject(data);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (myurlcon != null) {
				myurlcon.disconnect();
			}
		}
		return jsonObject;
	}

	/**
	 * push mode
	 */
	public void call_p2i_with_callback() {
		// URL can be those formats: http://www.google.com https://google.com
		// google.com and www.google.com
		String url = "http://www.google.com";
		// 0 - iPhone4, 1 - iPhone5, 2 - Android, 3 - WinPhone, 4 - iPad, 5 -
		// Android Pad, 6 - Desktop
		int device = 0;
		// timeout after 120 seconds
		int timeout = 120;
		// you can pass us any parameters you like. We will pass it back.
		// Please make sure http://your_server_domain/api_callback can handle
		// our call
		String callback_url = "http://your_server_domain/api_callback?image_id=your_unique_image_id_here";
		// p2i_url={url}&p2i_key={apikey}=&p2i_device={device}
		String para = "p2i_url=" + url + "&p2i_key=" + this.apikey + "&p2i_device=" + device + "&p2i_callback=" + callback_url;

		JSONObject jsonObject = connP2i(para);
		p2iObject p2i = new p2iObject();
		p2i = parseData(jsonObject, p2i);
		if ("error".equals(p2i.status)) {
			// error
		} else {
			// success
		}
	}

	/***
	 *simple servlet to demo callback url
	 * http://your_server_domain/page2images?image_id=your_unique_image_id_here
	 ***/
	/*
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String image_id = request.getParameter("image_id");
		String result = request.getParameter("result");
		PrintWriter out = response.getWriter();
		if ("".equals(result) || result == null) {
			// error response data
			out.println("Error");
		} else {
			p2iObject p2i = new p2iObject();
			JSONObject jsonObject = JSONObject.fromObject(result);
			p2i = parseData(jsonObject, p2i);
			if ("finished".equals(p2i.status)) {
				// do something with finished
				out.println("Image Url:" + p2i.image_url);
				if (!"".equals(image_id) && image_id != null) {
					// do anything you want about the unique image id. We
					// suggest to use it to identify which url you send to us
					// since you can send 1,000 at one time.
					out.println("Image Id:" + image_id);
				}
			} else {
				// do something with error
				out.println("Status Error");
			}
		}

	}
	 */
	/**
	 * page2image object
	 * 
	 */
	public class p2iObject {
		private String status;
		private String msg;
		private String errno;
		private String image_url;
		private String duration;
		private String left_calls;
		private String estimated_need_time;
		private boolean timeout = false;

		public p2iObject() {
			this.status = "";
			this.msg = "";
			this.errno = "";
			this.image_url = "";
			this.left_calls = "";
			this.duration = "";
			this.estimated_need_time = "";
			this.timeout = false;
		}

		public String toString() {
			return "Status:" + this.status + ", Image Url:" + this.image_url + ", Left Calls:" + this.left_calls+", msg:"+this.msg;
		}
	}

}