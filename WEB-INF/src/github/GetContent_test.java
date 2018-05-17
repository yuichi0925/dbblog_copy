package github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class GetContent_test {

	public static String github_url = "https://api.github.com/repos/yuichi0925/test_netbeans";
	public static String yahoo_url = "https://www.yahoo.co.jp/";

	/*
	 * GitHubのAPIのURLを分割する
	 * [4]にはオーナー名，[5]にはリポジトリ名が入る
	 */
	public static String[] github_owner = github_url.split("/");



	/*
	 * Webページのソースの取得
	 */
	public static String getcontent(String url) {
		StringBuilder response = new StringBuilder();
		try {
			URL url1 = new URL(url);
			Object content = url1.getContent();
			if (content instanceof InputStream) {
				InputStreamReader i = new InputStreamReader((InputStream)content);
				BufferedReader bf = new BufferedReader(i);

				String str;
				while((str = bf.readLine()) != null) {
					response.append(str).append('\n');
				}
			}
		}catch(IOException e) {
			System.out.println("コンテンツの取得に失敗しました.");
		}


		return response.toString();
	}


	public static void main(String[] args) {
		//System.out.println(getcontent(yahoo_url));
		System.out.println(getcontent(github_url));

		System.out.println("オーナー名：" + github_owner[4] + "，リポジトリ名：" + github_owner[5]);

	}
}