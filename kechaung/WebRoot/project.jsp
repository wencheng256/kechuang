<%@page language="java" contentType="text/html; charset=utf-8"%>
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

				<!--0 -->
				<div class="row">
					<div class="tabbable" style="margin-bottom: 18px;">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1" data-toggle="tab">项目信息管理</a></li>
							<li><a href="#tab2" data-toggle="tab">项目申请书</a></li>
							<li><a href="#tab3" data-toggle="tab">中期报告</a></li>
							<li><a href="#tab4" data-toggle="tab">结题报告</a></li>
							<li><a href="#tab5" data-toggle="tab">警告处分</a></li>
						</ul>
						<div class="tab-content"
							style="padding-bottom: 9px; border-bottom: 1px solid #ddd;">
							<div class="tab-pane active" id="tab1">
								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目信息管理</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>

										<div class="widget-content">
											<div class="padd">

												<h6>项目信息</h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" role="form"
													action="proj.action">
													<div class="alert alert-warning">
														<s:fielderror />
														<ul>
															<li>点击修改不会发生跳转，请放心，他已经被保存了。</li>
														</ul>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">项目进度（%）</label>
														<div class="col-lg-8">
															<input type="text" class="form-control"
																placeholder="请输入百分比进度（两位或者三位整数）" id="test1"
																value="<%=proj.getProgress()%>" name="progress"'>
														</div>
													</div>

													<div class="form-group">
														<label class="col-lg-4 control-label">状态</label>
														<div class="col-lg-8">
															<select class="form-control" name="status">
																<option value="1" <%if(proj.getStatus()==1){%> selected
																	<%}%>>终止</option>
																<option value="2" <%if(proj.getStatus()==2){%> selected
																	<%}%>>停滞</option>
																<option value="3" <%if(proj.getStatus()==3){%> selected
																	<%}%>>迟缓</option>
																<option value="4" <%if(proj.getStatus()==4){%> selected
																	<%}%>>顺利</option>
																<option value="5" <%if(proj.getStatus()==5){%> selected
																	<%}%>>超前</option>
															</select> <input type="hidden" value="<%=proj.getId()%>" name="id">
														</div>
													</div>
													<button type="submit" class="btn btn-warning">修改</button>
												</form>
											</div>
										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>

								</div>


								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目完成确认</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>

										<div class="widget-content">
											<div class="padd">

												<h6>项目完成</h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" role="form"
													action="endproj.action">
													<div class="alert alert-danger">
														<ul>
															<li>请在确认项目已经结束后再此确认完成任务。</li>
															<li>一旦确认了项目已经结束，再也无法对项目进行任何操作。</li>
															<li>如果误操作，请向找院相关老师寻求帮助。</li>
															<li>请在看完以上所有介绍之后，在下面的输入框中输入 submit
																然后点击确认完成，为您本次科研立项画上一个句点。</li>
														</ul>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">请输入</label>
														<div class="col-lg-8">
															<input type="text" class="form-control"
																placeholder="请先阅读上面的介绍" id="test1" name="config">
															<input type="hidden" name="proj.id"
																value="<%=proj.getId()%>">
														</div>
													</div>
													<button type="submit" class="btn btn-danger">确认完成</button>
												</form>
											</div>
										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>

								</div>

							</div>
							<div class="tab-pane" id="tab2">
								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目申请书</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>

										<div class="widget-content">
											<div class="padd">
												<%
													Application appt=proj.getApplication().selectId(proj.getId());
												%>
												<h6><%=proj.getName()%></h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" role="form"
													action="application.action" method="post">

													<div class="form-group">
														<label class="col-lg-4 control-label">是否公开</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_public" value="1"
																	<%if(appt.getIs_public()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究现状</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究现状" name="situation"><%=appt.getSituation()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">需要解决的问题和创新点</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="需要解决的问题和创新点" name="innovation"><%=appt.getInnovation()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">项目研究可行性分析</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目研究可行性分析" name="feasibility"><%=appt.getFeasibility()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">参考文献</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="参考文献" name="reference"><%=appt.getReference()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究内容</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究内容" name="research_context"><%=appt.getResearch_context()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究方法</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究方法" name="research_method"><%=appt.getResearch_method()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究进度及安排</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究进度及安排" name="schedule"><%=appt.getSchedule()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">预期研究成果及其展现形式</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="预期研究成果及其展现形式" name="achievement_modus"><%=appt.getAchievement_modus()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">所需仪器设备</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="所需仪器设备" name="equipment"><%=appt.getEquipment()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">项目来源</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目来源" name="come_from"><%=appt.getCome_from()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">项目感想</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目感想" name="thoughts"><%=appt.getCome_from()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">项目概要</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目概要" name="summary"><%=appt.getSummary()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究基础</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究基础" name="base"><%=appt.getBase()%></textarea>
														</div>
													</div>

													<input type="hidden" value="<%=proj.getId()%>" name="id">

													<hr />
													<div class="form-group">
														<div class="col-lg-offset-1 col-lg-9">
															<button type="submit" class="btn btn-success">提交</button>
														</div>
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
							<div class="tab-pane" id="tab3">
								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目中期报告</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>
										<%
											MiddleReport midit=proj.getMiddlereport().selectProject_id();
										%>
										<div class="widget-content">
											<div class="padd">

												<h6><%=proj.getName()%></h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" method="post"
													action="middlereport.action">
													<div class="alert alert-warning">
														<ul>
															<li>是否公开控制其他项目是否可以查看。</li>
															<li>是否提交代表是不是准备好让学校和学院老师进行审核</li>
														</ul>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">是否提交</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_submit" value="1"
																	<%if(midit.getIs_submit()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-lg-4 control-label">是否公开</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_public" value="1"
																	<%if(midit.getIs_public()==1){%> checked <%}%>>
															</div>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究成果</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究成果" name="achievement"><%=midit.getAchievement()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">感想体会</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="感想体会" name="thoughts"><%=midit.getThoughts()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">经费使用情况</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="经费使用情况" name="expenses"><%=midit.getExpenses()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">未按原计划完成部分及原因</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="未按原计划完成部分及原因" name="unfinished"><%=midit.getUnfinished()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">工作计划</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="工作计划" name="plan"><%=midit.getPlan()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">存在的问题</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="存在的问题" name="problems"><%=midit.getProblems()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">预期成果</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="预期成果" name="expectations"><%=midit.getExpectations()%></textarea>
														</div>
													</div>



													<hr />
													<div class="form-group">
														<div class="col-lg-offset-1 col-lg-9">
															<button type="submit" class="btn btn-primary">提交</button>
														</div>
													</div>
													<input name="project_id" type="hidden"
														value="<%=proj.getId()%>">
												</form>
											</div>
										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>

								</div>
							</div>
							
							<div class="tab-pane" id="tab4">
								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目结题报告</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>
										<%
											FinalReport frt=proj.getFinalreport().selectProject();
										%>
										<div class="widget-content">
											<div class="padd">

												<h6><%=proj.getName()%></h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" method="post"
													action="finalreport.action">
													<div class="alert alert-warning">
														<ul>
															<li>是否公开控制其他项目是否可以查看。</li>
															<li>是否提交代表是不是准备好让学校和学院老师进行审核</li>
														</ul>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">是否提交</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_submit" value="1"
																	<%if(frt.getIs_submit()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-lg-4 control-label">是否公开</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_public" value="1"
																	<%if(frt.getIs_public()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>

													<div class="form-group">
														<label class="col-lg-4 control-label">项目完成情况</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目完成情况" name="condition"><%=frt.getCondition()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究成果</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究成果" name="achievement"><%=frt.getAchievement()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">感想体会</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="感想体会" name="thoughts"><%=frt.getThoughts()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">经费使用情况</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="经费使用情况" name="expenses"><%=frt.getExpenses()%></textarea>
														</div>
													</div>



													<hr />
													<div class="form-group">
														<div class="col-lg-offset-1 col-lg-9">
															<button type="submit" class="btn btn-primary">提交</button>
														</div>
													</div>
													<input name="project" type="hidden"
														value="<%=proj.getId()%>">
												</form>
											</div>
										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>

								</div>
							</div>
							<div class="tab-pane" id="tab5">
								<div class="col-md-12">


									<div class="widget wgreen">

										<div class="widget-head">
											<div class="pull-left">项目警告</div>
											<div class="widget-icons pull-right">
												<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
												<a href="#" class="wclose"><i class="icon-remove"></i></a>
											</div>
											<div class="clearfix"></div>
										</div>
										<%
											//FinalReport frt=proj.getFinalreport().selectProject();
										%>
										<div class="widget-content">
											<div class="padd">

												<h6><%=proj.getName()%></h6>
												<hr />
												<!-- Form starts.  -->
												<form class="form-horizontal" method="post"
													action="finalreport.action">
													<div class="alert alert-warning">
														<ul>
															<li>是否公开控制其他项目是否可以查看。</li>
															<li>是否提交代表是不是准备好让学校和学院老师进行审核</li>
														</ul>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">是否提交</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_submit" value="1"
																	<%if(frt.getIs_submit()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-lg-4 control-label">是否公开</label>
														<div class="col-lg-8">
															<div class="make-switch" data-on="warning"
																data-off="danger">
																<input type="checkbox" name="is_public" value="1"
																	<%if(frt.getIs_public()==1) {%> checked <%}%>>
															</div>
														</div>
													</div>

													<div class="form-group">
														<label class="col-lg-4 control-label">项目完成情况</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="项目完成情况" name="condition"><%=frt.getCondition()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">研究成果</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="研究成果" name="achievement"><%=frt.getAchievement()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">感想体会</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="感想体会" name="thoughts"><%=frt.getThoughts()%></textarea>
														</div>
													</div>
													<div class="form-group">
														<label class="col-lg-4 control-label">经费使用情况</label>
														<div class="col-lg-8">
															<textarea class="form-control" rows="3"
																placeholder="经费使用情况" name="expenses"><%=frt.getExpenses()%></textarea>
														</div>
													</div>



													<hr />
													<div class="form-group">
														<div class="col-lg-offset-1 col-lg-9">
															<button type="submit" class="btn btn-primary">提交</button>
														</div>
													</div>
													<input name="project" type="hidden"
														value="<%=proj.getId()%>">
												</form>
											</div>
										</div>
										<div class="widget-foot">
											<!-- Footer goes here -->
										</div>
									</div>

								</div>
							</div>
							
							
							
							
							
							
							
						</div>
					</div>

				</div>

			</div>
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
		
	<%if(proj.getEnd()==1){%>
		$(function() {
			$("input").attr("disabled", "disabled");
			$("button").attr("disabled", "disabled");
		});
	<%}%>
		
	</script>

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