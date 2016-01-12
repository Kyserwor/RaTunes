function validateInputflied() { 
	if(document.inputField.inputAlbumTitle.value=="") {
		document.getElementById("albumTitleMessage").innerHTML = "album title should not be blank!";
		return false;
	} else if(document.inputField.inputAlbumArtist.value=="") {  
		document.getElementById("albumArtistMessage").innerHTML = "artist from album should not be blank!";
		return false; 
	} else if(document.inputField.inputSongTitle.value=="") {
		document.getElementById("songTitleMessage").innerHTML = "song title should not be blank!";
		return false; 
	} else if(document.inputField.inputSongArtist.value=="") {
		document.getElementById("songArtistMessage").innerHTML = "artist from song should not be blank!";
		return false; 
	}
	return true;
}