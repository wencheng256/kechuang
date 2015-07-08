<%@page language="java" import="mo.*,java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title>山东大学（威海）科研立项项目注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<!-- Stylesheets -->
<link href="style/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="style/font-awesome.css">
<link href="style/style.css" rel="stylesheet">
<link href="style/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon/favicon.png">
</head>

<body>

	<div class="admin-form">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Widget starts -->
					<div class="widget wred">
						<div class="widget-head">
							<i class="icon-lock"></i> 山东大学（威海）<%=MySystem.getValue("grade") %>
							年项目注册
						</div>
						<div class="widget-content">
							<div class="padd">

								<form class="form-horizontal" action="register.action"
									method="post">
									<!-- Registration form starts -->
									<!-- Name -->
									<div class="alert alert-warning">
										<s:fielderror />
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3" for="name">项目名</label>
										<div class="col-lg-9">
											<input type="text" name="name" class="form-control" id="name" >
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3" for="name">登陆用户名（英文）</label>
										<div class="col-lg-9">
											<input type="text" class="form-control" id="name"
												name="username">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3" for="name">登陆密码</label>
										<div class="col-lg-9">
											<input type="password" class="form-control" id="name"
												name="password">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3" for="name">项目编号(学校统一发放)</label>
										<div class="col-lg-9">
											<input type="text"  name="proj_permitid" class="form-control" id="name">
										</div>
									</div>
									<!-- Select box -->
									<div class="form-group">
										<label class="control-label col-lg-3">项目类型</label>
										<div class="col-lg-9">
											<select class="form-control" name="classes">
												<option value="-1">－－请选择项目类型－－</option>
												<option value="1">A</option>
												<option value="2">B</option>
												<option value="3">C</option>
												<option value="4">D</option>
												<option value="5">科研班主任</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-lg-3">学院</label>
										<div class="col-lg-9">
											<select class="form-control" name="school">
												<option value=-1>－－请选择项目所属学院－－</option>
												<%School sc1=new School();
                                            		Iterator<School>  itsr=sc1.selectAll();
                                            		while(itsr.hasNext()){
                                            			School str=itsr.next();
                                            		%>
												<option value="<%=str.getId()%>"><%= str.getName()%></option>
												<%} %>
											</select>
										</div>
									</div>
									<!-- Accept box and button s-->
									<div class="form-group">
										<div class="col-lg-9 col-lg-offset-3">
											<div class="checkbox">
												<label> <input type="checkbox" name="iwill" value="sdasdas">
													我会遵守 <a href="<%=MySystem.getValue("guiding") %>" target="blank">学校关于科研立项的相关规定</a>
												</label>
											</div>
											<br />
											<button type="submit" class="btn btn-danger">提交</button>
											<button type="reset" class="btn btn-success">重置</button>
										</div>
									</div>
									<br /> <input type="hidden" class="form-control" name="grade"
										value="<%=MySystem.getValue("grade")%>">
								</form>

							</div>
						</div>
						<div class="widget-foot">
							项目已经注册过了? <a href="login.jsp">登陆</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- JS -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>