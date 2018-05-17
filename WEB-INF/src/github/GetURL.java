package github;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetURL {

	/*
	 * 必要なリポジトリのURLを取得する．
	 */
	public static void getRepos() {
		String response = GetContent.getContent(Topic_github.getRepos_url());
		ObjectMapper mapper = new ObjectMapper();

		try {
		JsonNode node = mapper.readValue(response,JsonNode.class);
		//System.out.println(node);

		//これより以下に取得したいURLの情報を書く
		String commits_url = node.get("commits_url").asText();
		String[] str = commits_url.split("\\{");
		commits_url = str[0];
		//System.out.println(commits_url);
		Topic_github.setCommits_url(commits_url);

		}catch(IOException e) {
			//System.out.println("コンテンツの取得に失敗しました．");
		}
	}

	/*
	 * コミットに関する情報を取得する．
	 */
	public static void getCommits(String commits_url) {
		String response = GetContent.getContent(Topic_github.commits_url);
		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode node = mapper.readValue(response,JsonNode.class);
			//System.out.println(node);

			//これより以下に取得したいURLの情報を書く
			int i=0;
			while(node.get(i) != null) {
				String name = node.get(i).get("commit").get("committer").get("name").asText();
				String date = node.get(i).get("commit").get("committer").get("date").asText();
				String message = node.get(i).get("commit").get("message").asText();
				System.out.println(name);
				System.out.println(date);
				System.out.println(message + "\n");
				i++;
			}
			}catch(IOException e) {
				//System.out.println("コンテンツの取得に失敗しました．");
			}
	}

	public static void main(String[] args) {
		Topic_github.setRepos_url(Topic_github.getRepos_name());
		getRepos();
		System.out.println(Topic_github.getCommits_url());

		getCommits(Topic_github.getCommits_url());

	}

}
