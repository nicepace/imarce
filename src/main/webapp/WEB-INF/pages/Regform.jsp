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

div.row{
    width:80%;
    height:12%;
    font-size:1em;
    margin:3% auto;
    padding:0;
}
div.row span{
    display: inline-block;
    width: 20%;
    vertical-align: top;
    margin-top: 2%;
}
div.row input{
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
<form id="fm_reg">
<p class="titlebox">一键注册，成为码士</p>

            <div class="row">
                <span class="text">姓名</span>
                <input type="text"  id="RegName" name="RegName" onblur="isRegName()">
            </div>
            <div class="row">
                <span class="text">Q Q</span>
                <input type="text"  id="RegQQ" name="RegQQ" onblur="isRegQQ()">
            </div>
            <div class="row">
                <span class="text">手机</span>
                <input type="text"  id="RegPhone" name="RegPhone" onblur="isRegPhone()">
            </div>
            <div class="row">
                <span class="text">城市</span>
                <input type="text" id='city-picker'  name="RegAddress"/>
				<script>
				  $("#city-picker").cityPicker({
					toolbarTemplate: '<header class="bar bar-nav">\
					<button class="button button-link pull-right close-picker">OK</button>\
					<h1 class="title">选择地区</h1>\
					</header>'
				  });
				</script>
            </div>
            <div  class="btn">提交</div>
            
            <b>&times;</b>
</form>
   </div>
   <script>
   function isRegName(){
	   var Validation = new RegExp("^[\u4e00-\u9fa5][\u4e00-\u9fa5]{1,7}$");
	   if($("#RegName").val()!=""){
		   if(Validation.test($("#RegName").val())){
			   return true;
		   }
		   else{
			   $.toast("姓名必须为2~8位汉字", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("姓名不能为空", 1500);
		   return false;
		}
   }
   
   function isRegPhone(){
	   var Validation = new RegExp("^[1][358][0-9]{9}$");
	   var Telephone = new RegExp("(^(\\d{2,4}[-_－—])?\\d{7,8}$)|(^0?1[358]\\d{9}$)");
	   if($("#RegPhone").val()!=""){
		   if(Validation.test($("#RegPhone").val()) || Telephone.test($("#RegPhone").val())){
			   return true;
		   }
		   else{
			   $.toast("手机号码格式不正确", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   $.toast("联系方式不能为空", 1500);
		   return false;
		}
   }
   
   function isRegQQ(){
	   var Validation = new RegExp("^[1-9][0-9]{4,10}$");
	   if($("#RegQQ").val()!=""){
		   if(Validation.test($("#RegQQ").val())){
			   return true;
		   }
		   else{
			   $.toast("QQ号码格式不正确", 1500);
			   return false;
		   }  
	   }
	   else
		{
		   return false;
		}
   }
   
   $(document).on('click', ".btn",function(){
	   var url="../reg_rec/insert_stu";
  	   $.showPreloader('数据提交中...')
	   $("#fm_reg").ajaxSubmit({
		   type: "POST",
		   url:url,
		   dataType: "json",
		   success: function (data) {
			   $.hidePreloader();
  				if(data.code == 1){
  					message = data.msg;
  					titletxt = "注册成功";
  					showTextBox();
  				}
  				else
  					$.toast(data.msg, 1500);
  			},
  			error: function (data) {
  				$.hidePreloader();
  				$.alert("服务器繁忙,请稍后再试","提示");
  			}
	   });
	   
   });
   
   $("div.login b").click(function(){
	    $("div.mask").fadeOut();
	    $("div.login").fadeOut();
	});
   
   function showTextBox(){
	   $.ajax({
		   type:"GET",
		   url:"../base/jump?page=textBoxSuccess",
		   success: function (data) {
			   $("#reg_div").html(data);
		   },
	   	   error: function (data) {
				$.alert("服务器繁忙,请稍后再试","提示");
		   }
	   
	   });
   }
   </script>