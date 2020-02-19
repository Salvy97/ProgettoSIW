function showPages() {
	var pageSize = 3;
    var pagesCount = $(".content").length;
    var totalPages = Math.ceil(pagesCount / pageSize);
       
    for (var s=0; s<Math.min(totalPages,5); s++){
		  $('#ul').append('<li class="page-item"><a href="#" class="page-link">'+(s+1)+'</a></li>');
	}
    
    
    $('.pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: Math.min(totalPages,5),
        onPageClick: function (event, page) {
            var startIndex = (pageSize*(page-1));
            var endIndex = startIndex + pageSize;
            $('.content').hide().filter(function(){
                var idx = $(this).index();
                return idx>=startIndex && idx<endIndex;
            }).show()
        }
    });
}