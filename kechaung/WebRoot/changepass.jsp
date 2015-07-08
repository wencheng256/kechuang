<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri ="/struts-tags" prefix ="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>山东大学(威海)科研立项管理系统</title> 
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

<!-- Form area -->
<div class="admin-form">
  <div class="container">

    <div class="row">
      <div class="col-md-12">
        <!-- Widget starts -->
            <div class="widget worange">
              <!-- Widget head -->
              <div class="widget-head">
                <i class="icon-lock"></i> 修改密码
              </div>

              <div class="widget-content">
                <div class="padd">
                 <div class="alert alert-warning">
					<s:fielderror />
				</div>
                  <!-- Login form -->
                  <form class="form-horizontal" action="proj_changepass.action" method="post">
                    <!-- Email -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputEmail">用户名</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" id="inputEmail"  name="username" placeholder="用户名">
                      </div>
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">项目名称</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" id="inputPassword" name="name" placeholder="名称">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">项目编号</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" id="inputPassword" name="num" placeholder="编号">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">新密码</label>
                      <div class="col-lg-9">
                        <input type="password" class="form-control" id="inputPassword" name="newp" placeholder="新密码">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="control-label col-lg-3" for="inputPassword">确认新密码</label>
                      <div class="col-lg-9">
                        <input type="password" class="form-control" id="inputPassword" name="cp" placeholder="确认密码">
                      </div>
                    </div>
                    <!-- Remember me checkbox and sign in button -->
                    <div class="form-group">
					<div class="col-lg-9 col-lg-offset-3">
                      <div class="checkbox">
                        <label>
                        </label>
						</div>
					</div>
					</div>
                        <div class="col-lg-9 col-lg-offset-2">
							<button type="submit" class="btn btn-danger">修改密码</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
                    <br />
                  </form>
				  
				</div>
                </div>
              
                <div class="widget-foot">
                  项目尚未注册？ <a href="register.jsp">注册</a> | <a href="School">教师登陆</a> | <a href="changepass.jsp">修改密码</a>
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