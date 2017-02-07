<div id="top">
        <div class="setCenter top_logos">
            <a href="indexAction!index.action" class="top_logo" style="background:url('images/logo_main.png')"></a>
            <h1 class="top_title">茶树病虫害远程专家系统</h1>
            <div style="height:60px;width:240px;float:right">
                <i style="float:left;display:block;width:60px;height:60px;background:url('assets/images/lianxi.png') no-repeat center center;"></i>
                <div style="float:left;text-indent:20px;font-size:19px;">0532-88030271</div>
            </div>
            <div class="clear"></div>
        </div>
        <div id="nav" >
            <ul id="nav_ul" class="setCenter">
                <li><a href="indexAction!index.action" id="index">首页</a></li>
                <li><a href="fnewsAction!news.action" id="news">预警信息</a></li>
                <li><a href="fdiagnosisAction!list.action" id="diagnosis">自助诊断</a></li>
                <li><a href="fexpertAction!expert.action" id="expert">专家诊断</a></li>
                <li><a href="fpestAction!toFPest.action"id="pest">虫害浏览</a></li>
                <li><a href="fdiseasesAction!toFDiseases.action"id="diseases">病害浏览</a></li>
                <li><a href="farticleAction!toArticle.action" id="article">问题解答</a></li>
                <li><a href="fmessageAction!message.action" id="message">查看留言</a></li> 
                <li><a href="fdownloadAction!download.action" id="download">下载专区</a></li>
                <div class="clear"></div>
            </ul>
        </div>
    </div>
    <!-- top end -->
   <script type="text/javascript">
   var href = window.location.href;
   if(href.indexOf("index")!= -1){
      document.getElementById("index").className = "front_select";
   }else if(href.indexOf("pest")!= -1){
      document.getElementById("pest").className = "front_select";
   }else if(href.indexOf("message")!=-1){
      document.getElementById("message").className = "front_select";
   }else if(href.indexOf("article")!=-1){
      document.getElementById("article").className = "front_select";
   }else if(href.indexOf("news")!=-1){
      document.getElementById("news").className = "front_select";
   }else if(href.indexOf("download")!=-1){
      document.getElementById("download").className = "front_select";
   }else if(href.indexOf("expert")!=-1){
      document.getElementById("expert").className = "front_select";
  }else if(href.indexOf("diagnosis")!=-1){
  document.getElementById("diagnosis").className = "front_select";
   }else if(href.indexOf("diseases")!=-1){
      document.getElementById("diseases").className = "front_select";
   }
</script>
<!--banner start-->
<div class="nav_banner" height="300" width="1080">
    <#list listheadImg as headImg>
    <#if headImg_index = 0>
        <div class="banner_list"style="background:url('${headImg.path!assets/images/m_banner1.jpg}') no-repeat ;z-index:5;background-size:1080px 300px;"></div>
    <#else>
        <div class="banner_list"style="background:url('${headImg.path!assets/images/m_banner1.jpg}') no-repeat;background-size:1080px 300px;"></div>
    </#if>
    </#list>
</div>
<script type="text/javascript">
    $(".nav_banner").ds_banner();
</script>
