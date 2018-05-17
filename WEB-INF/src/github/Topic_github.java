package github;

public class Topic_github {
	public static final String schema = "https://api.github.com"; //GitHubのAPIのURL
	public static final String repository = "/repos"; //リポジトリ
	public static String repos_name = "/yuichi0925/test_netbeans";

	public static String repos_url;
	public static String commits_url;

	/*
	 * セッタ，ゲッタ
	 */
	public static String getRepos_name() {
		return repos_name;
	}
	public static void setRepos_name(String repos_name) {
		Topic_github.repos_name = repos_name;
	}

	public static String getRepos_url() {
		return repos_url;
	}
	public static void setRepos_url(String repos_name) {
		Topic_github.repos_url = "https://api.github.com/repos" + repos_name;
	}

	public static String getCommits_url() {
		return commits_url;
	}
	public static void setCommits_url(String commits_url) {
		Topic_github.commits_url = commits_url;
	}

	public static String getSchema() {
		return schema;
	}

	public static String getRepository() {
		return repository;
	}
}
