<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="pseudocode.StudentDao" %>
<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.3.0, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.3.0, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Profile</title>
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
  
</head>
<body>
  <%
	String first = (String)request.getSession().getAttribute("first");
    String last = (String)request.getSession().getAttribute("last");
    String username = (String)request.getSession().getAttribute("username");
    
    String pic = StudentDao.displayPicture(username);
	%>
	
	
  <section class="menu menu1 cid-stMFcqsk7w" once="menu" id="menu1-2">
    

    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
            <div class="navbar-brand">
                
                <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7" href="Notes.jsp">StudentMate</a></span>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item"><a class="nav-link link text-black display-4" href="Notes.jsp">Notes</a></li>
                    <li class="nav-item"><a class="nav-link link text-black display-4" href="Drive.jsp">Drive</a></li>
                    <li class="nav-item">
                        <a class="nav-link link text-black display-4" href="Profile.jsp"> <span class="fa fa-user-circle ">
                        </span> <% out.println(first+" "+last);%></a>
                    </li>
                    </li><li class="nav-item"><a class="nav-link link text-black display-4" href="Logout.jsp">Logout</a></li></ul>
                
                
            </div>
        </div>
    </nav>
</section>

<section class="team2 cid-stMFBXK6zb" xmlns="http://www.w3.org/1999/html" id="team2-3">
    
    <%
		String pro_pic=(String)request.getAttribute("profileupdated");  
		if(pro_pic!=null)
		out.println("<p align= center><font color=red size=4px>"+pro_pic+"</font></p>");
		%>
    
    <div class="container">
        <div class="card">
            <div class="card-wrapper">
                <div class="row align-items-center">
                    <div class="col-12 col-md-4">
                        <div class="image-wrapper">
                        
                        <!-- Display Picture <img src="<%=pic%>" width="130px" height="200px" alt="Student Mate">-->
                        
                            <img src="<%=pic%>" width="130px" height="200px" alt="Insert image here">
                        </div>
                    </div>
                    <div class="col-12 col-md">
                        <div class="card-box">
                            <h5 class="card-title mbr-fonts-style m-0 display-5">
                                <strong><%out.println(first+" "+last);%></strong>
                            </h5>
 
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
    </div>
</section>

<section>
    <div class="container">
            <p class="mbr-section-subtitle mbr-fonts-style mb-0 mt-2 display-5">Change profile picture</p>
				               <form action="Image" method="post" enctype = "multipart/form-data"><br>
									  <input name="file" type="file" id="" class="foo" size="25"/><br>
								      <br><button type="submit" value="Submit" class="btn btn-secondary display-4">Submit</button>
								</form>  
        
    </div>
</section>

<section class="team2 cid-stMFBXK6zb" xmlns="http://www.w3.org/1999/html" id="team2-3">

</section>


 


<section class="footer4 cid-stN1BpmyPY" once="footers" id="footer4-l">

    
    <div class="mbr-overlay" style="opacity: 0.6; background-color: rgb(35, 35, 35);"></div>
    <div class="container">
        <div class="row mbr-white">
            <div class="col-6 col-lg-3">
                <div class="media-wrap col-md-8 col-12">
                    <a href="https://mobiri.se/">
                        <img src="assets/images/mbr-11.jpg" alt="Mobirise">
                    </a>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7">
                    <strong>About</strong>
                </h5>
                <p class="mbr-text mbr-fonts-style mb-4 display-4">A student management system, simply put, is a digital platform enables user to store and track 
<br>the use of online training resources in order to make learning experiences more efficient.&nbsp;</p>
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-3 display-7">
                    <strong>Follow Us</strong>
                </h5>
                <div class="social-row display-7">
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-facebook"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-twitter"></span>
                        </a>
                    </div>
                    <div class="soc-item">
                        <a href="https://twitter.com/mobirise" target="_blank">
                            <span class="mbr-iconfont socicon socicon-instagram"></span>
                        </a>
                    </div>
                    
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7"><strong>StudentMate Help</strong>
                </h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap">Help Center</li>
                    <li class="mbr-text item-wrap">Mobirise Forums</li>
                    <li class="mbr-text item-wrap">Mobirise Kit</li>
                    <li class="mbr-text item-wrap">Our site</li>
                </ul>
            </div>
            <div class="col-12 col-md-6 col-lg-3">
                <h5 class="mbr-section-subtitle mbr-fonts-style mb-2 display-7">
                    <strong>Our Vision</strong></h5>
                <ul class="list mbr-fonts-style display-4">
                    <li class="mbr-text item-wrap"><span style="font-size: 1.1rem;">About us</span></li><li class="mbr-text item-wrap"><span style="font-size: 1.1rem;">Founders</span><br></li>
                    <li class="mbr-text item-wrap">Testimonials</li>
                    <li class="mbr-text item-wrap">Address</li>
                </ul>
            </div>
            
        </div>
    </div>
</section><section style="background-color: #fff; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif; color:#aaa; font-size:12px; padding: 0; align-items: center; display: flex;"><a href="https://mobirise.site/p" style="flex: 1 1; height: 3rem; padding-left: 1rem;"></a><p style="flex: 0 0 auto; margin:0; padding-right:1rem;">This <a href="https://mobirise.site/e" style="color:#aaa;">site</a> was built with Mobirise</p></section><script src="assets/web/assets/jquery/jquery.min.js"></script>  <script src="assets/popper/popper.min.js"></script>  <script src="assets/tether/tether.min.js"></script>  <script src="assets/bootstrap/js/bootstrap.min.js"></script>  <script src="assets/smoothscroll/smooth-scroll.js"></script>  <script src="assets/dropdown/js/nav-dropdown.js"></script>  <script src="assets/dropdown/js/navbar-dropdown.js"></script>  <script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>  <script src="assets/theme/js/script.js"></script>  
  
  
  
  
  
  
</body>
</html>