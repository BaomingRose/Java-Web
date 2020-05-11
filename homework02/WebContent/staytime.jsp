<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stayTime</title>
</head>
<body>
    <script type = "text/javascript">
    	var second = 0;
    	window.setInterval(function() {
        	second++;
        	document.write("<h1>" + "停留时间：" + second + "秒了" + "</h1>");
        	document.close();
    	}, 1000);
    	
    	window.setInterval(function() {
    		alert("停留页面" + second + "秒了");
    	}, 10000);
    </script>
</body>
</html>