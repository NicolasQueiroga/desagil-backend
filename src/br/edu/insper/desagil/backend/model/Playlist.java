package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist 
{

	public int id;
	public List<Track> tracks;
	public Map<String, Integer> ratings;
	
	
	public Playlist(int id) 
	{
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}


	public int getId() 
	{
		return this.id;
	}

	public List<Track> getTracks() 
	{
		return this.tracks;
	}

	public Map<String, Integer> getRatings() 
	{
		return this.ratings;
	}
	
	
	public void addTrack(Track track)
	{
		this.tracks.add(track);
	}
	
	public void putRating(String user, int rating)
	{
		this.ratings.put(user, rating);
	}
	
	public double averageRatings()
	{
		double sum = 0;
		double count = 0;
		for (int rating : this.ratings.values())
		{
			sum += rating;
			count++;
		}
		double average = sum/count;
		
		int i = (int) average;
		double d = average - i;
		if (d < 0.26)
		{
			average -= d;
		}
		else if ((d >= 0.26) && (d < 0.74))
		{
			average = i + 0.5;
		}
		else if (d >= 0.74)
		{
			average = i + 1;
		}
		return average;
	}
	
	
}
