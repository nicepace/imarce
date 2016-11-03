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
div.sal{
    position:absolute;
    width:90%;
    height:30%;
    min-height:100px;
    background-color:rgb(215,231,255);
    left:5%;
    top:35%;
    border-radius:3%;
    z-index:10;

}
div.sal p.titlebox{
    width:80%;
    font-size:1.2em;
    font-weight:bold;
    color:rgb(108,165,255);
    margin:7% auto;
    text-align:center;
    font-family:"微软雅黑";
}

div.sal .btn{
    width:100%;
    height:25%;
    background-color:rgb(108,165,255);
    margin-top:8%;
    border-bottom-left-radius: 3%;
    border-bottom-right-radius:3%;
    text-align:center;
    font-size:1em;
    color:#fff;
    border:0;
    padding-top: 2%;
}
.sal b{
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

div.sal .box{
	width: 90%;
	height: 25%;
	margin-left: 10%;
}

div.sal div.div_input {
	display: inline-block;
	margin-left:3%;
	width: 35%;
	height: 100%;
}

div.sal div.div_input input{
	width: 100%;
	height: 100%;
	border:none;
}
</style>
<div class="sal">
<p class="titlebox">薪 资 范 围</p>
   <div class="box">
	<div class="div_input" ><input type="text"  id=minsal onblur="provingMinSal()" value="${sessionScope.minsal }"></div>
	<div class="div_mid" style="display: inline-block;color: rgb(108,165,255);font: bold;">&nbsp—</div>
	<div class="div_input" ><input type="text"  id=maxsal onblur="provingMaxSal()" value="${sessionScope.maxsal }"></div>
	</div>
	<div  class="btn">确定</div>
    <b>&times;</b>
</div>

<script>
$("div.sal b").click(function(){
    $("div.mask").fadeOut();
    $("div.sal").fadeOut();
});

$(document).on('click', ".sal .btn",function(){
	if(provingSal()){
		  $.ajax({
      		url:"../release_requirement/add_sal",
      		type:"post",
      		data:{"minsal":$("#minsal").val().trim(),"maxsal":$("#maxsal").val().trim()},
      		success:function(data){
      			$("#salvalue").html(data);
      			$("#salvalue").show();
      			sal=data;
      			$("div.mask").fadeOut();
      		    $("div.sal").fadeOut();
      		},
      		error:function(){
      			
      		}
      	})
	}
});
</script>