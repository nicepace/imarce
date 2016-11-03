<%@ page  pageEncoding="UTF-8"%>
<style>

/*遮罩层*/
.mask{
    position:fixed;
    min-width:100%;
    min-height:100%;
    background-color:#111113;
    opacity:0.8;
    top:0%;
    left:0%;
    z-index:8;
}
/*登录信息*/
div.login{
    position:absolute;
    width:90%;
    height:33%;
    background-color:rgb(215,231,255);
    left:5%;
    top:33%;
    border-radius:3%;
    z-index:10;

}
div.login p.titlebox{
    width:80%;
    font-size:1.3em;
    font-weight:bold;
    color:rgb(108,165,255);
    margin:7% auto;
    text-align:center;
    font-family:"微软雅黑";
}


.login b{
    display:inline-block;
    width:25px;
    height:25px;
    color:#fff;
    text-align:center;
    background-color:rgb(108,165,255);
    border-radius:50%;
    font-size:1em;
    position:absolute;
    right:3%;
    top:3%;
    padding-top:1%;
    line-height: 1;
}

div.message{
	margin-left:10%;
	margin-right:10%;
	font-size:1.2em;
	text-align: center;
}
</style>
<div class="login">
<p class="titlebox"></p>

            <div class="message">
                
            </div>
            
            <b>&times;</b>
   </div>
   <script>
   $(function(){
		showMessage();
	});
   
   $("div.login b").click(function(){
	    $("div.mask").fadeOut();
	    $("div.login").fadeOut();
	});
   
   function showMessage(){
	   $(".titlebox").html(titletxt);
	   $(".message").html(message);
   }
   
   </script>