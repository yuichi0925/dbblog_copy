package github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GetContent {

	/*
	 * 指定したURLのソースを取得
	 */
	public static String getContent(String arg_url) {
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL(arg_url);
			Object content = url.getContent();
			if (content instanceof InputStream) {
				InputStreamReader inst = new InputStreamReader((InputStream)content);
				BufferedReader bf = new BufferedReader(inst);
				String str;
				while( (str = bf.readLine()) != null ){
					response.append(str).append('\n');
				}
			}
		}catch(IOException e) {
			System.out.println("ソースの取得に失敗しました．");
		}

		return response.toString();
	}
}
