;(function($,window){
	$.fn.Ds_loading = function(options) {
		this.each(function(){
			var opts = $.extend({},$.fn.Ds_loading.defaults,$.fn.Ds_loading.methods,options,$.fn.Ds_loading.parseOptions($(this)));
			$("#loading").remove();
			var $loading = opts.template(opts);
			//初始化
			opts.events($loading,opts);
		});
	};
	//设置公共方法
	$.fn.Ds_loading.methods = {
		//设置模板
		template : function(opts){
			var $loading = $("#loading");
			if(!$loading[0]){
				$loading = $("<div id='loading'"+
				"style='color:"+opts.color+";height:"+opts.height+"px;width:"+opts.width+"px;line-height:"+opts.height+"px;background:"+opts.background+";"+
				"text-align:center;border:1px solid "+opts.background+";box-shadow: 5px 5px 1em "+opts.background+";'>"+
				"<span class='content'>"+opts.title+"</span></div>");
				$("body").append($loading);			
			}else{
				$loading.find(".content").html(opts.title);		
			}
			//位置设置
			return $loading;
		},
		//设置事件（设置方向，位置）
		events : function($loading,opts){
			//设定位置
			$.fn.position($loading,opts);
			//定时关闭
			var timer = null;
			if(opts.time > 0){
				clearTimeout(timer);
				timer = setTimeout(function(){
					$loading.fadeOut("slow",function(){
						$(this).remove();
					});
				},opts.time);
			}
			//窗口大小设置
			$(window).resize(function(){
				opts.events($loading,opts);
			});
		}
	}
	//设置默认参数
	$.fn.Ds_loading.defaults = {
		width : 180,
		height : 35,
		color : "#fff",
		title : "正在加载中...",
		background : "black",
		position : "center",
		marginTop : 0,
		time : 0
	};
	$.fn.Ds_loading.parseOptions = function($loading){
		return {
			width : $loading.data("width"),
			height : $loading.data("height"),
			color : $loading.data("color"),
			title : $loading.data("title"),
			background : $loading.data("background"),
			position : $loading.data("position"),
			marginTop : $loading.data("marginTop"),
			time : $loading.data("time")
		};
	}
})(jQuery,window);						
//控制位置方向的组件
;(function($) {
	$.fn.position = function($loading,opts) {
		var left,top;
		var	marginLeft = (-($loading.width()/2))+"px";
		var margin = " "+(-($loading.height()/2))+"px 0 0 "+marginLeft;
		switch (opts.position){
			case 'center': 
				top = left = '50%';
			break;
			case 'top': 
				top = 0; left = '50%'; margin = " "+opts.marginTop+"px 0 0 "+marginLeft;
			break;
			case 'left': 
				top = left = margin = 0;
			break;
			default: 
				top = left = '50%';
		}
		$loading.css({
			position : "fixed",
			top : top,
			left : left,
			margin : margin,
			zIndex : 10000
		});
	};
})(jQuery);