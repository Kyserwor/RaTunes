package de.ratunes.album;

import java.util.ArrayList;
import java.util.Collection;

import mvc.model.Album;

public class AlbumMemoryRepository implements AlbumRepository{
	private Collection<Album> albumRepository = new ArrayList<Album>();

	@Override
	public void create(Album album) {
		albumRepository.add(album);
	}

	@Override
	public Collection<Album> list() {
		return albumRepository;
	}
}
