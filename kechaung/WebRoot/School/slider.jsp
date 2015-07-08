<%@ page language="java" import="mo.*,java.util.*"  pageEncoding="UTF-8"%>
<%
User uss = (User) session.getAttribute("user1");

RoleAction rai=new RoleAction(uss.getRole());
ArrayList<RoleAction> arl=rai.selectRole();
Iterator<RoleAction> itra=arl.iterator();
%>


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
            <%
            	while(itra.hasNext()){
            		RoleAction rat=itra.next();
            		rat.decoration();
            		Action at1=rat.getAction();
					if(at1.getIs_d()==1){            
            %>
				<li class="has_sub"><a href="#"><i class="icon-list-alt"></i>
						<%=at1.getName() %><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
					<ul>
					<%Iterator<RoleAction> itra1=arl.iterator();
						while(itra1.hasNext()){
							RoleAction rai2=itra1.next();
							rai2.decoration();
							Action at2=rai2.getAction();
					%>
					<%if(at2.getParent()==at1.getId()){%>
						<li><a href="<%=at2.getLink()%>"><%=at2.getName() %></a></li>
					<%} }%>
					</ul></li>
			<%}} %>
			</ul>
		</div>
		
