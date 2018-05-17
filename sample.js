$( function() {
	$('#btn1').click(
	function(){
		$("#out1").html("データ取得中です");

		// 1. $.getJSONメソッドで通信を行う
		//   $.getJSON(通信先,送信するデータ)
		$.getJSON('https://api.github.com/repos/yuichi0925/test_netbeans/commits')

			// 2. doneは、通信に成功した時に実行される
			//  引数のdata1は、通信で取得したデータ
			.done(function(data1) {

				// 3. キーを指定して値を表示 (5pmが表示される)
				$("#out1").html(data1["1"]["commit"]["committer"]["name"]);

				// 4. オブジェクトをJSON形式の文字列に変換
				var data2 = JSON.stringify(data1);
				console.log(data2); //コンソールにJSON形式で表示される
			})

			// 5. failは、通信に失敗した時に実行される
			.fail(function() {
				$("#out1").html("取得に失敗しました");
			})

			// 6. alwaysは、成功/失敗に関わらず実行される
			.always(function() {
				$("#out2").html("完了しました");
			});
	});
} );