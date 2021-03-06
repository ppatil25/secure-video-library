<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>The Video Library</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div class="container" style="margin: 50px">
        <div>
            <form action="/logout" method="post">
                <button type="submit" class="btn btn-danger">Log Out</button>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
        <div class="row text-center">
            <strong>Available Videos</strong>
        </div>
        <div class="row" style="border: 1px solid green; padding: 10px">
            <div class="col-md-4 text-center">
                <strong>Title</strong>
            </div>
            <div class="col-md-4 text-center">
                <strong>Duration</strong>
            </div>
            <div class="col-md-4 text-center">
                <strong>Description</strong>
            </div>
        </div>
        <c:forEach var="video" items="${videos}">
            <div class="row" style="border: 1px solid green; padding: 10px">
                <div class="col-md-4 text-center">


                        <a href="${video.link}">${video.title}</a>

                </div>
                <div class="col-md-4 text-center">${video.duration}</div>
                <div class="col-md-4 text-center">${video.desc}</div>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>
