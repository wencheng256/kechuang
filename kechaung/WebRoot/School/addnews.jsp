<%@page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	School school=new School();
	Iterator<School> itschool=school.selectAll();
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
<link href="../style/bootstrap.css" rel="stylesheet">
<!-- Font awesome icon -->
<link rel="stylesheet" href="../style/font-awesome.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="../style/jquery-ui.css">
<!-- Calendar -->
<link rel="stylesheet" href="../style/fullcalendar.css">
<!-- prettyPhoto -->
<link rel="stylesheet" href="../style/prettyPhoto.css">
<!-- Star rating -->
<link rel="stylesheet" href="../style/rateit.css">
<!-- Date picker -->
<link rel="stylesheet" href="../style/bootstrap-datetimepicker.min.css">
<!-- CLEditor -->
<link rel="stylesheet" href="../style/jquery.cleditor.css">
<!-- Uniform -->
<link rel="stylesheet" href="../style/uniform.default.css">
<!-- Bootstrap toggle -->
<link rel="stylesheet" href="../style/bootstrap-switch.css">
<!-- Main stylesheet -->
<link href="../style/style.css" rel="stylesheet">
<!-- Widgets stylesheet -->
<link href="../style/widgets.css" rel="stylesheet">
<link href="../ueditor/themes/default/css/umeditor.css" type="text/css"
	rel="stylesheet">

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="../js/html5shim.js"></script>
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


				<!--1 -->
				<div class="row">

					<div class="col-md-12">


						<div class="widget wgreen">

							<div class="widget-head">
								<div class="pull-left">科研新闻</div>
								<div class="widget-icons pull-right">
									<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
									<a href="#" class="wclose"><i class="icon-remove"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>

							<div class="widget-content">
								<div class="padd">

									<h6>填写新闻</h6>
									<hr />
									<!-- Form starts.  -->
									<div class="alert alert-warning">
										<s:fielderror />
									</div>
									<div class="alert alert-success">
										<ul>
											<li>图片大小上限为1M过大的图片请自行进行压缩 推荐使用格式工厂进行转换</li>
											<li>图片宽度不要超过1000px 超过会导致排版错误</li>
										</ul>
									</div>
									<form class="form-horizontal" role="form" action="addnews"
										method="post">

										<div class="form-group">
											<label class="col-lg-4 control-label">标题</label>
											<div class="col-lg-8">
												<input type="text" class="form-control" placeholder="请输入标题"
													name="title">
											</div>
										</div>

										<div class="form-group">
											<label class="col-lg-4 control-label">内容</label>
											<div class="col-lg-8">
												<textarea id="editor" style="width:100%;height:350px;"
													name="content"></textarea>
											</div>
										</div>

										<hr />
										<div class="form-group">
											<div class="col-lg-offset-1 col-lg-9">
												<button type="submit" class="btn btn-info">提交</button>
												<button type="reset" class="btn btn-success">重置</button>
											</div>
											<input type="hidden" name="user" value="<%=usi.getId()%>">
											<input type="hidden" name="type" value="<%if(usi.getSchool()==0){out.println("0");}else{out.println("1");}%>">
										</div>
									</form>
								</div>
							</div>
							<div class="widget-foot">
								<!-- Footer goes here -->
							</div>
						</div>

					</div>

				</div>
				<!--1 -->



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
	<script src="../js/jquery.js"></script>
	<!-- jQuery -->
	<script src="../js/bootstrap.js"></script>
	<!-- Bootstrap -->
	<script src="../js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- jQuery UI -->
	<script src="../js/fullcalendar.min.js"></script>
	<!-- Full Google Calendar - Calendar -->
	<script src="../js/jquery.rateit.min.js"></script>
	<!-- RateIt - Star rating -->
	<script src="../js/jquery.prettyPhoto.js"></script>
	<!-- prettyPhoto -->

	<!-- jQuery Flot -->
	<script src="../js/excanvas.min.js"></script>
	<script src="../js/jquery.flot.js"></script>
	<script src="../js/jquery.flot.resize.js"></script>
	<script src="../js/jquery.flot.pie.js"></script>
	<script src="../js/jquery.flot.stack.js"></script>

	<!-- jQuery Notification - Noty -->
	<script src="../js/jquery.noty.js"></script>
	<!-- jQuery Notify -->
	<script src="../js/themes/default.js"></script>
	<!-- jQuery Notify -->
	<script src="../js/layouts/bottom.js"></script>
	<!-- jQuery Notify -->
	<script src="../js/layouts/topRight.js"></script>
	<!-- jQuery Notify -->
	<script src="../js/layouts/top.js"></script>
	<!-- jQuery Notify -->
	<!-- jQuery Notification ends -->

	<script src="../js/sparklines.js"></script>
	<!-- Sparklines -->
	<script src="../js/jquery.cleditor.min.js"></script>
	<!-- CLEditor -->
	<script src="../js/bootstrap-datetimepicker.min.js"></script>
	<!-- Date picker -->
	<script src="../js/jquery.uniform.min.js"></script>
	<!-- jQuery Uniform -->
	<script src="../js/bootstrap-switch.min.js"></script>
	<!-- Bootstrap Toggle -->
	<script src="../js/filter.js"></script>
	<!-- Filter for support page -->
	<script src="../js/custom.js"></script>
	<!-- Custom codes -->
	<script src="../ueditor/umeditor.config.js"></script>
	<script src="../ueditor/umeditor.min.js"></script>

	<script src="../js/charts.js"></script>
	<!-- Charts & Graphs -->
	<script type="text/javascript">
    var ue = UM.getEditor('editor');
	</script>
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