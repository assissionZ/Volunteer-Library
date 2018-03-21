<%@ page language="java" import="java.util.*, bean.Book, bean.Account" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 这坑爹货 --%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>

        <!-- meta data & title -->
        <meta charset="utf-8">
        <title>Office</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

	    <!-- CSS -->
	    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">
	    <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
	    <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
	    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
	    <link rel="stylesheet" href="assets/css/animate.min.css">
	    <link rel="stylesheet" href="assets/css/style.css">
	    <link rel="stylesheet" href="assets/css/list.css">
	    <link href="login-register.css" rel="stylesheet" />
	    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
		
		<!-- JS -->
		<script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
		<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
		<script src="login-register.js" type="text/javascript"></script>
		<script src="js/register_check.js" type="text/javascript"></script>
		<script src="js/login_again.js" type="text/javascript"></script>
		<script src="js/outputCookie.js" type="text/javascript"></script>
		<script src="js/booklist_control.js" type="text/javascript"></script>
        
        
    </head>
<% 
 String user_na = "";
 if(session.getAttribute("account")==null)
 {
	 out.println("<script language=javascript>window.alert('请先进行登录');location.href='index.jsp'</script>");
 }   
 else 
 {
	 user_na = ((Account)session.getAttribute("account")).getUser_name();
 }
