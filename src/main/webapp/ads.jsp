<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ads</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <link rel="stylesheet" href="resources/css/jstl-example.css">

    <title>Title</title>
</head>
<body class="container-fluid">

<!-- As a link -->
<div class="container">

    <nav class="navbar navbar-light bg-primary container" style="background: black">
        <a class="navbar-brand" href="#"><strong>Gonzo's SA Ads</strong></a>
        <div class="navbar-light" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0">
                <input id="userInput" class="form-control mr-sm-2" type="text" placeholder="Search">
                <button id="searchButton" class="btn btn-outline-success my-2 my-sm-0" type="button" style="color: black">Search</button>
            </form>
        </div>
    </nav>
    <form class="form-inline">
        <button id="pinchebutton" class="btn btn-outline-success" type="submit">Refresh Articles</button>
    </form>
</div>

<div id="posts" class="container"></div>
<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>
<script>
    (function() {
        loadPage();
        function loadPage(){
            $.ajax({
                type: "GET",
                url: "http://localhost:3000/ads",
                success: function(items) {
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
</script>
</body>
</html>

