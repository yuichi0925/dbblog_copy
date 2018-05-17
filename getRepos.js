function getRepos(repos_name){

$.getJSON('https://api.github.com/repos/' + repos_name)
	.done(function(data){
		$("#repos").append("<h3>リポジトリ情報</h3>");
		$("#repos").append("<p>リポジトリ名　" + data.name + "</p>");
		$("#repos").append("<p>オーナー名　" + data.owner.login + "</p>");
	})
	.fail(function(){
		if(repos_name==""){
		}
		else{
			$("#repos").append("リポジトリ情報を取得できませんでした");
		}
	});
}