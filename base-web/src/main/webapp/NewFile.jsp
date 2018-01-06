<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = request.getContextPath();%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		<script type="text/javascript" src="<%=basePath%>/jsp/js/"></script>
<script type="text/javascript">  
    $(document).ready(function(){  
        var saveDataAry=[];  
        var data1={"value1":"迪方多","value2":"方多"};  
        var data2={"value1":"ququ","value2":"gr"};  
        saveDataAry.push(data1);  
        saveDataAry.push(data2);  
        console.log((JSON.stringify(saveDataAry)));
        $.ajax({ 
            type:"POST", 
            url:"/base-web/appraisal/memory", 
            dataType:"json",      
            contentType:"application/json",               
            data:{"msg":JSON.stringify(saveDataAry)}, 
            success:function(data){ 
               alert(data+"啊啊啊啊啊啊啊啊啊啊")                        
            },
            error:function(data){
            	alert("error"+data);
            }
         }); 
    });  
</script> 
</head>
<body>
	<form action="http://192.168.1.17:8080/base-web/appUpdate/download" method="post" enctype="multipart/form-data">
		<table width="50%" height="275" border="1" cellpadding="0"
			cellspacing="0">
		<!-- 	<tr>
				<td>id</td>
				<td><label> <input type="text" name="id" />
				</label></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>sex</td>
				<td><input type="text" name="sex" /></td>
			</tr>
			<tr>
				<td>remark</td>
				<td><input type="text" name="remark" /></td>
			</tr>
			<tr>
				<td>createBy</td>
				<td><input type="text" name="createBy" /></td>
			</tr>
			<tr>
				<td>updateBy</td>
				<td><input type="text" name="updateBy" /></td>
			</tr> -->
			<tr>
				<td>文件上传</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
				<!-- <input type="submit" value="上传文件" /> -->
				<input type="text" name="appname" value="全数据智慧社区">
				</td>
				
			</tr>
		</table>
		<input type="submit" value="点我下载app"></input>
	</form></body>
</html>