%>
    <!-- Header -->
    <body>
    <nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
        <div class="container">
        
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand wow fadeInDownBig" href="index.jsp"><img class="office-logo" src="assets/img/slider/Office.png" alt="Office"></a>      
            </div>
        
            <div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active">
                        <a href="index_login.jsp">主页</a>
                    </li>
                    <li>
                        <a href="about.html">关于</a>
                    </li>
                    <li>
                        <a href="ordinary_message.jsp"><%=user_na %> 的信息</a>
                    </li>
                    <li>
                        <a href="LogoutServlet">注销</a>
                    </li>
                </ul>         
            </div>
        </div>
    </nav>
		
		 <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Login with</h4>
                    </div>
                    <div class="modal-body">  
                        <div class="box">
                             <div class="content">
                                <div class="social">
                                    <a class="circle github" href="/auth/wechat">
                                        <i class="fa fa-wechat fa-fw"></i>
                                    </a>
                                    <a id="qq_login" class="circle facebook" href="/auth/qq">
                                        <i class="fa fa-qq fa-fw"></i>
                                    </a>
                                    <a id="weibo_login" class="circle google" href="/auth/weibo">
                                        <i class="fa fa-weibo fa-fw"></i>
                                    </a>
                                </div>
                                <div class="division">
                                    <div class="line l"></div>
                                      <span>or</span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="LoginServlet" accept-charset="UTF-8">
                                    <input id="user_id_login" class="form-control" type="text" placeholder="学号" name="user_id_login" value="">
                                    <input id="password_login" class="form-control" type="password" placeholder="密码" name="password_login" value="">
                                    <input class="btn btn-default btn-login" type="submit" value="登录">
                                    <script type="text/javascript">outputLoginCookie();</script>
                                    </form>
                                </div>
                             </div>
                        </div>
                        
                        <div class="box" id="register_box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form">
                                <form name="registerForm" method="post" html="{:multipart=>true}" data-remote="true" action="RegisterServlet" accept-charset="UTF-8">
                                <input id="user_id" class="form-control" type="text" placeholder="账号" name="user_id" onblur="check_id()">
                                <span id="check_id_result" name="check_id_result"></span>
                                <input id="user_name" class="form-control" type="text" placeholder="姓名/昵称" name="user_name">
                                <input id="password" class="form-control" type="password" placeholder="密码" name="password">
                                <input id="password_again" class="form-control" type="password" placeholder="请再次输入密码" name="password_again" onblur="check_password()"">
								<span id="check_password_result" name="check_password_result"></span>
								<input id="phone" class="form-control" type="text" placeholder="手机号" name="phone" onblur="check_phone()">
                                <span id="check_phone_result" name="check_phone_result"></span>
                                <input id="address" class="form-control" type="text" placeholder="宿舍楼+宿舍号" name="address" onblur="check_address()">
                                <span id="check_address_result" name="check_address_result"></span>
                                <input class="btn btn-default btn-register" type="submit" value="注册" name="commit">
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>如果您没有账号请 
                                 <a href="javascript: showRegisterForm();">注册账号</a>
                            </span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>已经有账号了?</span>
                             <a href="javascript: showLoginForm();">登录</a>
                        </div>
                    </div>        
    		      </div>
		      </div>
		  </div>

    <!-- End Header -->

	<% 
    int count = 0; //总行数
    int page_count = 0;  //开始条数
    int page_total = 1;  //，总页码
    int page_current = 1;  //首页
    int page_size = 10;//一页的行数
    %>
    
   <%  
    String page_cu = request.getParameter("page_current");  
    if(page_cu == null){  
       page_cu = "1";  
    }  
    page_current = Integer.parseInt(page_cu);
    if(page_current <= 0){
       page_current = 1;  
    } 
    page_count = page_count + (page_current-1) * page_size;
  %>
  
  <%
  	List<Book> list = (List<Book>)request.getAttribute("list");
  	if(list!=null){
  		session.setAttribute("list", list);
  	}
  	else{
  		list = (List<Book>)session.getAttribute("list");
  	}
  	int pn[] = new int[10];
  	for(int i=0; i<10; i++){
  		pn[i] = 0;
  	}
   %>
 
	<br>
	<br>
    <br>
    <form action="PreBorrowServlet" method="post">
	<table align="center" width="80%" border="0" cellspacing="0" cellpadding="0">
     <h3 class="biaoti" colspan="3" align="center" height="60" >图书清单</h3>
     <br>
	    	<tr>
         		<th style="text-align:right;" class="btbg font-center titfont">全选<input type="checkbox" onclick="chooseAll(this)"/></th>
	    		<th style="text-align:center;" class="btbg font-center titfont">书号</th>
	    		<th style="text-align:center;" class="btbg font-center titfont">书名</th>
	    		<th style="text-align:center;" class="btbg font-center titfont">作者</th>
	    		<th style="text-align:center;" class="btbg font-center titfont">可借数目</th>
	    		<th style="text-align:center;" class="btbg font-center titfont">总数目</th>
	    		<th style="text-align:center;" class="btbg font-center titfont">预借数目</th>
	    	</tr>
	    	<c:forEach items="${list }" var="book" step="1" varStatus="i" 
	    	begin="<%=page_count%>"  end="<%=page_size+page_count-1%>">
           	<tr>
             <td align="right" style="width:10%" class="btbg">
             	<input type="checkbox" name="select_book_id" id="select_book_id" value="${i.index }"/>
             </td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.book_id }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.book_name }"></c:out></td>
             <td align="center" id="select_book_author${i.index }" style="width:10%" class="btbg font-center"><c:out value="${book.book_author }"></c:out></td>
             <td id="brnid${i.index }" align="center" style="width:10%" class="btbg font-center"><c:out value="${book.book_residual_number }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.book_total_number }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center">
             	<button type="button" class="btbg" style="width:30px;height:30px;" value="${i.index }" onclick="pn_reduce(this);">-</button>
             	<input id="pnid${i.index }" name="preborrow_number" style="width:35px" type="text" value="0" >
             	<button type="button" class="btbg" style="width:30px;height:30px;" value="${i.index }" onclick="pn_increase(this);">+</button>
             </td>
             <% count++; %> 
           	</tr>
       		</c:forEach>
    	</table>
    	<br>
    	<table width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
      	  <tr>
            <td align="center" class=""><input class="btn" type="submit" value="加入预借清单"></td>
            <%  
            	page_total = ((list.size())%page_size==0)?((list.size())/page_size):((list.size())/page_size+1);  
			%>
		  	<td align="center" class="">本页总共<%=count%>条 / 总共<%=list.size()%>条</td>
			<td align="center" class="">
			<a href = "showBookList_login.jsp?page_current=1" >首页</a>  
			<a href = "showBookList_login.jsp?page_current=<%=page_current-1%>" >上一页</a>  
			<a href = "showBookList_login.jsp?page_current=<%=page_current+1>page_total?page_current:page_current+1%>" >下一页</a>  
			<a href = "showBookList_login.jsp?page_current=<%=page_total%>" >尾页</a>  
			</td>
			<td align="center">第 <%=page_current%> 页 / 共  <%=page_total%> 页 </td>
            <td align="center" class="btn"><a href="showPreBorrowList.jsp">查看预借清单</a></td>
          </tr>
		</table>
	</form>

    <!-- Footer -->
    <footer> 
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h3><i class="fa fa-map-marker"></i> 联系我们:</h3>
                    <p class="footer-contact">
                        深圳大学石头坞二楼义工联合会办公室<br>
                        电话: 13811467407<br>
                        邮箱: jryg@163.com<br>
                    </p>
                </div>
                <div class="col-md-4">
                    <h3><i class="fa fa-external-link"></i> 链接</h3>
                    <p> <a href="#"> 关于我们 </a></p>
                    <p> <a href="#"> 留言箱</a></p>
                    <p> <a href="#"> 了解更多</a></p>
                </div>
              <div class="col-md-4">
                <h3><i class="fa fa-heart"></i> 社交</h3>
                <div id="social-icons">
                    <a href="#" class="btn-group google-plus">
                        <i class="fa fa-weixin"></i>
                    </a>
                      <a href="#" class="btn-group linkedin">
                        <i class="fa fa-qq"></i>
                    </a>
                      <a href="#" class="btn-group twitter">
                        <i class="fa fa-weibo"></i>
                    </a>
                      <a href="#" class="btn-group facebook">
                        <i class="fa fa-facebook"></i>
                    </a>
                </div>
              </div>    
        </div>
      </div>
    </footer>

    
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
  </body>
</html>
