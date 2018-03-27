(function() {
    loadPage();
    function loadPage(){
        $.ajax({
            type: "GET",
            url: "http://localhost:3000/blog",
            // url: "http://192.168.1.214:3000/api/people",
            success: function(items) {
                // console.log('success',items);
                $.each(items, function(i,item){
                    $('#posts').append('<div class="container">');
                    $('#posts').append('<h3>'+item.title+'</h3><br>');
                    $('#posts').append('<article class="row-med">' +item.content+'</article><br>');
                    $('#posts').append('<p>Categories: '+item.categories+'</p>');
                    $('#posts').append('<p>Date: ' +item.date+'</p>');
                    $('#posts').append('</div>');
                });
            },
            error: function(){
                alert('error loading orders!');
            }
        }).done(function(data){
            addClickListener();
            $('table').css({
                'background-color': 'aqua',
                'margin': '0',
                'font-family': 'arial'
            });
            $('body').css(
                'background-color', 'rgb(11, 208, 235)'
            );
        });
    }

    $('button').click(function(){
        $("#posts").empty();
        loadPage();
    });

    // $('#userInput:contains('#userInput.val')').click;

    function addClickListener() {
        $('#searchButton').click(function(){
            $( "#userInput" ).keyup(function() {
                var value = $( this ).val();
                // console.log(value);
                // $("article:contains(value)").css("background-color", "yellow");
                // console.log($("article:contains(Lorem)"));

                $("article:contains(value)").each( function( i, element ) {
                    var content = $(element).text();
                    console.log(content);
                    content = content.replace( value +'<span class="search-found">' + value + '</span>' );
                    element.html( content ).css("background-color","yellow");
                });

            })
                .keyup();
        });
    }
})();