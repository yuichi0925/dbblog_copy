package github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test2 {

	public static String github_url = "https://api.github.com/repos/yuichi0925/test_netbeans/commits?per_page=100";

	/*
	 * コミットのAPIのURLに接続し，コミット者とコミットメッセージを取得
	 */
    public static void main(String[] args) {
    	StringBuilder response = new StringBuilder();
        ObjectMapper mapper = new ObjectMapper();
        try {

        	URL url = new URL(github_url);
        	Object content = url.getContent();
        	if (content instanceof InputStream) {
        		InputStreamReader inst = new InputStreamReader((InputStream)content);
        		BufferedReader bf = new BufferedReader(inst);
        		String str;
        		while((str = bf.readLine()) != null) {
        			response.append(str).append('\n');
        		}
        	}
        	//System.out.println(response);

        	JsonNode node = mapper.readValue(response.toString(),JsonNode.class);
        	//System.out.println(node);

        	int i = 0;
        	while(node.get(i) != null) {
        		String name = node.get(i).get("commit").get("author").get("name").asText();
        		String message = node.get(i).get("commit").get("message").asText();
        		System.out.println(name);
        		System.out.println(message + "\n");
        		i++;
        	}
        } catch (IOException e) {
            System.out.println("コンテンツの取得に失敗しました．");
        }


    }

}