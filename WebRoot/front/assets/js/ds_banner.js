;(function($){
	$.fn.ds_banner = function(options) {
			this.each(function(){
			//参数的继承
			var opts = $.extend({},$.fn.ds_banner.defaults,options,$.fn.ds_banner.parseOptions($(this)));	
			//获取目标
			opts.box = $(this);
			opts._length = $(this).find(".banner_list").length;
			addTemplate(opts);
			$(this).css({width:opts.width,height:opts.height});
			opts.timer = null;
			opts.index = 0;
			opts.$btn_list = $(this).find(".banner_btn");
			opts.$opa = $(this).find(".banner_opa");
			opts.$content_list = $(this).find(".banner_list");
			init(opts);
		});
	};
	//自动播放的初始化
	function init(opts){
		opts.$btn_list.css("width",_banner_btnWidth);
		opts.$opa.css("width",_banner_btnWidth);
		set_banner_left(opts);
		opts.$btn_list.find("li").mouseover(function(e){
			clearInterval(opts.timer);
			opts.index = $(this).index();
			event(opts);
		}).mouseout(function(e){
			auto(opts);
		}); 
		auto(opts);
	};
	function addTemplate(opts){
		var $this = opts.box;
		var ul_content = "<ul class='banner_btn'>"+
		"	<li style='background:#0cc4ab'></li>";
		for(var i = 0 ;i < (opts._length-1) ; i++ ){
			ul_content += "<li></li>";	
		};
		ul_content += "</ul><div class='clear banner_opa'></div>";
		$this.append($(ul_content));
	}
	//默认参数
	$.fn.ds_banner.defaults = {
		//带宽度的拖动
		width : "",
		//设置高度方向
		height : ""
	};
	//属性参数
	$.fn.ds_banner.parseOptions = function(target){
		var $target = $(target);
		return {
			width : $target.attr("width"),
			height : $target.attr("height")
		};

	};
	//设置自动播放
	function auto(opts){
		opts.timer = setInterval(function(){
			if(opts.index==opts._length-1){
			opts.index = -1;
			};
			opts.index++;
			event(opts);
		},10000);	
	};
	function event(opts){
		opts.$btn_list.find("li").eq(opts.index).css("background","#0cc4ab").siblings().css("background","#fff");
		$this = $(".banner_list").eq(opts.index);
		opts.$content_list.css({"opacity":0,"z-index":0});
		$this.css({"z-index":1,"opacity":0}).fadeTo(1500,1);					
	};
	//通过计算得到中间ul的宽度
	function  _banner_btnWidth(){
		var $li = $(".banner_btn").find("li"); 
		var $li_len = $li.length;
		return  (($li.width() + 3) * $li_len);
	}; 
	function set_banner_left(opts){
		var _banner_ulWidth = 50 + _banner_btnWidth();
		var _banner_width = opts.width;
		var _left = (_banner_width-_banner_ulWidth)/2+"px";
		opts.$btn_list.css("left",_left);
		$(".banner_opa").css("left",_left);
	};
	//获取频幕宽度
	function getClientWidth() {
		var clientWidth = 0;
		if (document.body.clientWidth && document.documentElement.clientWidth) {
			clientWidth = (document.body.clientWidth < document.documentElement.clientWidth) ? document.body.clientWidth: document.documentElement.clientWidth;
		} else {
			clientWidth = (document.body.clientWidth > document.documentElement.clientWidth) ? document.body.clientWidth: document.documentElement.clientWidth;
		};
		return clientWidth;
	};
})(jQuery);