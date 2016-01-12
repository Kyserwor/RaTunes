package de.ratunes.album;

import java.util.Collection;

import mvc.model.Album;

public interface AlbumRepository {
	void create(Album album);
	Collection<Album> list();
}