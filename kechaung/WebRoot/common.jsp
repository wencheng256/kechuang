<%@ page language="java" import="mo.*,java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	Project proj = (Project) session.getAttribute("project");
	if (proj == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	double fareamount = proj.getFare().getProjectFare();
	int stunum=proj.getStudent().getCount();
	int jnum=proj.getJournal().getCount();
%>
	<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">

		<div class="conjtainer">
			<!-- Menu button for smallar screens -->
			<div class="navbar-header">
				<button class="navbar-toggle btn-navbar" type="button"
					data-toggle="collapse" data-target=".bs-navbar-collapse">
					<span>菜单</span>
				</button>
				<!-- Site name for smallar screens -->
				<a href="index.html" class="navbar-brand hidden-lg">首页</a>
			</div>

			<!-- 导航 -->
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">

				<!-- 团队信息 -->
				<ul class="nav navbar-nav pull-right">
					<li class="dropdown pull-right"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="icon-user"></i> <%=proj.getName()%>
							<b class="caret"></b>
					</a> <!-- Dropdown menu -->
						<ul class="dropdown-menu">
							<li><a href="project.jsp"><i class="icon-cogs"></i> 设置</a></li>
							<li><a href="exit.action"><i class="icon-off"></i> 退出</a></li>
						</ul></li>

				</ul>
			</nav>

		</div>
	</div>
	<!-- 顶部 -->
	<header>
		<div class="container">
			<div class="row">

				<!-- Logo section -->
				<div class="col-md-4">
					<!-- Logo. -->
					<div class="logo">
						<h1>
							<a href="#" style="font-family:微软雅黑; font-size:25px;";>山东大学（威海）<span
								class="bold"></span></a>
						</h1>
						<p class="meta">科研立项管理系统</p>
					</div>
					<!-- Logo ends -->
				</div>

				<!-- Button section -->
				<div class="col-md-4">

					<!-- Buttons -->
					<ul class="nav nav-pills">
					
					 <li class="dropdown dropdown-big">
              <a href="updatedata.action" >
                <i class="icon-comments"> </i> 更新页面数据</span> 
              </a> </li>

						<!-- Message button with number of latest messages count-->
						<li class="dropdown dropdown-big"><a class="dropdown-toggle"
							href="#" data-toggle="dropdown"> <i class="icon-envelope-alt"></i>
								项目日志 <span class="label label-primary"><%=jnum %></span>
						</a>

							<ul class="dropdown-menu">
								<li>
									<!-- Heading - h5 -->
									<h5>
										<i class="icon-envelope-alt"></i> 项目日志
									</h5> <!-- Use hr tag to add border -->
									<hr />
								</li>

								<!--  站内信循环开始 -->
								
								<%
										Iterator<ProjectJournal> itjourna11=proj.getJournal().selectProj3();
										int bianhao1=0;
										while(itjourna11.hasNext()){
											bianhao1++;
											ProjectJournal jt1=itjourna11.next();
								%>
								<li>
									<!-- List item heading h6 -->
									<h6>
										<a href="#">项<%=jt1.getTitle() %></a>
									</h6> <!-- List item para -->
									<p><%=jt1.getTime() %></p>
									<hr />
								</li>
								<%} %>
								<!--  站内信循环结束 -->

								<li>
									<div class="drop-foot">
										<a href="#">查看所有</a>
									</div>
								</li>
							</ul></li>

						<!-- Members button with number of latest members count -->
						<li class="dropdown dropdown-big"><a class="dropdown-toggle"
							href="#" data-toggle="dropdown"> <i class="icon-user"></i> 成员
								<span class="label label-success"><%=stunum %></span>
						</a>

							<ul class="dropdown-menu">
								<li>
									<!-- Heading - h5 -->
									<h5>
										<i class="icon-user"></i> 成员
									</h5> <!-- Use hr tag to add border -->
									<hr />
								</li>


								<%Iterator<Student> itstu=proj.getStudent().selectProject();
									while(itstu.hasNext()){
										Student stut=itstu.next();
								%>
								<li>
									<!-- List item heading h6--> <!--  成员循环开始 -->
									<h6>
										<%=stut.getName()%><%if(stut.getIs_cap()==1) {%> <span
											class="label label-warning pull-right">队长</span><%} %>
									</h6>
									<div class="clearfix"></div>
									<hr />
								</li>
								<!-- 成员循环结束 -->
								<%} %>

							</ul>
							</li>

					</ul>

				</div>

				<!-- Data section -->

				<div class="col-md-4">
					<!-- 顶部消息 -->
					<div class="header-data">

						<!-- Traffic data -->
						<div class="hdata">
							<div class="mcol-left">
								<!-- Icon with red background -->
								<i class="icon-signal bred"></i>
							</div>

							<div class="mcol-right">
								<!-- Number of visitors -->
								<p>
									<a href="#"><%=jnum %></a> <em>日志</em>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>

						<!-- Members data -->
						<div class="hdata">
							<div class="mcol-left">
								<!-- Icon with blue background -->
								<i class="icon-user bblue"></i>
							</div>
							<div class="mcol-right">
								<!-- Number of visitors -->
								<p>
									<a href="#"><%=stunum %></a> <em>队员</em>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>

						<!-- revenue data -->
						<div class="hdata">
							<div class="mcol-left">
								<!-- Icon with green background -->
								<i class="icon-money bgreen"></i>
							</div>
							<div class="mcol-right">
								<!-- Number of visitors -->
								<p>
									<a href="#"><%=fareamount%></a><em>经费</em>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</header>