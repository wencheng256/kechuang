<%@page language="java" import="mo.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<!-- Title and other stuffs -->
<title>山东大学（威海）科研立项管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="">
<!-- Stylesheets -->
<link href="style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="style/jquery.cleditor.css">
<!-- Uniform -->
<link rel="stylesheet" href="style/uniform.default.css">
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="style/bootstrap-switch.css">
<!-- Main stylesheet -->
<link href="style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="style/widgets.css" rel="stylesheet">
<style type="text/css">
h4 {
	color: blue;
}
</style>

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon/favicon.png">
</head>

<body>

	<%@include file="common.jsp"%>
	<!-- Header ends -->

	<!-- Main content starts -->

	<div class="content">
		<!-- Sidebar -->
		<%@include file="slider.jsp"%>
		<!-- Sidebar ends -->

		<!-- Main bar -->
		<div class="mainbar">
			<!-- Page heading -->
			<div class="page-head">
				<h2 class="pull-left">
					<i class="icon-file-alt"></i> 山东大学（威海）科创中心
				</h2>

				<div class="clearfix"></div>

			</div>
			<!-- Page heading ends -->
			<!--中间部分开始 -->
			<div class="container">
				<div class="row">
					<!-- 新闻列表开始 -->
					<div class="col-md-4">
						<!-- Widget -->
						<div class="widget">
							<!-- Widget title -->
							<div class="widget-head">
								<div class="pull-left">新闻列表</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<!-- Widget content -->
								<div class="padd"  style="height:425px; overflow:auto;">


									<ul class="recent">
								
								<%
											Iterator<News> itne=new News().selectSchool(proj.getSchool());
										%>
										<!-- Chat by us. Use the class "by-me". -->
										<%
											while(itne.hasNext()){ News net=itne.next();
										%>
									
										<li>
											<div class="recent-content">
												<div class="recent-meta" style="text-align:right"><%=net.getDate() %> <%=net.getUsername() %></div>
												<div style="font-size:12px; line-height:20px;"><a href="newscontent.jsp?id=<%=net.getId()%>"><%=net.getTitle() %></a></div>

												<div class="clearfix"></div>
											</div>
										</li>
										<%} %>

									</ul>


								</div>
							</div>

						</div>
					</div>
					<!-- 新闻列表结束 -->

					<!-- 站内信 -->

					<div class="col-md-4">
						<!-- Widget -->
						<div class="widget">
							<!-- Widget title -->
							<div class="widget-head">
								<div class="pull-left">站内信</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">
								<!-- Widget content -->
								<div class="padd" style="height:370px; overflow:auto;">

									<ul class="chats">
										<%
											Message message=proj.getMessage();
																	Iterator<Message> itm=message.selectProject();
										%>
										<!-- Chat by us. Use the class "by-me". -->
										<%
											while(itm.hasNext()){ Message me1=itm.next();
										%>
										<%
											if(me1.getSender()!=proj.getId()) {
										%>
										<li class="by-me">
											<!-- Use the class "pull-left" in avatar -->
											<div class="avatar pull-left">
												<img src="img/xh.jpg" width="44px;" height="44px" alt="" />
											</div>

											<div class="chat-content">
												<!-- In meta area, first include "name" and then "time" -->
												<div class="chat-meta">
													<%=me1.getSenderstring()%><span class="pull-right"><%=me1.getTime()%></span>
												</div>
												<%=me1.getContent()%>
												<div class="clearfix"></div>
											</div>
										</li>
										<%
											}else{
										%>

										<!-- Chat by other. Use the class "by-other". -->
										<li class="by-other">
											<!-- Use the class "pull-right" in avatar -->
											<div class="avatar pull-right">
												<img src="img/xh.jpg" width="44px;" height="44px" alt="" />
											</div>

											<div class="chat-content">
												<!-- In the chat meta, first include "time" then "name" -->
												<div class="chat-meta">
													<%=me1.getTime()%>
													<span class="pull-right"><%=me1.getSenderstring()%></span>
												</div>
												<%=me1.getContent()%>
												<div class="clearfix"></div>
											</div>
										</li>
										<%
											}}
										%>
									</ul>

								</div>
								<!-- Widget footer -->
								<div class="widget-foot">

									<form class="form-inline" action="addmessage.action"
										method="post">
										<input type="hidden" name="sender" value="<%=proj.getId()%>">
										<input type="hidden" name="receiver" value="<%=proj.getId()%>">
										<div class="form-group">
											<input type="text" name="content" class="form-control"
												placeholder="请输入您的回复">
											<input type="hidden" name="url" value="<%=request.getRequestURL()+"?"+ request.getQueryString()%>">
										</div>
										<button type="submit" class="btn btn-primary">发送</button>
									</form>


								</div>
							</div>


						</div>
					</div>

					<!-- 站内信 -->


					<!-- 项目 Status -->
					<div class="col-md-4">
						<div class="widget">
							<!-- Widget title -->
							<div class="widget-head">
								<div class="pull-left">项目状态</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<!-- Widget content -->

								<table class="table table-striped table-bordered table-hover">
									<tr>
										<td>项目名称</td>
										<td><%=proj.getName() %></td>
									</tr>
									<tr>
										<td>指导老师</td>
										<td>
										<%Iterator<Director> itdir=proj.getDirector().selectProject();
											while(itdir.hasNext()){
												Director dirt=itdir.next();
											%> 
											<%=dirt.getName() %>
											<%} %>
										</td>
									</tr>
									<tr>
										<td>队员</td>
										<td>
											<%
												Iterator<Student> itstu1=proj.getStudent().selectProject();
																					while(itstu1.hasNext()){
																						Student stut1=itstu1.next();
											%> <%
 	if(stut1.getIs_cap()==1){
 %> <font color="blue"> <%
 	}
 %> <%=stut1.getName()%> <%
 	if(stut1.getIs_cap()==1){
 %>
										</font> <%
 	}
 %> &nbsp <!-- 成员循环结束 --> <%
 	}
 %>

										</td>
									</tr>
									<tr>
										<td>所属学院</td>
										<td><%=proj.getSchoolstring() %></td>
									</tr>
									<tr>
										<td>项目水平</td>
										<td><%if(proj.getImportant()==1){ %>重点立项<%}else{ %>一般项目<%} %></td>
									</tr>
									<tr>
										<td>项目分类</td>
										<td><%=proj.getClassstring() %></td>
									</tr>
									<tr>
										<td>项目状态</td>
										<td><%=proj.getStatusstring() %></td>
									</tr>
									<tr>
										<td>项目开始日期</td>
										<td><%=proj.getApplytime() %></td>
									</tr>
									<tr>
										<td>项目编号</td>
										<td><%=proj.getProj_permitid() %></td>
									</tr>
								</table>
								<a name="row"></a>
								<div class="widget-foot">
									<span
										style="padding:left:10px;textligin:center; font-size:16px;">项目进度：<%=proj.getProgress()%>%
									</span>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
											style="width: <%=proj.getProgress()%>%"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 项目 Status -->
				</div>



				<!-- 第3行 -->
				<div class="row">
					<%
						int pagesize=5;
								String pages=request.getParameter("page");
								int nowpage=pages==null?1:Integer.parseInt(pages);
								int start=(nowpage-1)*pagesize;
								int maxpage=(jnum+pagesize-1)/pagesize;
								int next=nowpage==maxpage?maxpage:nowpage+1;
								int prev=nowpage==1?1:nowpage-1;
					%>

					<div class="col-md-12">
						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">日志列表</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">

								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>编号</th>
											<th>标题</th>
											<th>发表日期</th>
											<th>编辑者</th>
											<th>分类</th>
											<th>状态</th>
										</tr>
									</thead>
									<tbody>
										<%
											Iterator<ProjectJournal> itjournal=proj.getJournal().selectProjpublic(start,pagesize);
																		int bianhao=0;
																		while(itjournal.hasNext()){
																			bianhao++;
																			ProjectJournal jt=itjournal.next();
										%>
										<tr>
											<td><%=bianhao%></td>
											<td><a href="journalpage.jsp?id=<%=jt.getId()%>"><%=jt.getTitle()%></a></td>
											<td><%=jt.getTime()%></td>
											<td><%=jt.getEditorname()%></td>
											<td><%=jt.getSortstring()%></td>
											<td><span class="label label-<%=jt.getButton()%>"><%=jt.getStatusstring()%></span></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>

								<div class="widget-foot">

									<ul class="pagination pull-right">
										<li><a href="index.jsp?page=<%=prev%>#row">上一页</a></li>
										<li><a href="index.jsp?page=1#row">首页</a></li>
										<li><a>第<%=nowpage%>页 共 <%=maxpage%>页
										</a></li>
										<li><a href="index.jsp?page=<%=maxpage%>#row">末页</a></li>
										<li><a href="index.jsp?page=<%=next%>#row">下一页</a></li>
									</ul>

									<div class="clearfix"></div>

								</div>

							</div>

						</div>
					</div>


				</div>

				<!-- 第3行 -->

				<%
					Application appi=proj.getApplication().selectId(proj.getId());
				%>
				<%
					if(appi.getIs_public()==1){
				%>
				<!-- 第二行 -->
				<div class="row">
					<div class="col-md-12">

						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">项目申请书</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd invoice">

									<div class="row">

										<div class="col-md-4">
											<h4>研究现状</h4>
											<p>
												<%=appi.getSituation()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>需要解决的问题和创新点</h4>
											<p>
												<%=appi.getInnovation()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>项目研究可行性分析</h4>
											<p>
												<%=appi.getFeasibility()%>
											</p>
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<h4>参考文献</h4>
											<p>
												<%=appi.getReference()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>研究内容</h4>
											<p>
												<%=appi.getResearch_context()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>研究方法</h4>
											<p>
												<%=appi.getResearch_method()%>
											</p>
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<h4>研究进度和安排</h4>
											<p>
												<%=appi.getSchedule()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>预期研究成果及其展现形式</h4>
											<p>
												<%=appi.getAchievement_modus()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>所需仪器设备</h4>
											<p>
												<%=appi.getEquipment()%>
											</p>
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<h4>项目来源</h4>
											<p>
												<%=appi.getCome_from()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>项目概要</h4>
											<p>
												<%=appi.getSummary()%>
											</p>
										</div>

										<div class="col-md-4">
											<h4>项目基础</h4>
											<p>
												<%=appi.getBase()%>
											</p>
										</div>

									</div>

								</div>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<!--第二行结束 -->
				<%
					}
				%>
				
				
				
				
				
				

				<%
					MiddleReport mdi=proj.getMiddlereport().selectProject_id(); 
				%>
				<%
					if(mdi.getIs_public()==1&&mdi.getIs_submit()==1){
				%>
				<!-- 第二行 -->
				<div class="row">
					<div class="col-md-12">

						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">项目中期报告</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd invoice">

									<div class="row">
										<div class="col-md-4">
											<h4>研究成果</h4>
											<p>
												<%=mdi.getAchievement()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>感想体会</h4>
											<p>
												<%=mdi.getThoughts()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>经费使用情况</h4>
											<p>
												<%=mdi.getExpenses()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>未按原计划完成部分及原因</h4>
											<p>
												<%=mdi.getUnfinished()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>工作计划</h4>
											<p>
												<%=mdi.getPlan()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>存在的问题</h4>
											<p>
												<%=mdi.getProblems()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>预期成果</h4>
											<p>
												<%=mdi.getExpectations()%>
											</p>
										</div>

									</div>

								</div>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<!--第二行结束 -->
				<%
					}
				%>



				<%
					FinalReport fri=proj.getFinalreport().selectProject(); 
				%>
				<%
					if(fri.getIs_public()==1&&fri.getIs_submit()==1){
				%>
				<!-- 第二行 -->
				<div class="row">
					<div class="col-md-12">

						<div class="widget">
							<div class="widget-head">
								<div class="pull-left">项目结题书</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content">
								<div class="padd invoice">

									<div class="row">
										<div class="col-md-4">
											<h4>项目完成情况</h4>
											<p>
												<%=fri.getCondition()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>研究成果</h4>
											<p>
												<%=fri.getAchievement()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>感想体会</h4>
											<p>
												<%=fri.getThoughts()%>
											</p>
										</div>
										<div class="col-md-4">
											<h4>经费使用情况</h4>
											<p>
												<%=fri.getExpenses()%>
											</p>
										</div>

									</div>

								</div>
								<div class="widget-foot">
									<div class="clearfix"></div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<!--第二行结束 -->
				<%
					}
				%>






			</div>


			<!--中间部分结束 -->

			<!-- Matter ends -->

		</div>

		<!-- Mainbar ends -->
		<div class="clearfix"></div>

	</div>
	<!-- Content ends -->

	<!-- Footer starts -->
	<%@include file="footer.jsp"%>

	<!-- Footer ends -->

	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>

	<!-- JS -->
	<script src="js/jquery.js"></script>
	<!-- jQuery -->
	<script src="js/bootstrap.js"></script>
	<!-- Bootstrap -->
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/fullcalendar.min.js"></script>
	<!-- Full Google Calendar - Calendar -->
	<script src="js/jquery.rateit.min.js"></script>
	<!-- RateIt - Star rating -->
	<script src="js/jquery.prettyPhoto.js"></script>
	<!-- prettyPhoto -->

	<!-- jQuery Flot -->
	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.resize.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>

	<!-- jQuery Notification - Noty -->
	<script src="js/jquery.noty.js"></script>
	<!-- jQuery Notify -->
	<script src="js/themes/default.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/bottom.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/topRight.js"></script>
	<!-- jQuery Notify -->
	<script src="js/layouts/top.js"></script>
	<!-- jQuery Notify -->
	<!-- jQuery Notification ends -->

	<script src="js/sparklines.js"></script>
	<!-- Sparklines -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- CLEditor -->
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<!-- Date picker -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- jQuery Uniform -->
	<script src="js/bootstrap-switch.min.js"></script>
	<!-- Bootstrap Toggle -->
	<script src="js/filter.js"></script>
	<!-- Filter for support page -->
	<script src="js/custom.js"></script>
	<!-- Custom codes -->
	<script src="js/charts.js"></script>
	<!-- Charts & Graphs -->

	<!-- Script for this page -->
	<script type="text/javascript">
		$(function() {

			/* Bar Chart starts */

			var d1 = [];
			for (var i = 0; i <= 20; i += 1)
				d1.push([ i, parseInt(Math.random() * 30) ]);

			var d2 = [];
			for (var i = 0; i <= 20; i += 1)
				d2.push([ i, parseInt(Math.random() * 30) ]);

			var stack = 0, bars = true, lines = false, steps = false;

			function plotWithOptions() {
				$.plot($("#bar-chart"), [ d1, d2 ], {
					series : {
						stack : stack,
						lines : {
							show : lines,
							fill : true,
							steps : steps
						},
						bars : {
							show : bars,
							barWidth : 0.8
						}
					},
					grid : {
						borderWidth : 0,
						hoverable : true,
						color : "#777"
					},
					colors : [ "#ff6c24", "#ff2424" ],
					bars : {
						show : true,
						lineWidth : 0,
						fill : true,
						fillColor : {
							colors : [ {
								opacity : 0.9
							}, {
								opacity : 0.8
							} ]
						}
					}
				});
			}

			plotWithOptions();

			$(".stackControls input").click(function(e) {
				e.preventDefault();
				stack = $(this).val() == "With stacking" ? true : null;
				plotWithOptions();
			});
			$(".graphControls input").click(function(e) {
				e.preventDefault();
				bars = $(this).val().indexOf("Bars") != -1;
				lines = $(this).val().indexOf("Lines") != -1;
				steps = $(this).val().indexOf("steps") != -1;
				plotWithOptions();
			});

			/* Bar chart ends */

		});

		/* Curve chart starts */

		$(function() {
			var sin = [], cos = [];
			for (var i = 0; i < 14; i += 0.5) {
				sin.push([ i, Math.sin(i) ]);
				cos.push([ i, Math.cos(i) ]);
			}

			var plot = $.plot($("#curve-chart"), [ {
				data : sin,
				label : "sin(x)"
			}, {
				data : cos,
				label : "cos(x)"
			} ], {
				series : {
					lines : {
						show : true,
						fill : true
					},
					points : {
						show : true
					}
				},
				grid : {
					hoverable : true,
					clickable : true,
					borderWidth : 0
				},
				yaxis : {
					min : -1.2,
					max : 1.2
				},
				colors : [ "#1eafed", "#1eafed" ]
			});

			function showTooltip(x, y, contents) {
				$('<div id="tooltip">' + contents + '</div>').css({
					position : 'absolute',
					display : 'none',
					top : y + 5,
					left : x + 5,
					border : '1px solid #000',
					padding : '2px 8px',
					color : '#ccc',
					'background-color' : '#000',
					opacity : 0.9
				}).appendTo("body").fadeIn(200);
			}

			var previousPoint = null;
			$("#curve-chart")
					.bind(
							"plothover",
							function(event, pos, item) {
								$("#x").text(pos.x.toFixed(2));
								$("#y").text(pos.y.toFixed(2));

								if ($("#enableTooltip:checked").length > 0) {
									if (item) {
										if (previousPoint != item.dataIndex) {
											previousPoint = item.dataIndex;

											$("#tooltip").remove();
											var x = item.datapoint[0]
													.toFixed(2), y = item.datapoint[1]
													.toFixed(2);

											showTooltip(item.pageX, item.pageY,
													item.series.label + " of "
															+ x + " = " + y);
										}
									} else {
										$("#tooltip").remove();
										previousPoint = null;
									}
								}
							});

			$("#curve-chart")
					.bind(
							"plotclick",
							function(event, pos, item) {
								if (item) {
									$("#clickdata").text(
											"You clicked point "
													+ item.dataIndex + " in "
													+ item.series.label + ".");
									plot.highlight(item.series, item.datapoint);
								}
							});

		});

		/* Curve chart ends */
	</script>

</body>
</html>