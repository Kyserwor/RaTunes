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
                albums.albumsToList(data)
            }
        });
    },

    albumsToList: function(albumList) {
        this.clearIdDiv();
        $.each(albumList.albums, function (key, value) {
            albums.printAlbumTitle(value, key)
        })
        this.globalAlbums = albumList.albums;
    },

    clearIdDiv: function() {
        $("#albumList").empty();
    },

    printAlbumTitle: function(album, key) {
        var ul = $("#albumList");
        var li = $("<input id='albumTitleId' type='button' " + album.id + " class='albumTitle albumButton' onclick='albums.showAlbum(" + key + ")' value='" + album.title + "'><br>");
        ul.append(li);
    },

    showAlbum: function(albumId) {
        albums.clearEditMode();
        albums.showEditMode();
        albums.clearAlbumCover();
        albums.showAlbumCover(albumId);
        albums.showAlbumInfo(albumId);
        albums.showSongs(this.globalAlbums[albumId].songs);
    },

    showEditMode: function(){
        var editorContain = $(".editorContain");
        var editButtons = $("<i class='editButton fa fa-pencil-square-o fa-2x' onclick='albums.enableEditMode()' title='edit Album'></i>"
                                + "<i class='saveButton fa fa-archive fa-2x' onclick='albums.clickSaveButton()' title='Saving changed files'></i>"
                                + "<div class='newButton'></div>");
        editorContain.append(editButtons);
    },

    clearEditMode: function(){
        $(".editorContain").empty();
    },

    showAlbumCover: function(albumId){
        var coverTitle = $("<h4 class='albumCoverTitle'>" + this.globalAlbums[albumId].title + "</h4>");
        var albumCover = $("<div id='albumCover' class='albumCover'></div>");
        $("#albumCover").append(albumCover);
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
        $(".editorContain").append("<i id='newSongButton' title='new Song' class='fa fa-file fa-2x' onclick='albums.addNewSong()'></i>");
    },

    enableNewAlbumButton: function(){
        $(".editorContain").append("<i id='newAlbumButton' title='new Album' class='fa fa-file fa-2x' onclick='albums.addNewAlbum()'></i>")
    },

    disableNewButton: function(){
        $(".newButton").empty();
    },

    addNewSong: function () {
        $("#songList").append("<input id='newSong' class='songPart edit enableEdit' name='albumSongs' value='new Song' type='text'>");
    },

    addNewAlbum: function(){
    },

    showSongs: function(songList){
        albums.clearSongs();
        var songDescription = $("<i class='songDescription'><strong>Song</strong>");
        var shownSongs = $("#songList");
        shownSongs.append(songDescription);
        $.each(songList, function(key, value){
            shownSongs.append("<input id='"+value.id+"' class='songPart edit' name='albumSongs' value='"+value.title+"' type='text' disabled='disabled'>");
        })
    },

    clearSongs: function(){
        $("#songList").empty();
    },

    clickSaveButton: function(){
        albums.enableLoadArea();
        albums.disableEditMode();
        var albumTitle = document.getElementsByName("albumTitle");
        var albumId = $(albumTitle).attr("id");
        this.globalAlbums[albumId].title = albumTitle;
        this.globalAlbums[albumId].artists = document.getElementsByName("albumArtists");
        this.globalAlbums[albumId].songs = document.getElementsByName("albumSongs");
        albums.sendAlbumDAOController(albumId);
    },

    disableEditMode: function(){
        $(".edit").prop("disabled", true).removeClass("enableEdit");
        albums.disableNewButton();

    },

    enableLoadArea: function(){
        $(".editorContain").append("<div id='loadToken'></div>");
        $("#loadToken").append("<i class='loadToken fa fa-spinner fa-spin fa-2x' title='load'></i>");
    },


    logout: function(){
        window.location.href = "/view/RaTunesRegistration.jsp";
    },


    sendAlbumDAOController: function(albumId){
        var editedAlbum = JSON.stringify(this.globalAlbums[albumId - 1]);
        $.ajax({
            url: "AlbumDAOController",
            dataType: 'json',
            data: {
                jsonAlbum: editedAlbum
            },
            type: 'POST',
            error: function () {

                alert("Error Occured");
            },
            success: function () {
                albums.savedData();
            }
        });
    },
};

