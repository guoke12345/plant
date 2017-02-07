<div class="dh clearfix" style="width:1000px;position:relative;">
     <div class="dh_left fl"><img src="images/logo.png" alt=""/></div>
     <div class="dh_list fl">
        <#if adminUser??>
          <ul>
              <li id="banner"><a href="${basePath}/headimgAction!banner.action">banner管理</a></li>
              <li id="question"><a href="${basePath}/questionAction!toList.action">手机问答</a></li>
              <li id="user"><a href="${basePath}/userAction!page.action">用户管理</a></li>
              <li id="pest"><a href="${basePath}/pestAction!page.action">虫害管理</a></li>
              <li id="diseases"><a href="${basePath}/diseasesAction!page.action">病害管理</a></li>
              <li id="diagnosis"><a href="${basePath}/diagnosisAction!list.action">诊断管理</a></li>
              <li id="article"><a href="${basePath}/articleAction!page.action">文章管理</a></li>
              <li id="message"><a href="${basePath}/msgAction!message.action">电脑留言</a></li>
              <li class="logout select"  style="position:absolute;right:0px;top:0px;"><a href="loginAction!logout.action">退出</a></li>
          </ul>
          <#else>
          <ul>
              <li id="question"><a href="${basePath}/questionAction!toList.action">问答管理</a></li>
              <li class="logout select"  style="position:absolute;right:0px;top:0px;"><a href="loginAction!logout.action">退出</a></li>
          </ul>
          </#if>
     </div>
</div>
<script type="text/javascript">
   var href = window.location.href;
   if(href.indexOf("article")!= -1){
      document.getElementById("article").className = "select";
   }else if(href.indexOf("pest")!= -1){
      document.getElementById("pest").className = "select";
   }else if(href.indexOf("user")!=-1){
      document.getElementById("user").className = "select";
   }else if(href.indexOf("headimg")!=-1){
      document.getElementById("banner").className = "select";
   }else if(href.indexOf("question")!=-1){
      document.getElementById("question").className = "select";
   }else if(href.indexOf("diagnosis")!=-1){
      document.getElementById("diagnosis").className = "select";  
   }else if(href.indexOf("msgAction")!=-1){
      document.getElementById("message").className = "select";
   }else if(href.indexOf("diseases")!=-1){
      document.getElementById("diseases").className = "select";
   }
</script>