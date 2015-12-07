$(function(){
    $('.upload-form').submit(function(e){
    	var fileInput = $('.upload-file');
        var maxSize = fileInput.data('max-size');
    	var podeSubmeter = true;
        if(fileInput.get(0).files.length){
        	for(var i = 0 ; i < fileInput.size(); i++){
        		var fileSize = fileInput.get(i).files[0].size; 
        		if(fileSize>maxSize){
        			alert('O arquivo não pode ter mais que ' + maxSize/1024 + ' Kbytes');
        			podeSubmeter = false;
        		}
        	}
        }
        return podeSubmeter;
    });
});