<%@ page language="java" import="java.util.*,bean.Book, bean.Account, bean.BorrowBook" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 这坑爹货 --%>
<%@ page isELIgnored="false" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
 String user_pa = "";
 String user_id = "";
 String user_ph = "";
 String user_ad = "";
 String user_ty = "";
 if(session.getAttribute("account")==null)
 {
	 out.println("<script language=javascript>window.alert('请先进行登录');location.href='index.jsp'</script>");
 }   
 else 
 {
 	 Account account = (Account)session.getAttribute("account");
	 user_na = account.getUser_name();
	 user_id = account.getUser_id();
	 user_pa = account.getPassword();
	 user_ph = account.getPhone();
	 user_ad = account.getAddress();
	 user_ty = account.getType();
 }
%>



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
                    <li>
                        <a href="index_login.jsp">主页</a>
                    </li>
                    <li>
                        <a href="about.html">关于</a>
                    </li>
                    <li class="active">
                        <a href="ordinary_message.jsp"><%=user_na%> 的个人信息</a>
                    </li>
                    <li>
                        <a href="LogoutServlet">注销</a>
                    </li>
                </ul>         
            </div>
        </div>
    </nav>
  

    
	<div class="container">
      <div class="row" >


		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
        <div id="navbar-spy" class="col-sm-2">
            <ul class="nav nav-pills nav-stacked">
            <li><a href="ordinary_message.jsp">个人信息</a></li>
            <li><a href="showPreBorrowList.jsp">我的预借清单</a></li>
            <li><a href="borrow_message.jsp">借书情况</a></li>
            <li class="active"><a href="donate_message.jsp">捐书情况</a></li>
            <% 
            	if(user_ty!=null && user_ty.equals("ordinary")){
            		out.print("<li><a href=\"message_board.jsp\">留言板</a></li>");
            	}
            	if(user_ty!=null && user_ty.equals("volunteer")){
            		out.print("<li><a href=\"message_board.jsp\">留言板</a></li>");
            		out.print("<li><a href=\"volwork.jsp\">我的工作</a></li>");
            	}
            	if(user_ty!=null && user_ty.equals("manager")){
            		out.print("<li><a href=\"MessageCheck\">留言板查看</a></li>");
            		out.print("<li><a href=\"UserServlet\">人员管理</a></li>");
            		out.print("<li><a href=\"BorrowExamine\">借书审核</a></li>");
            		out.print("<li><a href=\"DonateExamine\">捐书审核</a></li>");
            	}
             %>
            </ul>
        </div>
        
		<%
        			List<BorrowBook> borrowlist = (List<BorrowBook>)request.getAttribute("borrowlist");
        		%>
        
       <table align="center" width="80%" border="0" cellspacing="0" cellpadding="0">
			 
			    <h3 class="biaoti" colspan="3" align="center" height="60" >您的捐书情况</h3>
     <br>
			 
			 <tr>
				<th align="center" class="btbg font-center titfont">书名</th>
				<th align="center" class="btbg font-center titfont">作者</th>
				<th align="center" class="btbg font-center titfont">捐赠数量</th>
				<th align="center" class="btbg font-center titfont">捐赠状态</th>
				<th align="center" class="btbg font-center titfont">申请时间</th>
            </tr>
            <c:forEach items="${donatelist }" var="book" step="1" varStatus="i" >
           	<tr>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.donate_book_name }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.donate_book_author }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.donate_book_num }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.status }"></c:out></td>
             <td align="center" style="width:10%" class="btbg font-center"><c:out value="${book.donate_time }"></c:out></td>
           	</tr>
       		</c:forEach>
    		</table>
    </div>
</div>
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
