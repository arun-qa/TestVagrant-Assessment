package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedSongs {

	private int capacity;
	private Map<String, LinkedList<String>> userSongsMap;

	public RecentlyPlayedSongs(int capacity) {
		this.capacity = capacity;
		this.userSongsMap = new HashMap<String, LinkedList<String>>();

	}

	public void playSong(String user, String song) {
		if (!userSongsMap.containsKey(user)) {
			userSongsMap.put(user, new LinkedList<String>());
		}

		LinkedList<String> playlist = userSongsMap.get(user);

		// Remove the song if it's already in the playlist
		playlist.remove(song);

		// Add the song to the front of the playlist
		playlist.addLast(song);

		// Remove the least recently played song if the playlist exceeds capacity
		if (playlist.size() > capacity) {
			playlist.removeFirst();
		}
	}

	public List<String> getRecentlyPlayedSongs(String user) {
		if (userSongsMap.containsKey(user)) {
			return userSongsMap.get(user);
		} else {

			return new ArrayList<String>();

		}
	}

}
