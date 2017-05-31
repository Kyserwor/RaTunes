/**
 * Created by rlukas on 10.11.2015.
 */

var albums= {

    globalAlbums: "",

    existingAlbumsDB: function() {
        $.ajax({

            url: "JsListener",
            dataType: 'json',
            error: function () {

                alert("Error Occured");
            },
            success: function (data) {
                albums.albumsToList(data);
            }
        });
    },

    albumsToList: function(albumList) {
        this.clearIdDiv();
        this.globalAlbums = albumList.albums;
        $.each(albumList.albums, function (key, value) {
            albums.printAlbumTitle(value, key);
        })
    },

    clearIdDiv: function() {
        $("#albumList").empty();
    },

    printAlbumTitle: function(album, key) {
        var ul = $("#albumList");
        var li = $("<input id='albumTitleId' type='button' " + key + " class='albumTitle albumButton' onclick='albums.showAlbum(" + key + ")' value='" + album.title + "'><br>");
        ul.append(li);
    },

    showAlbum: function(albumKey) {
        albums.clearEditMode();
        albums.showEditMode(albumKey);
        albums.clearAlbumCover();
        albums.showAlbumCover(albumKey);
        albums.showAlbumInfo(albumKey);
        albums.showSongs(albumKey, this.globalAlbums[albumKey].songs);
    },

    showEditMode: function(albumKey){
        var editorContain = $(".editorContain");
        var editButtons = $("<i class='editButton fa fa-pencil-square-o' onclick='albums.enableEditMode()' title='edit Album'></i>"
                                + "<i class='saveButton fa fa-archive ' onclick='albums.clickSaveButton("+albumKey+")' title='Saving changed files'></i>"
                                + "<div class='newButton'></div>");
        editorContain.append(editButtons);
        console.log("albumKey: " + albumKey);
    },

    clearEditMode: function(){
        $(".editorContain").empty();
    },

    showAlbumCover: function(albumKey){
        var albumCover = $("<div id='albumCover' class='albumCover'></div>");
        var coverTitle = $("<h4 class='albumCoverTitle'>" + this.globalAlbums[albumKey].title + "</h4>");
        $('#albumCover').append(albumCover);
        albumCover.append(coverTitle);
    },

    clearAlbumCover: function(){
      $("#albumCover").empty();
    },


    showAlbumInfo: function(index) {
        this.clearAlbumInfo();
        var albumInfo = $("#albumInfoContainer");

        var albumTitle = $("<div id='albumTitle' class='infoPart'><h5 class='gray'> Album: </h5><input class='edit' id='"+this.globalAlbums[index].id+"' name='albumTitle' value='"+this.globalAlbums[index].title+"' type='text' disabled='disabled'></div>");
        var albumArtists = $("<div id='artists' class='infoPart'><h5 class='gray'>artist: </h5>");

        $.each(this.globalAlbums[index].artists, function(key, value){
            artist = $("<input>");
            artist.val(value.name);
            artist.type = "Text";
            artist.prop("disabled", true);
            artist.addClass("infoPart2 edit");
            artist.attr("name","albumArtists");
            artist.attr("id",value.id);


            albumArtists.append(artist,"<br>");
        })


        var numberOfSongs = $("<div class='infoPart'><h5 class='gray'>number of songs: </h5><h4 class='green'>"+this.globalAlbums[index].songs.length+" Song</h4></div>");

        albumInfo.append(albumTitle,albumArtists,numberOfSongs);
    },

    clearAlbumInfo: function(){
        $("#albumInfoContainer").empty();
    },

    enableEditMode: function(){
        $(".edit").prop("disabled", false).addClass("enableEdit");
        if (document.querySelector("#newSongButton") !== null){
        }else {
            albums.enableNewSongButton();




            albums.enableNewAlbumButton();
        }
    },

    enableNewSongButton: function(){
        $(".editorContain").append("<i id='newSongButton' title='new Song' class='newButton fa fa-file-text' onclick='albums.addNewSong()'></i>");
    },

    enableNewAlbumButton: function(){
        $(".editorContain").append("<i id='newAlbumButton' title='new Album' class='newButton fa fa-file-text' onclick='albums.addNewAlbum()'></i>")
    },

    disableNewButton: function(){
        $(".newButton").empty();
    },

    addNewSong: function () {
        $("#songList").append("<input id='newSong' class='songPart edit enableEdit' name='albumSongs' value='new Song' type='text'>");
    },

    addNewAlbum: function(){
        var editorContain = $(".editorContain");

    },

    showSongs: function(albumKey, songs){
        albums.clearSongs();
        var songDescription = $("<i class='songDescription'><strong>Song</strong>");
        var shownSongs = $("#songList");
        shownSongs.append(songDescription);
        console.log(this.globalAlbums);
        $.each(songs, function(key, song){
            shownSongs.append("<input id='song"+song.id+"' class='songPart edit' DATA-albumKey = '"+albumKey+"'DATA-songKey = '"+key+"' name='albumSongs' value='"+song.title+"' type='text' disabled='disabled'>")
                .change(albums.globalAlbums[albumKey].songs[key].title = $("#song"+song.id).value);
            console.log(albums.globalAlbums[albumKey].songs[key].title);
        })
    },



    clearSongs: function(){
        $("#songList").empty();
    },

    addAlbum: function(){

    },

    clickSaveButton: function(albumKey){
        albums.disableEditMode();
        var album = this.globalAlbums[albumKey];
        this.globalAlbums[albumKey].title = document.getElementsByName("albumTitle").value;
        var songs = $(".songPart");
        $.each(songs, function(song){
            song = songs.value;
        })
        console.log("object songs: " + songs);
        var album = this.globalAlbums[albumKey];
        console.log("Save albumKey: " + albumKey);
        console.log("albumTitle: " + album.title);
        albums.sendAlbumDAOController(album);
    },

    disableEditMode: function(){
        $(".edit").prop("disabled", true).removeClass("enableEdit");
        albums.disableNewButton();

    },

    logout: function(){
        window.location.href = "/view/RaTunesRegistration.jsp";
    },


    sendAlbumDAOController: function(album){
        $.ajax({
            url: "AlbumDAOController",
            dataType: 'json',
            data: {
                jsonAlbum: album
            },
            type: 'POST',
            error: function () {

                alert("Error Occured");
            },
            success: function () {
            }
        });
    },
};

