package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest 
{
	
	private static double DELTA = 0.000001;
	private Artist a;
	private Track t;
	private Playlist pl;

	@BeforeEach
	void setUp() 
	{
		a = new Artist("Anitta");
		t = new Track(a, "t", 300);
		pl = new Playlist(1);
		pl.addTrack(t);
	}

	@Test
	void testRoundDownToZero() 
	{
		pl.putRating("user1", 1);
		pl.putRating("user2", 2);
		pl.putRating("user3", 3);
		pl.putRating("user4", 3);
		
		double mean = pl.averageRatings();
		double expected = 2.0;
		assertEquals(expected, mean, DELTA);
	}

	@Test
	void testRoundUpToHalf() 
	{
		pl.putRating("user1", 1);
		pl.putRating("user2", 2);
		pl.putRating("user3", 1);
		
		double mean = pl.averageRatings();
		double expected = 1.5;
		assertEquals(expected, mean, DELTA);
	}

	@Test
	void testRoundDownToHalf() 
	{
		pl.putRating("user1", 1);
		pl.putRating("user2", 2);
		pl.putRating("user3", 2);
		
		double mean = pl.averageRatings();
		double expected = 1.5;
		assertEquals(expected, mean, DELTA);
	}

	@Test
	void testRoundUpToOne() 
	{
		pl.putRating("user1", 1);
		pl.putRating("user2", 1);
		pl.putRating("user3", 2);
		pl.putRating("user4", 3);
		
		double mean = pl.averageRatings();
		double expected = 2.0;
		assertEquals(expected, mean, DELTA);
	}
}
