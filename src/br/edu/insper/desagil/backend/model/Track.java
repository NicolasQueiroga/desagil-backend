package br.edu.insper.desagil.backend.model;

public class Track 
{
	
	private Artist artist;
	private String name;
	private int duration;
	
	
	public Track(Artist artist, String name, int duration) 
	{
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}


	public Artist getArtist() 
	{
		return this.artist;
	}

	public String getName() 
	{
		return this.name;
	}

	public int getDuration() 
	{
		return this.duration;
	}

	
	public String getDurationString()
	{
		String seconds;
		int m = this.duration % 3600 / 60;
		int s = this.duration % 60;
		if (s < 10)
		{
			seconds = "0" + Integer.toString(s);
		}
		else
		{
			seconds = Integer.toString(s);
		}
		String out = Integer.toString(m) + ":" + seconds;
		return out;
	}
	
	public String getFullArtistName()
	{
		return this.artist.getName();
	}
	
}
