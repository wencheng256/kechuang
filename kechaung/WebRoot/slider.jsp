<%@ page language="java"  pageEncoding="UTF-8"%>


		<div class="sidebar">
			<div class="sidebar-dropdown">
				<a href="#">导航</a>
			</div>

			<!--- Sidebar navigation -->
			<!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
			<ul id="nav">
				<!-- Main menu with font awesome icon -->
				<li><a href="index.jsp"><i class="icon-home"></i>
						首页</a> <!-- Sub menu markup 
            <ul>
              <li><a href="#">Submenu #1</a></li>
              <li><a href="#">Submenu #2</a></li>
              <li><a href="#">Submenu #3</a></li>
            </ul>--></li>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						本项目管理<span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="students.jsp">成员导师管理</a></li>
						<li><a href="journal.jsp">日志管理</a></li>
						<li><a href="fare.jsp">经费管理</a></li>
						<li><a href="project.jsp">项目进度管理</a></li>
					</ul></li>
				<li ><a href="otherproj.jsp"><i class="icon-file-alt"></i>
						本期其他项目 <span class="pull-right"></span></a></li>
				<li class="has_sub"><a href="#"><i class="icon-file-alt"></i>
						新闻通知 <span class="pull-right"><i
							class="icon-chevron-right"></i></span></a>
					<ul>
						<li><a href="news.jsp">学校新闻</a></li>
						<li><a href="schoolnews.jsp">学院新闻</a></li>
					</ul></li>
			</ul>
		</div>
		
