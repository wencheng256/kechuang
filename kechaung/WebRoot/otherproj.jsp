﻿<%@page language="java" import="mo.*,java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

				<!--第一行 -->
				<div class="row">
					<%
					int pagesize=20;
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
								<div class="pull-left">本期其他项目</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="widget-content medias">

								<table class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>项目编号</th>
											<th>项目名称</th>
											<th>项目类型</th>
											<th>创建时间</th>
											<th>项目状态</th>
											<th>项目进度</th>
											<th>所属学院</th>
											<th>是否为重点立项</th>
										</tr>
									</thead>
									<tbody>
										<%
											Iterator<Project> itproj=proj.selectGrade(start, pagesize,0);
																		while(itproj.hasNext()){
																			Project projt=itproj.next();
										%>

										<tr>
											<td><%=projt.getProj_permitid()%></td>
											<td><a href="otherindex.jsp?id=<%=projt.getId()%>"><%=projt.getName()%></a></td>
											<td><%=projt.getClassstring()%></td>
											<td><%=projt.getApplytime()%></td>
											<td><%=projt.getStatusstring()%></td>
											<td><%=projt.getProgress()%></td>
											<td><%=projt.getSchoolstring()%></td>
											<td><%if(projt.getImportant()==1){%>是<%} else{%>否<%} %></td>
											<%
												}
											%>
										</tr>
									</tbody>
								</table>

								<div class="widget-foot">
									<ul class="pagination pull-right">
										<li><a href="otherproj.jsp?page=<%=prev%>">上一页</a></li>
										<li><a href="otherproj.jsp?page=1">首页</a></li>
										<li><a>第<%=nowpage %>页 共 <%=maxpage %>页
										</a></li>
										<li><a href="otherproj.jsp?page=<%=maxpage%>">末页</a></li>
										<li><a href="otherproj.jsp?page=<%=next%>">下一页</a></li>
									</ul>
									<div style="clear:both;"></div>
								</div>

							</div>
						</div>

					</div>
				</div>
				<!--第一行 -->



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
	<script type="text/javascript">
		function change(id)
		{
			$.ajax({
				url:"studentchange.action?id="+id,
				});
		};
	</script>
</body>
</html>