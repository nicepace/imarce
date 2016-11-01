  <%@ page pageEncoding="UTF-8"%> 
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
div.introduce{
    position:absolute;
    width:90%;
    height:45%;
    min-height:250px;
    background-color:rgb(215,231,255);
    left:5%;
    top:25%;
    border-radius:3%;
    z-index:10;

}
div.introduce p.titlebox{
    width:80%;
    font-size:1.2em;
    font-weight:bold;
    color:rgb(108,165,255);
    margin:7% auto;
    text-align:center;
    font-family:"微软雅黑";
}

div.introduce .btn{
    width:100%;
    height:20%;
    background-color:rgb(108,165,255);
    margin-top:5%;
    border-bottom-left-radius: 3%;
    border-bottom-right-radius:3%;
    text-align:center;
    font-size:1em;
    color:#fff;
    border:0;
    padding-top: 5%;
}
.introduce b{
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

div.introduce .txtInput{
	margin-left:10%;
	width: 80%;
	height: 55%;
	border:none;
}
</style>
<div class="introduce">
<p class="titlebox">职 业 描 述</p>
	<textarea  class="txtInput" placeholder="可从业务能力，项目经验，领导力，团体协作等方面描述职位需求" id=introduce>${sessionScope.introduce }</textarea>
	<div  class="btn">确定</div>
    <b>&times;</b>
</div>

<script>
$("div.introduce b").click(function(){
    $("div.mask").fadeOut();
    $("div.introduce").fadeOut();
});

$(document).on('click', ".introduce .btn",function(){
	if(provingIntroduce($("#introduce").val().trim())){
 		$.ajax({
     		url:"../release_requirement/add_introduce",
     		type:"post",
     		data:{"introduce":$("#introduce").val()},
     		success:function(data){
     			$("#introducevalue").html(data);
     			$("#introducevalue").show();
     			introduce = data;
     			$("div.mask").fadeOut();
     		    $("div.introduce").fadeOut();
     		},
     		error:function(){
     			
     		}
     	})
 	}
});
</script>