<%@page pageEncoding="utf-8"  %>
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
    height:55%;
    min-height:300px;
    background-color:rgb(215,231,255);
    left:5%;
    top:20%;
    border-radius:3%;
    z-index:10;

}
div.login p.titlebox{
    width:80%;
    font-size:1.2em;
    font-weight:bold;
    color:rgb(108,165,255);
    margin:7% auto;
    text-align:center;
    font-family:"微软雅黑";
}

div.rows{
    width:80%;
    height:12%;
    font-size:1em;
    margin:3% auto;
    padding:0;
}
div.rows span{
    display: inline-block;
    width: 20%;
    vertical-align: top;
    margin-top: 2%;
}
div.rows input{
    width:70%;
    height:100%;
    border:none;
    margin:0;
    font-size:1em;
}
div.btn{
    width:100%;
    height:17%;
    background-color:rgb(108,165,255);
    margin-top:10%;
    border-bottom-left-radius: 3%;
    border-bottom-right-radius:3%;
    text-align:center;
    font-size:1em;
    color:#fff;
    border:0;
    padding-top: 5%;
}
.login b{
    display:inline-block;
    width:25px;
    height:25px;
    text-align:center;
    color:#fff;
    background-color:rgb(108,165,255);
    border-radius:50%;
    font-size:1em;
    position:absolute;
    right:3%;
    top:3%;
    padding-top:1%;
    line-height: 1;
}
div.login form{
	width: 100%;
	height: 100%;
}

</style>
 <div class="login">
            <p class="titlebox">招 募 i 码 士</p>
            <div class="rows">
                <span class="text">公司</span>
                <input type="text"  id="RegCompany" onblur="RegCompany()">
            </div>
            <div class="rows">
                <span class="text">姓名</span>
                <input type="text"  id="RegName" onblur="RegName()">
            </div>
            <div class="rows">
                <span class="text">Q Q</span>
                <input type="text"  id="RegQQ" onblur="RegQQ()">
            </div>
            <div class="rows">
                <span class="text">手机</span>
                <input type="text"  id="RegPhone" onblur="RegPhone()">
            </div>
            <div  class="btn">招募</div>
            <b>&times;</b>
        </div>
<script>
$("div.login b").click(function(){
    $("div.mask").fadeOut();
    $("div.login").fadeOut();
});

$(document).on('click', ".btn",function(){
	$.ajax({
		  type:"post",
		  url:"../better_student/insert_employ_tend",
		  dataType:"json",
		  data:{"RegName":$("#RegName").val(),"RegQQ":$("#RegQQ").val(),"RegPhone":$("#RegPhone").val(),
      		"RegCompany":$("#RegCompany").val(),"studentId":$("#studentId").attr("stuid")},
        success:function(data){
      	  if(data.code==1){
      		  titletxt = "招募成功";
      		  message = '您已经发布招募'+$("#stuName").html()+'的需求，我们将尽快与您联系';
      		  showTextBox();
      	  }else
 			  $.toast(data.msg, 1500);
        },
      error:function(){
      		$.alert("服务器忙！");
      	}
	  })
});

function showTextBox(){
	   $.ajax({
		   type:"GET",
		   url:"../base/jump?page=textBoxSuccess",
		   success: function (data) {
			   $("#rec_div").html(data);
		   },
	   	   error: function (data) {
				$.alert("服务器繁忙,请稍后再试","提示");
		   }
	   
	   });
}
</script>
    