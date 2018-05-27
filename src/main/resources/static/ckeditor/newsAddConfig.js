CKEDITOR.editorConfig = function( config ) {
	//--------------------------工具栏配置
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		'/',
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		'/',
		{ name: 'others', groups: [ 'others' ] },
		{ name: 'about', groups: [ 'about' ] }
	];

	config.removeButtons = 'Source,About,Maximize,Iframe,CreateDiv,Select,Button,ImageButton,HiddenField,Textarea,TextField,Radio,Checkbox,Form,Save,NewPage,Preview,Print,Templates,PasteFromWord,SelectAll,CopyFormatting,RemoveFormat,Blockquote,Language,BidiRtl,BidiLtr,Anchor,ShowBlocks,JustifyLeft,JustifyCenter,JustifyRight,JustifyBlock,Outdent,Indent,BulletedList,NumberedList,Find,Replace,Scayt,Cut,Copy,Paste,PasteText,Undo,Redo,Table,PageBreak,Flash';

	//------------------------自定义皮肤
config.skin='kama';

	//--------------------------大小配置
	config.height=400;
	config.width = 820;


	//设置自定义表情图片（好像不能放到主配置中）
     config.smiley_columns = 8;//宽度
//     config.smiley_windowwidth = 10;//宽度
//	 config.smiley_windowheight =10;//宽度

 //config.smiley_width = 10;//宽度
	// config.smiley_height =10;//宽度


	//----------------------------上传图片配置
	//config.filebrowserUploadUrl="uploadImage.action";
	config.filebrowserImageUploadUrl="/file/upload";


	//-----------------------------表情包相关
     config.smiley_path = CKEDITOR.basePath+ 'plugins/smiley/images/'; //表情路径
     config.smiley_images =  [
		 '0.gif','1.gif','2.gif','3.gif','4.gif','5.gif','6.gif','7.gif','8.gif','9.gif',
		 '10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif','17.gif','18.gif','19.gif',
		 '20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif',
		 '30.gif','31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif','39.gif',
		 '40.gif','41.gif','42.gif','43.gif','44.gif','45.gif','46.gif','47.gif','48.gif','49.gif',
		 '50.gif','51.gif','52.gif','53.gif','54.gif','55.gif','56.gif','57.gif','58.gif','59.gif',
		 '60.gif','61.gif','62.gif','63.gif','64.gif','65.gif','66.gif','67.gif','68.gif','69.gif',
		 '70.gif','71.gif','72.gif','73.gif','74.gif','75.gif','76.gif','77.gif','78.gif','79.gif',
		 '80.gif','81.gif','82.gif','83.gif','84.gif','85.gif','86.gif','87.gif','88.gif','89.gif',
		 '90.gif','91.gif','92.gif','93.gif','94.gif','95.gif','96.gif','97.gif','98.gif'] ;
     config. smiley_description =  [
		 '0.gif','1.gif','2.gif','3.gif','4.gif','5.gif','6.gif','7.gif','8.gif','9.gif',
		 '10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif','17.gif','18.gif','19.gif',
		 '20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif',
		 '30.gif','31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif','39.gif',
		 '40.gif','41.gif','42.gif','43.gif','44.gif','45.gif','46.gif','47.gif','48.gif','49.gif',
		 '50.gif','51.gif','52.gif','53.gif','54.gif','55.gif','56.gif','57.gif','58.gif','59.gif',
		 '60.gif','61.gif','62.gif','63.gif','64.gif','65.gif','66.gif','67.gif','68.gif','69.gif',
		 '70.gif','71.gif','72.gif','73.gif','74.gif','75.gif','76.gif','77.gif','78.gif','79.gif',
		 '80.gif','81.gif','82.gif','83.gif','84.gif','85.gif','86.gif','87.gif','88.gif','89.gif',
		 '90.gif','91.gif','92.gif','93.gif','94.gif','95.gif','96.gif','97.gif','98.gif'] ;

};