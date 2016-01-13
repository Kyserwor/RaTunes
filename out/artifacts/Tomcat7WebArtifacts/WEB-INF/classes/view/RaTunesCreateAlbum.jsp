<%@page import="mvc.model.Album"%>
<%@page import="mvc.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.awt.List"%>
<%@page import="org.omg.CORBA.SystemException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="../css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="/css/menu.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css" />
<script type="text/javascript" src="/js/sidebar.js"></script>
	<script src="../js/modernizr.custom.js"></script>
<script type="text/javascript" src="ValidateInput.js"></script>
	<script type="text/javascript" src="/js/albums.js"></script>
	<script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/font-awesome-4.4.0/css/font-awesome.css">
<link rel="icon" href="/images/RaTunesIcon.png" type="image/png" />
<link rel="stylesheet" href="/scss/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RaTunes</title>
</head>
<body style="cursor: context-menu">
<form>
	<div class="-cx-PRIVATE-Shell__nav">
		<div class="logoContain" href="/view/RaTunesRegistration.jsp">
			<br>
			<i class="fa fa-mouse-pointer fa-spin"></i>
		</div>
		<br>
		<h1 class="italic fa fa-music fa-3x"> RaTunes music management</h1>
	</div>
	<div class="task">
		<input type="button" class="logoutButton" value="Logout ${sessionScope.user.name}" onclick="albums.logout()">
		<div class="editorContain">
			<i class="editButton fa fa-pencil-square-o fa-2x" onclick="albums.enableEditMode()" title="edit Album"></i>
			<i class="saveButton fa fa-archive fa-2x" onclick="albums.clickSaveButton()" title="Saving changed files"></i>
			<div class="newButton"></div>
		</div>
	</div>
	<div class="menu">
		<input id="albumsButton" type="button" class="albumTitle albumButton" onclick="albums.existingAlbumsDB()" value="EXISTING ALBUMS">
		<div id="albums">
			<div id="albumList">
			</div>
		</div>
	</div>
	<div class="containContent">
		<div id="albumCover">
		</div>

		<div id="albumInfoContainer">
		</div>
		<div id="songList">
		</div>

		<div id="footer">
			<i class="musicPlayer fa fa-play"></i>
			<i class="musicPlayer fa fa-volume-down"></i>
			<i class="musicPlayer fa fa-volume-off"></i>
			<i class="musicPlayer fa fa-volume-up"></i>
			<h5 class="italic right">Created by Ramon Lukas</h5>
		</div>
	</div>
</form>
</body>
</html>