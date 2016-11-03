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
div.txtbox{
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
div.txtbox p.titlebox{
    width:80%;
    font-size:1.2em;
    font-weight:bold;
    color:rgb(108,165,255);
    margin:7% auto;
    text-align:center;
    font-family:"微软雅黑";
}

div.txtbox .btn{
    width:100%;
    height:23%;
    background-color:rgb(108,165,255);
    margin-top:10%;
    border-bottom-left-radius: 3%;
    border-bottom-right-radius:3%;
    text-align:center;
    font-size:1em;
    color:#fff;
    border:0;
    padding-top: 2%;
}
.txtbox b{
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

div.txtbox input{
	margin-left: 10%;
	height: 23%;
	width: 80%;
	border:none;
}

</style>
<div class="txtbox">
<p class="titlebox">自 定 义 标 签</p>
	<input  type="text" placeholder="最多可输入6个字" id="tagName"></input>
	<div  class="btn">添加</div>
    <b>&times;</b>
</div>

<script>
$("div.txtbox b").click(function(){
    $("div.mask").fadeOut();
    $("div.txtbox").fadeOut();
});


</script>