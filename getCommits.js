function getCommits(repos_name){

$.getJSON('https://api.github.com/repos/' + repos_name + '/commits?',{per_page:100})
.done(function(data){
	for(var i in data){
		$("#output").append("<hr>リビジョン" + (data.length - i));
		$("#output").append("<p>コミット者：" + data[i].commit.committer.name + "</p>");
		$("#output").append("<p>コミット日：" + data[i].commit.committer.date + "</p>");
		$("#output").append("<p>コミットメッセージ：" + data[i].commit.message + "</p>");
	}
})
.fail(function(){
	if(repos_name==""){
	}
	else{
		$("#output").append("コミット情報を取得できませんでした");
	}
});

}