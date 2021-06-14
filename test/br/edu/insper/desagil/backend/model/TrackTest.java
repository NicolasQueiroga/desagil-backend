package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest 
{
	
	private Artist artist;
	private Track track;
	
	
	@BeforeEach
	void setUp() 
	{
		artist = new Artist("Anitta");
	}

	@Test
	void testZeroSeconds() 
	{
		track = new Track(artist, "t1", 0);
		
		String duration = track.getDurationString();
		String expected = "0:00";
		assertEquals(expected, duration);
	}

	@Test
	void testFiveSeconds() 
	{
		track = new Track(artist, "t2", 5);
		
		String duration = track.getDurationString();
		String expected = "0:05";
		assertEquals(expected, duration);
	}

	@Test
	void testTwentyFiveSeconds() 
	{
		track = new Track(artist, "t3", 25);
		
		String duration = track.getDurationString();
		String expected = "0:25";
		assertEquals(expected, duration);
	}

	@Test
	void testOneMinuteZeroSeconds() 
	{
		track = new Track(artist, "t4", 60);
		
		String duration = track.getDurationString();
		String expected = "1:00";
		assertEquals(expected, duration);
	}

	@Test
	void testOneMinuteFiveSeconds() 
	{
		track = new Track(artist, "t5", 65);
		
		String duration = track.getDurationString();
		String expected = "1:05";
		assertEquals(expected, duration);
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() 
	{
		track = new Track(artist, "t6", 85);
		
		String duration = track.getDurationString();
		String expected = "1:25";
		assertEquals(expected, duration);
	}

	@Test
	void testTwoMinutesZeroSeconds() 
	{
		track = new Track(artist, "t7", 120);
		
		String duration = track.getDurationString();
		String expected = "2:00";
		assertEquals(expected, duration);
	}

	@Test
	void testTwoMinutesFiveSeconds() 
	{
		track = new Track(artist, "t8", 125);
		
		String duration = track.getDurationString();
		String expected = "2:05";
		assertEquals(expected, duration);
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() 
	{
		track = new Track(artist, "t9", 145);
		
		String duration = track.getDurationString();
		String expected = "2:25";
		assertEquals(expected, duration);
	}

	@Test
	void testOneCollaborator() 
	{
		List<Artist> colabs = new ArrayList<>();
		Artist a = new Artist("Becky G");
		colabs.add(a);
		CollaborationTrack track = new CollaborationTrack(artist, "t10", 300, colabs);
		
		String name = track.getFullArtistName();
		String expected = "Anitta (feat. Becky G)";
		assertEquals(expected, name);
	}

	@Test
	void testTwoCollaborators() 
	{
		List<Artist> colabs = new ArrayList<>();
		Artist a = new Artist("Ludmilla");
		Artist b = new Artist("Snoop Dog");
		colabs.add(a);
		colabs.add(b);
		CollaborationTrack track = new CollaborationTrack(artist, "t11", 300, colabs);
		
		String name = track.getFullArtistName();
		String expected = "Anitta (feat. Ludmilla, Snoop Dog)";
		assertEquals(expected, name);
	}
	
}
