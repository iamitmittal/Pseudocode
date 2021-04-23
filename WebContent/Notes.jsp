<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList"%>	
<%@ page import ="pseudocode.StudentDao" %>
<!DOCTYPE html>
<html  >
<head>
  <meta charset="ISO-8859-1">
   <!--css-->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  <title>Your Notes</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.css">
  <link rel="stylesheet" href="assets/formstyler/jquery.formstyler.theme.css">
  <link rel="stylesheet" href="assets/datepicker/jquery.datetimepicker.min.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

	<style> 
	input[type=text] {
	  width: 60%;
	  padding: 20px;
	  margin: 8px 0;
	  box-sizing: border-box;
	  box-align: center;
	}
	
	.foo
	{
	    padding: 8px;
	}
	</style>
	  
</head>
<body>

  <%
	String first = (String)request.getSession().getAttribute("first");
    String last = (String)request.getSession().getAttribute("last");
    String username = (String)request.getSession().getAttribute("username");
	%>

  <section class="menu menu1 cid-stMFcqsk7w" once="menu" id="menu1-6">
    
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


<!-- Editor -->      
	
<section class="content12 cid-stN3jHzkiD" id="content12-o">
    
       <%
	String deleteNote=(String)request.getAttribute("messageNote");  
	if(deleteNote!=null)
	out.println("<p align= center><font color=red size=4px>"+deleteNote+"</font></p>");
	%>
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12 col-lg-10">
     			<h5 class="mbr-section-subtitle mbr-fonts-style mb-0 mt-2 display-5">Add your notes here..</h5>
               <form action="Notes" method="post">
					  <input name="title" type=" " id="" class="foo" placeholder="Title here..." size="73"/><br>
				      <input name="alltext" type="text" id="" placeholder="Please input your text here..." 	/>
				      <button type="submit" class="btn btn-secondary display-4">Submit</button>
				</form>       
            
           	<br><table width="59%" border="1">
           	<h5 class="mbr-section-subtitle mbr-fonts-style mb-0 mt-2 display-5">Refer your notes here..</h5>
	<tr>
        <td><b>Title</b></td>
        <td><b>Notes</b></td>
        <td><b>Date<b></b></td>
        </tr>
        
<%
	ArrayList<String> display = StudentDao.showNotes();

// print the information about every category of the list
		for(int i = 0; i<display.size()/3; i++){
			%>
		    <tr>
		       <%
		      
		       %>
		       <td><%=display.get(i*3)%></td>
		       <td><%=display.get((i*3)+1)%></td>
		       <td><%=display.get((i*3)+2).split(" ")[0]%></td>
		       <% 
		       	 }
		          %> 
	</table>
            
            <br><p class="mbr-section-subtitle mbr-fonts-style mb-0 mt-2 display-5">Please mention title to delete notes</p>
               <br><form action="DeleteNotes" method="post">
					  <input name="deletetitle" type=" " id="" class="foo" placeholder="Title here..." size="25"/><br>
				      <br><button type="submit" class="btn btn-secondary display-4">Submit</button>
				</form>   
            
  
            </div>
        </div>
    </div>
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
</section> 
 
 <script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>
 
  
</body>
</html>