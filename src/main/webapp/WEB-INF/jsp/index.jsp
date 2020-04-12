<!DOCTYPE html>
<html lang="en">
<head>
  <title>HW4</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 850px}

    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }

    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href=""><img src="https://assets.chucknorris.host/img/avatar/chuck-norris.png" height="25" width="25"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">

      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left">
      <h1 align="center">Random Chuck Norris Jokes</h1>
      <p align="center"></p>
      <hr>
        <div class="panel-body"><h3 align="center">"${fact}"<h3></div>
<div class="text-center">
       <form method="post" action="/save">
           <input type="hidden" name="id" value="">

           <p>Click to Save Joke</p>
           <input type="text" name="jokes" value="${fact}"><br>
           <input type="submit" value="Save">
       </form>
</div>

	<h3>Saved Jokes</h3>
<div class="text-center">
	<div>
        <form method="get" action="/load">
                          <table class="table table-striped">
                              <thead>
                                <tr>
                                  <th>Jokes</th>
                                </tr>
                              </thead>
                              <tbody>
                              <c:forEach var = "item" items = "${list}">
                                <tr>
                                  <td>${item.list}</td>
                                </tr>
                                </c:forEach>
                              </tbody>
                            </table>

                            <input align="center" type="submit" value="Load">
                            </form><br>
                            <h3>RAW Data From List</h3>
                            ${list}<br>
                            ${jokesmodel.jokeStatement}

    </div>
    </div>
    <div class="col-sm-2 sidenav">
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>By: Rogelio Rios</p>
</footer>

</body>
</html>
