/** Bounces back HTTP Request**/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class echoapp extends HttpServlet {

	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		handleRequest(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		handleRequest(req, res);
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		Enumeration<String> headerNames = req.getHeaderNames();
		
		out.write("<head><title>EchoApp - HTTP Request Bouncer</title></head>");
		out.write("<h1>HTTP Request Echo</h1>");
		
		while (headerNames.hasMoreElements()) {

			String headerName = headerNames.nextElement();
			out.write("<b>" + headerName + ": </b>");
			
			Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
				String headerValue = headers.nextElement();
				out.write(headerValue);
				out.write("<br/>");
			}

		}

		out.close();

	}

}
